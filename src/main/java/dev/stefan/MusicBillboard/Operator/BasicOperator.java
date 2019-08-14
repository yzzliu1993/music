package dev.stefan.MusicBillboard.Operator;

import org.openqa.selenium.WebDriver;

import dev.stefan.MusicBillboard.Enum.MusicStyleEnum;
import dev.stefan.MusicBillboard.Enum.MusicTypeEnum;

public abstract class BasicOperator {

	protected WebDriver webDriver;
	
	protected String url;

	protected MusicStyleEnum musicStyleEnum;
	
	protected MusicTypeEnum musicTypeEnum;
	
	protected Integer pageNum;
	
	public BasicOperator(WebDriver webDriver, String url) {
		this.webDriver =webDriver;
		this.url = url;
	}
	 
	public BasicOperator(WebDriver webDriver, String url, MusicStyleEnum musicStyleEnum, MusicTypeEnum musicTypeEnum) {
		this.webDriver =webDriver;
		this.url = url;
		this.musicStyleEnum = musicStyleEnum;
		this.musicTypeEnum = musicTypeEnum;
	}
	
	public BasicOperator(WebDriver webDriver, String url, Integer pageNum) {
		this.webDriver =webDriver;
		this.url = url;
		this.pageNum = pageNum;
	}
	
	public abstract Object[] getObjectArray();
	
}
