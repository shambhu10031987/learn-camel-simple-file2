package com.learnmyfirstprg.learncamelsimplefile;

import org.apache.camel.builder.RouteBuilder;

public class CamelModifyFileProcessorRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("file:data/newfolder?noop=true").process(new CamelFileProcessor())
				.log("Received message ${body} and Headers are ${headers}")
				.to("file:data/newfolder2?fileName=output.txt");

	}

}
