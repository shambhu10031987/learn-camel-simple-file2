package com.learnmyfirstprg.learncamelsimplefile;

import java.io.File;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learnmyfirstprg.learncamelsimplefile.SampleDirectRouteApp;

public class SampleDirectRouteAppTest extends CamelTestSupport {

	protected RouteBuilder createRouteBuilder() throws Exception {
		return new SampleDirectRouteApp();
	}
	@Test
	public void sampleRouteTest() throws InterruptedException {
		template.sendBody("direct:sampleInput", "hello Shambhu");
		File file = new File("sampleOutput");
		assertTrue(file.isDirectory());

		Exchange exchange = consumer.receive("file:sampleOutput");
		System.out.println(
				"*******Received body is****** :" + exchange.getIn().getBody());
		System.out.println("*******File Name is********** :"
				+ exchange.getIn().getHeader("CamelFileName"));
		assertEquals("output.txt", exchange.getIn().getHeader("CamelFileName"));

	}
}
