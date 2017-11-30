package com.learnmyfirstprg.learncamelsimplefile;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CamelExampleProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		try {
			String oldValue = (String) exchange.getIn().getBody();
			System.out.println("old value is: " + oldValue);
			String newValue = oldValue.replace(",", ":");
			System.out.println("new value is :" + newValue);
			exchange.getIn().setBody(newValue);
		} catch (Exception e) {
			System.out.println("Excetion in processor is:" + e);
		}

	}

}
