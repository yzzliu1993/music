package dev.stefan.MusicBillboard.Service;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import dev.stefan.MusicBillboard.Collections.FridayWeeklyCollection;
import dev.stefan.MusicBillboard.Collections.KkboxWeeklyCollection;
import dev.stefan.MusicBillboard.Collections.MyMusicWeeklyCollection;
import dev.stefan.MusicBillboard.Collections.SpotifyWeeklyCollection;
import dev.stefan.MusicBillboard.Config.SeleniumConfig;
import dev.stefan.MusicBillboard.Constant.ExcelConstrant;
import dev.stefan.MusicBillboard.Expection.MusicInfoException;
import dev.stefan.MusicBillboard.Expection.WebDriveException;
import dev.stefan.MusicBillboard.Generate.GenerateExcel;

public class WeeklyService {
	
	@Autowired
	private FridayWeeklyCollection fridayWeeklyCollection;

	@Autowired
	private KkboxWeeklyCollection kkboxWeeklyCollection;
	
	@Autowired
	private MyMusicWeeklyCollection myMusicWeeklyCollection;

	@Autowired
	private SpotifyWeeklyCollection spotifyWeeklyCollection;
	
	@Autowired
	private GenerateExcel generateExcel;

	@Autowired
	private SeleniumConfig seleniumConfig;

	@Autowired
	private ExcelConstrant excelConstrant;

	private WebDriver webDriver;

	public void executeWeeklyWork() throws IOException, MusicInfoException {

		try {
			webDriver = seleniumConfig.getWebDriver();

			generateExcel.generate(fridayWeeklyCollection.getMusicInfo(webDriver), excelConstrant.getFridayWeeky());

			generateExcel.generate(kkboxWeeklyCollection.getMusicInfo(webDriver), excelConstrant.getKKboxWeekly());
			
			generateExcel.generate(myMusicWeeklyCollection.getMusicInfo(webDriver), excelConstrant.getMyMusicWeekly());

			generateExcel.generate(spotifyWeeklyCollection.getMusicInfo(webDriver), excelConstrant.getSpotifyWeeky());
			
			webDriver.close();
		} catch (WebDriveException e) {
			e.printStackTrace();
			if (webDriver != null)
				webDriver.close();
		}

	}

}
