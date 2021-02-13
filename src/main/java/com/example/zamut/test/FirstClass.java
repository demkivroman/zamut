package com.example.zamut.test;

import org.springframework.beans.factory.annotation.Autowired;

public class FirstClass {
	
	private int value_1;
	private int value_2;
	
	private FirstClass first;
	private ThirtClass thirt;
	
	@Autowired
	private Same same;
	
	//@Autowired
	//public void setSame(Same same) {};
	
	public void method() {
		first.value_1 = 1;
		first.value_2 = 2;
	}
	public int getValue(int val) {
		return 1;
	}
	
	
	public void printValues() {
		method();
		System.out.println(value_1);
		System.out.println(value_2);
	}
	
	public void printFirstValues() {
		System.out.println(first.value_1);
		System.out.println(first.value_2);
	}
	
	

	public FirstClass() {
		super();
	}

	public FirstClass(FirstClass first) {
		super();
		this.first = first;
	}

	public FirstClass(ThirtClass thirt) {
		super();
		this.thirt = thirt;
	}
	
}
