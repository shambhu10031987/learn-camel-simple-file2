package com.learnmyfirstprg.learncamelsimplefile;

import org.apache.camel.builder.RouteBuilder;

public class SampleDirectRouteApp extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("direct:sampleInput")
				.log("recived message is ${body} and Headers are ${headers}")
				.to("file:sampleOutput?fileName=output.txt");

	}

}
