package com.learnmyfirstprg.learncamelsimplefile;

import java.io.File;

import org.apache.camel.builder.RouteBuilder;
import org.junit.Test;

import com.learnmyfirstprg.learncamelsimplefile.AppRoute;

public class AppRouteTest
		extends
			org.apache.camel.test.junit4.CamelTestSupport {

	protected RouteBuilder createRouteBuilder() throws Exception {
		return new AppRoute();

	}
	@Test
	public void checkFileExistsInOutputDirectory() throws InterruptedException {
		Thread.sleep(5000);

		File file = new File("data/output");
		assertTrue(file.isDirectory());
		assertEquals(2, file.listFiles().length);
	}
}
