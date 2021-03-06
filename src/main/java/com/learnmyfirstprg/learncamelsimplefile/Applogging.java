package com.learnmyfirstprg.learncamelsimplefile;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Hello world!
 *
 */
public class Applogging {
	public static void main(String[] args) {
		// System.out.println("Hello World!");

		CamelContext context = new DefaultCamelContext();

		try {
			context.addRoutes(new RouteBuilder() {
				@Override
				public void configure() throws Exception {
					from("file:data/input?noop=true").to(
							"log:?level=INFO&showBody=true&showHeaders=true")

							// log(
							// "Received Message is ${body} and headers are
							// ${header}")

							.to("file:data/output");
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
