package com.pkw.html.extraction;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import com.pkw.html.parsing.JSoupHtmlParser;

public class Main {

	public static void main(String[] args) {
		
		String searchFor = "batman";
		
		String priceCeiling = "0.25";
		
		String html = getHTML("http://www.ebay.com/sch/i.html?_from=R40&_sacat=0&LH_Auction=1&_sop=1&LH_FS=1&_nkw=" + searchFor + "&_dcat=158671&rt=nc&_mPrRngCbx=1&_udlo&_udhi=" + priceCeiling);

		JSoupHtmlParser test = JSoupHtmlParser.createFor(html);

		System.out.println(JSoupHtmlParser.createFor(test.getHTMLContentOfNthOccurance("ul", 9)).getHTMLContentOfFirst("li"));

	}

	public static String getHTML(String argUrl) {
		String content = null;
		URLConnection connection = null;
		try {
			connection = new URL(argUrl).openConnection();
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(connection.getInputStream());
			scanner.useDelimiter("\\Z");
			content = scanner.next();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return content;
	}

}
