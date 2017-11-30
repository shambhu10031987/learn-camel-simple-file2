package com.learnmyfirstprg.learncamelsimplefile;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyDirectProcessorRouteTest extends CamelTestSupport {

	public RoutesBuilder createRouteBuilder() throws Exception {
		return new CamelModifyDirectProcessorRoute();
	}
	@Test
	public void processTest() {
		String expected = "123:dilip:12JAN2017";
		String output = (String) template.requestBody("direct:processorInput",
				"123,dilip,12JAN2017");
		System.out.println("output :" + output);
		assertEquals(expected, output);
	}

	@Test
	public void processTestUsingMock() throws InterruptedException {
		String expected = "123:dilip:12JAN2017";
		MockEndpoint mock = getMockEndpoint("mock:output");
		mock.expectedBodiesReceived(expected);
		String output = (String) template.requestBody("direct:processorInput",
				"123,dilip,12JAN2017");
		System.out.println("output :" + output);
		assertMockEndpointsSatisfied();
		// assertEquals(expected, output);
	}
}
