package dev.stefan.MusicBillboard.Operator;

import org.openqa.selenium.WebDriver;

import dev.stefan.MusicBillboard.Enum.MusicStyleEnum;
import dev.stefan.MusicBillboard.Enum.MusicTypeEnum;

public class Friday extends BasicOperator{

	public Friday(WebDriver webDriver, String url, MusicStyleEnum musicStyleEnum, MusicTypeEnum musicTypeEnum) {
		super(webDriver, url, musicStyleEnum, musicTypeEnum);
	}
	
	@Override
	public Object[] getObjectArray() {
		return new Object[] {webDriver, url, musicStyleEnum, musicTypeEnum};
	}
	
}
