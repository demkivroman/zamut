package com.example.zamut.util;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Util {
	public long getTotalAmount(List<String> sums) {
		return sums.stream().mapToLong(Long::valueOf).sum();
	}
}
