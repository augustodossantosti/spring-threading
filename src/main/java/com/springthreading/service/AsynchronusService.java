package com.springthreading.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.springthreading.domain.MyDomainClass;
import com.springthreading.domain.MyThread;

@Service
public class AsynchronusService {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	@Qualifier("defaultTaskExecutor")
	private TaskExecutor taskExecutor;
	
	/**
	 * Realiza a execução de uma Thread através de um TaskExecutor
	 * previamente injetado. A classe a ser executada precisa
	 * implementar Runnable.
	 */
	public void executeAsyncThread() {
		
		final MyThread myThread = applicationContext.getBean(MyThread.class);
		taskExecutor.execute(myThread);
	}
	
	/**
	 * Instância automaticamente um TaskExecutor específico para 
	 * a execução do método. Não é necessário que a classe a ser
	 * executada implemente Runnable.
	 */
	@Async("specificTaskExecutor")
	public void executeAsyncMethod() {
		
		final MyDomainClass domainClass = applicationContext.getBean(MyDomainClass.class);
		domainClass.sayHello();
	}

}
