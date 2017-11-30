package com.learnmyfirstprg.learncamelsimplefile;

import java.io.File;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyFileProcessorRouteTest extends CamelTestSupport {

	public RoutesBuilder createRouteBuilder() throws Exception {
		return new CamelModifyFileProcessorRoute();
	}
	@Test
	public void processorTest() throws InterruptedException {

		String expected = "123:dilip:12JAN2017\n" + "456:adam:12JAN2017\n";
		MockEndpoint mock = getMockEndpoint("mock:newfolder2");

		mock.expectedBodiesReceived(expected);
		Thread.sleep(5000);
		File file = new File("data/newfolder2");
		assertTrue(file.isDirectory());
		assertEquals(1, file.listFiles().length);
		assertMockEndpointsSatisfied();
	}
}
