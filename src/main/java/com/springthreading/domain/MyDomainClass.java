package com.springthreading.domain;

import org.springframework.stereotype.Component;

@Component
public class MyDomainClass {
	
	public void sayHello() {
		System.out.println("Hello from Async method!");
	}

}
