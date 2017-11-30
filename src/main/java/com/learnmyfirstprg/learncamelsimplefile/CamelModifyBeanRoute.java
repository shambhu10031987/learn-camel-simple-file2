package com.learnmyfirstprg.learncamelsimplefile;

import org.apache.camel.builder.RouteBuilder;

public class CamelModifyBeanRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("direct:beanInput")
				// .bean(new CamelBean())
				.bean(new CamelBean(), "map2")
				.log("Received Message is ${body} and Headers are ${headers}")
				.to("mock:output");

	}

}
