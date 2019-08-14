package dev.stefan.MusicBillboard.Operator;

import org.openqa.selenium.WebDriver;

public class MyMusic extends BasicOperator {

	public MyMusic(WebDriver webDriver, String url, Integer pageNum) {
		super(webDriver, url, pageNum);
	}

	@Override
	public Object[] getObjectArray() {
		return new Object[] {webDriver, url, pageNum};
	}

}
