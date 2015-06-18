package com.pkw.html.extraction;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import com.pkw.html.parsing.JSoupHtmlParser;

public final class TestApplication {

    private static final int NTH_OCCURANCE = 9;
    private static final String SEARCH_FOR = "{searchFor}";
    private static final String PRICE_CEILING = "{priceCeiling}";
    private static final String EBAY_URL = "http://www.ebay.com/sch/i.html?_from=R40&_sacat=0&LH_Auction=1&_sop=1&LH_FS=1&_nkw="
            + SEARCH_FOR + "&_dcat=158671&rt=nc&_mPrRngCbx=1&_udlo&_udhi=" + PRICE_CEILING;

    private TestApplication() {
        super();
    }

    public static void main(String[] args) {
        JSoupHtmlParser parser = JSoupHtmlParser.createFor(getEbayHTML("batman", "0.25"));
        System.out.println(JSoupHtmlParser.createFor(parser.getHTMLContentOfNthOccurance("ul", NTH_OCCURANCE))//
                .getHTMLContentOfFirst("li"));
    }

    private static String getEbayHTML(String searchFor, String priceCeiling) {
        return getHTML(EBAY_URL.replace(SEARCH_FOR, searchFor).replace(PRICE_CEILING, priceCeiling));
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
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return content;
    }

}
