package com.springthreading.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Contém a definição dos Beans de TaskExecutor.
 * 
 */
@EnableAsync
@Configuration
public class ThreadConfig {
	
	@Bean(name = "defaultTaskExecutor")
	public TaskExecutor threadPoolTaskExecutor() {
		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(4);
		executor.setMaxPoolSize(4);
		executor.setThreadNamePrefix("default_task_executor_thread");
		executor.initialize();
		
		return executor;
	}
	
	@Bean(name = "specificTaskExecutor")
	public TaskExecutor specificTaskExecutor() {
		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setThreadNamePrefix("specific_task_executor_thread");
        executor.initialize();
        
        return executor;
	}

}
