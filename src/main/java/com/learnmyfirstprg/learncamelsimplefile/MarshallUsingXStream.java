package com.learnmyfirstprg.learncamelsimplefile;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;

public class MarshallUsingXStream extends RouteBuilder {

	public void configure() throws Exception {
		from("direct:csvinput").process(new CustomProcessorXStream()).marshal()
				.xstream()
				// marshal(populateStreamDef()).to("log:?level=INFO&showBody=true")
				.to("mock:output");

	}

	private XStreamDataFormat populateStreamDef() {
		// TODO Auto-generated method stub
		XStreamDataFormat xstreamDefinition = new XStreamDataFormat();
		Map<String, String> aliases = new HashMap<String, String>();
		aliases.put("employee", Employee.class.getName());
		xstreamDefinition.setAliases(aliases);
		return xstreamDefinition;
	}
}
