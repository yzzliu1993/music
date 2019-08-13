package dev.stefan.MusicBillboard.Service;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import dev.stefan.MusicBillboard.Collections.FridayDailyCollection;
import dev.stefan.MusicBillboard.Config.SeleniumConfig;
import dev.stefan.MusicBillboard.Constant.ExcelConstrant;
import dev.stefan.MusicBillboard.Expection.DailyMusicInfoException;
import dev.stefan.MusicBillboard.Expection.WebDriveException;
import dev.stefan.MusicBillboard.Generate.GenerateExcel;

public class DailyService {

	@Autowired
	private FridayDailyCollection fridayDailyCollection;
	
	@Autowired
	private GenerateExcel generateExcel;
	
	@Autowired
	private SeleniumConfig seleniumConfig;
	
	@Autowired
	private ExcelConstrant excelConstrant;
	
	private WebDriver webDriver;
	
	public void executeDailyWork() throws IOException, DailyMusicInfoException {
		try {
			webDriver = seleniumConfig.getWebDriver();
			
			generateExcel.generate(fridayDailyCollection.getFridayAll(webDriver), excelConstrant.getFridayDaily());
			
			
			
			
			
			
			webDriver.close();
		} catch (WebDriveException e) {
			e.printStackTrace();
			if(webDriver != null)
				webDriver.close();
		}
	}
	
}
