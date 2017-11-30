package com.learnmyfirstprg.learncamelsimplefile;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;

public class UnmarshallUsingXStream extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> reference = new HashMap<String, String>();
		reference.put("employee", Employee.class.getName());
		XStreamDataFormat xstreamDataFormat = new XStreamDataFormat();
		xstreamDataFormat.setAliases(reference);
		xstreamDataFormat.setPermissions(Employee.class.getName());

		from("direct:xmlinput").unmarshal(xstreamDataFormat)
				.to("log:?level=INFO&showBody=true").to("mock:output");
	}

}
