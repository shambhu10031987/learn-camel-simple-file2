package com.learnmyfirstprg.learncamelsimplefile;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnmarshallUsingXStreamTest extends CamelTestSupport {
	public RouteBuilder createRouteBuilder() throws Exception {
		return new UnmarshallUsingXStream();

	}
	@Test
	public void unMarshallTest() throws InterruptedException {
		Employee employee = new Employee();
		employee.setName("Daniel");
		employee.setId("123");
		employee.setJoinDate("01APR2017");
		MockEndpoint mock = getMockEndpoint("mock:output");
		mock.expectedBodiesReceived(employee.toString());
		template.sendBody("direct:xmlinput",
				" <employee><name>Daniel</name><id>123</id><joinDate>01APR2017</joinDate></employee>");

		assertMockEndpointsSatisfied();
	}

}
