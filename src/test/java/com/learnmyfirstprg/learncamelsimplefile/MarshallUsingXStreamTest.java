package com.learnmyfirstprg.learncamelsimplefile;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshallUsingXStreamTest extends CamelTestSupport {
	public RoutesBuilder createRouteBuilder() throws Exception {
		return new MarshallUsingXStream();
	}
	@Test
	public void marshallXstreamTest() throws InterruptedException {
		String expected = "<?xml version='1.0' encoding='UTF-8'?><com.learnmyfirstprg.learncamelsimplefile.Employee><name>dilip</name><id>123</id><joinDate>01APR2017</joinDate></com.learnmyfirstprg.learncamelsimplefile.Employee>";
		MockEndpoint mock = getMockEndpoint("mock:output");
		mock.expectedBodiesReceived(expected);

		template.sendBody("direct:csvinput", "dilip,123,01APR2017");

		assertMockEndpointsSatisfied();
	}

	@Test
	public void marshalXstreamCustomXmLlTest() throws InterruptedException {

		String expected = "<?xml version='1.0' encoding='UTF-8'?><employee><name>dilip</name><id>123</id><joinDate>01APR2017</joinDate></employee>";
		MockEndpoint mock = getMockEndpoint("mock:output");
		mock.expectedBodiesReceived(expected);

		template.sendBody("direct:csvinput", "dilip,123,01APR2017");

		assertMockEndpointsSatisfied();
	}
}
