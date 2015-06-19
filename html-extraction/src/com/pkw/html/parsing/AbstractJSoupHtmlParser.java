package com.pkw.html.parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public abstract class AbstractJSoupHtmlParser implements HtmlParser {

	protected Document document;

	protected AbstractJSoupHtmlParser(String html) {
		document = Jsoup.parse(html);
		document.outputSettings().prettyPrint(false);
	}

	@Override
	public String getHTMLContentOfFirst(String tagName) {
		return getHTMLContentOfNthOccurance(tagName, 1);
	}

	@Override
	public String getHTMLContentOfNthOccurance(String tagName, int n) {
		Elements elements = document.getElementsByTag(tagName);
		try {
			return elements.get(n - 1).html();
		} catch (IndexOutOfBoundsException e) {
			return "";
		}
	}
}
