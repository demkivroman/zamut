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
    	List<Param> price = new ArrayList<Param>();
		List<Param> quantity = new ArrayList<Param>();
		
		saveParamsToMaps(allParams, price, quantity);
		double totalSum = getTotalAmount(price, quantity);
		String message = allParams.get("message").trim();
		
		
		Sum entry = new Sum(totalSum, LocalDate.now(),
				message.isEmpty() ? null : message, consumerRepository.findById(consumerId).get());
		
		Sum savedEntity = sumRepository.save(entry);
		
    }
    
    /*
	 * Method that calculate total amount according to form entries
	 */
	private double getTotalAmount(List<Param> price, List<Param> quantity) {
		double sum = 0d;
		for (int i = 0; i < price.size(); i++) {
			if (price.get(i).value != "") {
				sum += Double.valueOf(price.get(i).value) * Double.valueOf(quantity.get(i).value);
			}
		}
		return sum;
	}
	
    /*
	 * Method for collapsing set of parameters and save in two different lists
	 */
	private void saveParamsToMaps(Map<String, String> inParams, List<Param> price, List<Param> quantity) {
		
		for (Map.Entry<String, String> entry : inParams.entrySet()) {
			if (!entry.getKey().equals("message")) {
				String[] paramArr = entry.getKey().split("\\.");
				if (paramArr[1].equals("price")) {
					price.add(new Param(paramArr[0], entry.getValue()));
				} else if (paramArr[1].equals("quantity")) {
					quantity.add(new Param(paramArr[0], entry.getValue()));
				}
			}
		}
	}
    
    /*
	 * Class for storing parameters from form [add-invoice]
	 */
	private class Param {
		String paramId;
		String value;
		
		public Param(String id, String value) {
			this.paramId = id;
			this.value = value;
		}
	}
}
