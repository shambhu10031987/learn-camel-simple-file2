package com.learnmyfirstprg.learncamelsimplefile;

import java.util.StringTokenizer;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CustomProcessorXStream implements Processor {

	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		String newBody = exchange.getIn().getBody(String.class);
		StringTokenizer tokenizer = new StringTokenizer(newBody, ",");
		Employee employee = new Employee();
		while (tokenizer.hasMoreElements()) {
			employee.setName((String) tokenizer.nextElement());
			employee.setId((String) tokenizer.nextElement());
			employee.setJoinDate((String) tokenizer.nextElement());
		}
		exchange.getIn().setBody(employee);
	}

}
