package com.pkw.html.parsing;

import com.pkw.html.Html;

public class JSoupHtmlObjectParser extends AbstractJSoupHtmlParser {

	public static JSoupHtmlObjectParser createFor(Html html) {
		return new JSoupHtmlObjectParser(html);
	}

	private JSoupHtmlObjectParser(Html html) {
		super(html.html());
	}
}
