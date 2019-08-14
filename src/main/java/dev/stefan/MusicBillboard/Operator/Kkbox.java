package dev.stefan.MusicBillboard.Operator;

import org.openqa.selenium.WebDriver;

public class Kkbox extends BasicOperator {

	public Kkbox(WebDriver webDriver, String url) {
		super(webDriver, url);
	}

	@Override
	public Object[] getObjectArray() {
		return new Object[] {webDriver, url};
	}

}
