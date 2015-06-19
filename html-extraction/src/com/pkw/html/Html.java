package com.pkw.html;

import com.pkw.html.parsing.HtmlParser;
import com.pkw.html.parsing.JSoupHtmlObjectParser;

public class Html {

	private String html;

	public static Html from(String html) {
		return new Html(html);
	}

	private Html(String html) {
		this.html = html;
	}

	public String html() {
		return html;
	}

	public HtmlParser getParser() {
		return JSoupHtmlObjectParser.createFor(this);
	}

}
