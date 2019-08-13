package dev.stefan.MusicBillboard.Service;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import dev.stefan.MusicBillboard.Collections.FridayWeeklyCollection;
import dev.stefan.MusicBillboard.Config.SeleniumConfig;
import dev.stefan.MusicBillboard.Constant.ExcelConstrant;
import dev.stefan.MusicBillboard.Expection.WebDriveException;
import dev.stefan.MusicBillboard.Expection.WeeklyMusicInfoException;
import dev.stefan.MusicBillboard.Generate.GenerateExcel;

public class WeeklyService {
	@Autowired
	private FridayWeeklyCollection fridayWeeklyCollection;

	@Autowired
	private GenerateExcel generateExcel;

	@Autowired
	private SeleniumConfig seleniumConfig;

	@Autowired
	private ExcelConstrant excelConstrant;

	private WebDriver webDriver;

	public void weeklyWorks() throws IOException, WeeklyMusicInfoException {

		try {
			webDriver = seleniumConfig.getWebDriver();
			
			generateExcel.generate(fridayWeeklyCollection.getFridayAll(webDriver), excelConstrant.getFridayWeeky());
			
			
			
			
			
			
			webDriver.close();
		} catch (WebDriveException e) {
			e.printStackTrace();
			if(webDriver != null)
				webDriver.close();
		}



	}

}
