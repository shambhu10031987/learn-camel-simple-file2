package com.learnmyfirstprg.learncamelsimplefile;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyTransformRouteTest extends CamelTestSupport {

	public RoutesBuilder createRouteBuilder() throws Exception {
		return new CamelModifyTransformRoute();

	}
	@Test
	public void transformTestUsingMock() throws InterruptedException {
		String expected = "123*dilip*12JAN2017";
		MockEndpoint mock = getMockEndpoint("mock:output");
		mock.expectedBodiesReceived(expected);
		// System.out.println(moc);
		template.sendBody("direct:transformInput", "123,dilip,12JAN2017");

		// System.out.println("output :" + output);
		assertMockEndpointsSatisfied();
		// assertEquals(expected, output);

	}
}