package com.pkw.html.parsing;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.pkw.html.parsing.JSoupHtmlParser;

public class JSoupHtmlParserTester {

    public static final String HTML = "<html><body><h1>example</h1><p>Welcome to example!</p><div id=\"firstdiv\"><h2>hello world</h2><div><p>I'm Example<br/>Batman</p></div></div></body></html>";

    private JSoupHtmlParser parser;

    @Before
    public void setup() throws ParserConfigurationException, SAXException, IOException {
        parser = JSoupHtmlParser.createFor(HTML);
    }

    @Test
    public void testGetFirstDiv() {
        String actual = parser.getHTMLContentOfFirst("div");
        String expected = "<h2>hello world</h2><div><p>I'm Example<br>Batman</p></div>";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFirstH1Contents() {
        String actual = parser.getHTMLContentOfFirst("h1");
        String expected = "example";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFirstPContents() {
        String actual = parser.getHTMLContentOfFirst("p");
        String expected = "Welcome to example!";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFirstBodyContents() {
        String actual = parser.getHTMLContentOfFirst("body");
        String expected = "<h1>example</h1><p>Welcome to example!</p><div id=\"firstdiv\"><h2>hello world</h2><div><p>I'm Example<br>Batman</p></div></div>";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNonExistantTag() {
        String actual = parser.getHTMLContentOfFirst("blah");
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetSecondDivContents() {
        String actual = parser.getHTMLContentOfNthOccurance("div", 2);
        String expected = "<p>I'm Example<br>Batman</p>";
        assertEquals(expected, actual);
    }
}
