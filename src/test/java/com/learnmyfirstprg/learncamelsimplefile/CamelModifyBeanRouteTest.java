package com.learnmyfirstprg.learncamelsimplefile;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyBeanRouteTest extends CamelTestSupport {
	@Override
	public RoutesBuilder createRouteBuilder() throws Exception {
		return new CamelModifyBeanRoute();

	}
	@Test
	public void beanTest() {
		String expected = "123*dilip*12FEB2011";
		String output = (String) template.requestBody("direct:beanInput",
				"123,dilip,12FEB2011");
		System.out.println("***********output*****" + output);
		assertEquals(expected, output);
	}

}
