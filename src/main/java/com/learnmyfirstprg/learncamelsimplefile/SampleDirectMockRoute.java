package com.learnmyfirstprg.learncamelsimplefile;

import org.apache.camel.builder.RouteBuilder;

public class SampleDirectMockRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub

		from("direct:sampleInput")
				.log("Received Message is ${body} and Headers are ${headers}")
				.to("mock:output420");

	}

}
