package dev.stefan.MusicBillboard.Operator;

import org.openqa.selenium.WebDriver;

public class Itunes extends BasicOperator {

	public Itunes(WebDriver webDriver, String url) {
		super(webDriver, url);
	}

	@Override
	public Object[] getObjectArray() {
		return new Object[] {webDriver, url};
	}

}
