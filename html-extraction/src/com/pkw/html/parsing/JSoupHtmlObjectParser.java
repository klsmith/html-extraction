package com.pkw.html.parsing;

import com.pkw.html.Html;

public class JSoupHtmlObjectParser extends AbstractJSoupHtmlParser {

	public static JSoupHtmlObjectParser createFor(Html html) {
		return new JSoupHtmlObjectParser(html);
	}

	private JSoupHtmlObjectParser(Html html) {
		super(html.html());
	}

	public static class Builder implements HtmlParser.Builder {
		private Html html;

		public static Builder startBuild() {
			return new Builder();
		}

		public Builder setHtml(Html html) {
			this.html = html;
			return this;
		}

		@Override
		public JSoupHtmlObjectParser build() {
			return JSoupHtmlObjectParser.createFor(html);
		}

	}
}
