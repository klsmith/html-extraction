package com.pkw.html.parsing;

public interface HtmlParser {

	public String getHTMLContentOfFirst(String tag);

	public String getHTMLContentOfNthOccurance(String tag, int nthOccurance);

}
