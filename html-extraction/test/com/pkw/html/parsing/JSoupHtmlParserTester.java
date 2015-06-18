package com.pkw.html.parsing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class JSoupHtmlParserTester {

    public static final String HTML = "<html><body><h1>example</h1><p>Welcome to example!</p><div id=\"firstdiv\"><h2>hello world</h2><div><p>I'm Example<br/>Batman</p></div></div></body></html>";

    private JSoupHtmlParser parser;

    @Before
    public void setup() {
        parser = JSoupHtmlParser.createFor(HTML);
    }

    @Test
    public void testGetFirstDiv() {
        final String actual = parser.getHTMLContentOfFirst("div");
        final String expected = "<h2>hello world</h2><div><p>I'm Example<br>Batman</p></div>";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFirstH1Contents() {
        final String actual = parser.getHTMLContentOfFirst("h1");
        final String expected = "example";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFirstPContents() {
        final String actual = parser.getHTMLContentOfFirst("p");
        final String expected = "Welcome to example!";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFirstBodyContents() {
        final String actual = parser.getHTMLContentOfFirst("body");
        final String expected = "<h1>example</h1><p>Welcome to example!</p><div id=\"firstdiv\"><h2>hello world</h2><div><p>I'm Example<br>Batman</p></div></div>";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNonExistantTag() {
        final String actual = parser.getHTMLContentOfFirst("blah");
        final String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetSecondDivContents() {
        final String actual = parser.getHTMLContentOfNthOccurance("div", 2);
        final String expected = "<p>I'm Example<br>Batman</p>";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetSecondPContents() {
        final String actual = parser.getHTMLContentOfNthOccurance("p", 2);
        final String expected = "I'm Example<br>Batman";
        assertEquals(expected, actual);
    }
}
