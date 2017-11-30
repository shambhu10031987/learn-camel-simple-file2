package com.learnmyfirstprg.learncamelsimplefile;

public class CamelBean {

	public String map(String input) {
		System.out.println("oldInput****** " + input);
		String newBody = input.replace(",", "*");
		System.out.println("New output******" + newBody);
		return newBody;

	}
	public String map2(String input) {

		return "shambhu**************";

	}
}
