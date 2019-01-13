package com.ensa;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest  {

	public static void main(String[] args) {
		
		try {
			
	
			
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/ensa/config/Spring-conf.xml");

			Job job = (Job) ctx.getBean("importPersonnes");
	        JobParametersBuilder jobBuilder= new JobParametersBuilder();
	        JobParameters jobParameters = jobBuilder.toJobParameters();
			JobLauncher jobLauncher = (JobLauncher) ctx.getBean("jobLauncher"); 
			JobExecution execution = jobLauncher.run(job, jobParameters);
			System.out.println("Completion Status : " + execution.getStatus());
//	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			

	}

}
