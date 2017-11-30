package com.learnmyfirstprg.learncamelsimplefile;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class XML2JSONRouteTest extends CamelTestSupport {

	protected RouteBuilder createRouteBuilder() throws Exception {
		return new XML2JSONRoute();
	}
	@Test
	public void marshalEmployeeJSON2XML() {
		String expected = "{\"id\":\"123 \",\"name\":\"ABC\",\"type\":\"senior\"}";
		String request = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Employee><id>123 </id><name>ABC</name><type>senior</type></Employee>\r\n";

		final String response = template.requestBody(
				"direct:marshalEmployeexml2json", request, String.class);
		System.out.println("response is : " + response);

		assertEquals(expected, response);
	}
}
