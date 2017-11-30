package com.learnmyfirstprg.learncamelsimplefile;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class SampleDirectMockRouteTest extends CamelTestSupport {

	public RoutesBuilder createRouteBuilder() throws Exception {
		return new SampleDirectMockRoute();
	}
	@Test
	public void sampleDirectMockTest() throws InterruptedException {
		String expected = "Hello1";
		MockEndpoint mock = getMockEndpoint("mock:output420");
		mock.expectedBodiesReceived(expected);
		String input = "Hello";
		template.sendBody("direct:sampleInput", input);
		assertMockEndpointsSatisfied();
	}
}
