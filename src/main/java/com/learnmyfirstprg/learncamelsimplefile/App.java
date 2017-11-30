package com.learnmyfirstprg.learncamelsimplefile;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// System.out.println("Hello World!");

		CamelContext context = new DefaultCamelContext();

		try {
			context.addRoutes(new RouteBuilder() {
				@Override
				public void configure() throws Exception {
					from("file:data/input?noop=true").to("file:data/output");
					// ?
				}
			});

			context.start();
			Thread.sleep(5000);
			context.stop();

		} catch (Exception e) {
			System.out.println("Inside Exception : " + e);
		}

	}
}
