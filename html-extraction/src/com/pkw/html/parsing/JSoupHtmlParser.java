package com.pkw.html.parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JSoupHtmlParser implements HtmlParser {

	Document document;

	public static JSoupHtmlParser createFor(String html) {
		return new JSoupHtmlParser(html);
	}

	public JSoupHtmlParser(String html) {
		document = Jsoup.parse(html);
		document.outputSettings().prettyPrint(false);
	}

	@Override
	public String getHTMLContentOfFirst(String tagName) {
		Elements elements = document.getElementsByTag(tagName);
		try {
			return elements.get(0).html();
		} catch (IndexOutOfBoundsException e) {
			return "";
		}
	}
	
	public String getHTMLContentOfNthOccurance(String tagName, int n) {
		Elements elements = document.getElementsByTag(tagName);
		try {
			return elements.get(n).html();
		} catch (IndexOutOfBoundsException e) {
			return "";
		}
	}
	
}
