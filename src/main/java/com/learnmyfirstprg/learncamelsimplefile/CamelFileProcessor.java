package com.learnmyfirstprg.learncamelsimplefile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CamelFileProcessor implements Processor {
	String newValue = "";
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("exchange is:  " + exchange.getIn().getBody());
		File file = new File(
				(String) exchange.getIn().getHeaders().get("CamelFilePath"));
		String readLine = null;
		if (file != null) {
			FileReader file1 = new FileReader(file);
			BufferedReader reader = new BufferedReader(file1);
			while ((readLine = reader.readLine()) != null) {
				System.out.println("Read Line is " + readLine);
				String oldValue = readLine;
				System.out.println("old value is " + oldValue);
				newValue = newValue.concat(oldValue.replace(",", ":"))
						.concat("\n");
				System.out.println("newValue=  " + newValue);
				exchange.getIn().setBody(newValue);

			}

		}

	}

}
