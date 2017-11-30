package com.learnmyfirstprg.learncamelsimplefile;

import org.apache.camel.builder.RouteBuilder;

public class CamelModifyTransformRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("direct:transformInput")
				.transform(body().regexReplaceAll(",", "*")).to("mock:output");
	}

}
