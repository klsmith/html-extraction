package com.pkw.html.parsing;

public class JSoupHtmlParser extends AbstractJSoupHtmlParser {

	public static JSoupHtmlParser createFor(String html) {
		return new JSoupHtmlParser(html);
	}

	private JSoupHtmlParser(String html) {
		super(html);
	}

}
