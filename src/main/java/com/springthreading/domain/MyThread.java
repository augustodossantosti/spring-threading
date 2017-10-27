package com.springthreading.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MyThread implements Runnable {

	@Override
	public void run() {
		sayHello();
	}
	
	public void sayHello() {
		System.out.println("Hello from Thread!");
	}
	
}
