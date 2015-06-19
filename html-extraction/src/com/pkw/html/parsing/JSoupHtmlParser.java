package com.pkw.html.parsing;

public class JSoupHtmlParser extends AbstractJSoupHtmlParser {

	public static JSoupHtmlParser createFor(String html) {
		return new JSoupHtmlParser(html);
	}

	private JSoupHtmlParser(String html) {
		super(html);
	}

	public static class Builder implements HtmlParser.Builder {
		private String html;

		public static Builder startBuild() {
			return new Builder();
		}

		public Builder setHtml(String html) {
			this.html = html;
			return this;
		}

		@Override
		public JSoupHtmlParser build() {
			return JSoupHtmlParser.createFor(html);
		}

	}
}
