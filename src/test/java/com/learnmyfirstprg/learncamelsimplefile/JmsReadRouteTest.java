package com.learnmyfirstprg.learncamelsimplefile;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class JmsReadRouteTest extends CamelTestSupport {

	@Override
	protected RouteBuilder createRouteBuilder() throws Exception {
		return new JmsReadRoute();

	}

	@Test
	public void readMessageFromActiveMQ() throws InterruptedException {

		String expected = "shambhu1234";
		String response = consumer.receiveBody("direct:readQueue",
				String.class);
		System.out.println("The response is : " + response);
		assertEquals(expected, response);
	}
}