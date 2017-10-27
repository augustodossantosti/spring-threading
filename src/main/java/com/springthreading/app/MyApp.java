package com.springthreading.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springthreading.service.AsynchronusService;

/**
 * Realiza a execução dos métodos de AsynchronusService
 * após o carregamento do contexto do Spring.
 * 
 * @author augusto
 */
@Component
public class MyApp implements CommandLineRunner {
	
	@Autowired
	private AsynchronusService asyncService;

	@Override
	public void run(String... arg0) throws Exception {
		
		asyncService.executeAsyncMethod();
		asyncService.executeAsynchronously();
	}
	
}
