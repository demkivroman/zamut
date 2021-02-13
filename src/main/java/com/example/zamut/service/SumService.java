package com.example.zamut.service;

import com.example.zamut.model.*;
import com.example.zamut.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SumService {
	@Autowired
	private SumRepository sumRepository;

	@Autowired
	private ConsumerRepository consumerRepository;

	@Autowired
	private SumInvoiceRepository sumInvoice;

	@Autowired
	private InvoiceItemRepository invoiceItem;

	public List<Sum> getAllSum() {
		return sumRepository.findAll();
	}

	public List<Sum> getAllSumOneConsumer(Consumer consumer) {
		return sumRepository.findAllByConsumer(consumer);
	}

	public List<Sum> getActiveSum() {
		return sumRepository.getActiveSum();
	}

	public void saveInvoice(Map<String, String> allParams, long consumerId) {
		List<PriceParam> price = new ArrayList<PriceParam>();
		List<QuantityParam> quantity = new ArrayList<QuantityParam>();

		saveParamsToMaps(allParams, price, quantity);
		List<Param> correctParam = getCorrectParam(price, quantity);

		double totalSum = getTotalAmount(correctParam);
		String message = allParams.get("message").trim();

		Sum entry = new Sum(totalSum, LocalDate.now(), message.isEmpty() ? null : message,
				consumerRepository.findById(consumerId).get());

		Sum savedEntity = sumRepository.save(entry);
        
		for (int i = 0; i < correctParam.size(); i++) {
			InvoiceItem item = invoiceItem.findById(correctParam.get(i).price.id).get();
			SumInvoice invoice = new SumInvoice(savedEntity, item, correctParam.get(i).price.value,
					correctParam.get(i).quantity.value);

			sumInvoice.save(invoice);
		}

	}

	/*
	 * Method to join all parameters in to correct list
	 */
	private List<Param> getCorrectParam(List<PriceParam> price, List<QuantityParam> quantity) {
		List<Param> param = new ArrayList<Param>();
		for (int i = 0; i < price.size(); i++) {
			if (price.get(i).value > 0) {
				if (quantity.get(i).value > 0) {
					SumService.PriceParam pPar = new SumService.PriceParam(price.get(i).id, price.get(i).value);
					SumService.QuantityParam qPar = new SumService.QuantityParam(quantity.get(i).id,
							quantity.get(i).value);
					param.add(new SumService.Param(pPar, qPar));
				}
			}
		}
		return param;
	}

	/*
	 * Method that calculate total amount according to form entries
	 */
	private double getTotalAmount(List<Param> param) {
		double sum = 0d;
		for (int i = 0; i < param.size(); i++) {
			sum += param.get(i).price.value * param.get(i).quantity.value;
		}
		return sum;
	}

	/*
	 * Method for collapsing set of parameters and save in two different lists
	 */
	private void saveParamsToMaps(Map<String, String> inParams, List<PriceParam> price, List<QuantityParam> quantity) {

		for (Map.Entry<String, String> entry : inParams.entrySet()) {
			if (!entry.getKey().equals("message")) {
				String[] paramArr = entry.getKey().split("\\.");
				if (paramArr[1].equals("price")) {
					price.add(new PriceParam(Long.valueOf(paramArr[0]),
							(entry.getValue().isEmpty()) ? 0d : Double.valueOf(entry.getValue())));
				} else if (paramArr[1].equals("quantity")) {
					quantity.add(new QuantityParam(Long.valueOf(paramArr[0]),
							(entry.getValue().isEmpty()) ? 0 : Integer.valueOf(entry.getValue())));
				}
			}
		}
	}

	/*
	 * Class for storing parameters from form [add-invoice]
	 */
	private class Param {
		PriceParam price;
		QuantityParam quantity;

		public Param(PriceParam price, QuantityParam quantity) {
			super();
			this.price = price;
			this.quantity = quantity;
		}
	}

	/*
	 * Class for storing price parameters from form [add-invoice]
	 */
	private class PriceParam {
		long id;
		double value;

		public PriceParam(long id, double value) {
			this.id = id;
			this.value = value;
		}
	}

	/*
	 * Class for storing quantity parameters from form [add-invoice]
	 */
	private class QuantityParam {
		long id;
		int value;

		public QuantityParam(long id, int value) {
			this.id = id;
			this.value = value;
		}
	}
}
