package dev.stefan.MusicBillboard.Service;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import dev.stefan.MusicBillboard.Collections.FridayDailyCollection;
import dev.stefan.MusicBillboard.Collections.ItunesDailyCollection;
import dev.stefan.MusicBillboard.Collections.KkboxDailyCollection;
import dev.stefan.MusicBillboard.Collections.MyMusicDailyCollection;
import dev.stefan.MusicBillboard.Collections.SpotifyDailyCollection;
import dev.stefan.MusicBillboard.Config.SeleniumConfig;
import dev.stefan.MusicBillboard.Constant.ExcelConstrant;
import dev.stefan.MusicBillboard.Expection.MusicInfoException;
import dev.stefan.MusicBillboard.Expection.WebDriveException;
import dev.stefan.MusicBillboard.Generate.GenerateExcel;

public class DailyService {

	@Autowired
	private FridayDailyCollection fridayDailyCollection;
	
	@Autowired
	private ItunesDailyCollection itunesDailyCollection;
	
	@Autowired
	private KkboxDailyCollection kkboxDailyCollection;
	
	@Autowired
	private MyMusicDailyCollection myMusicDailyCollection;
	
	@Autowired
	private SpotifyDailyCollection spotifyDailyCollection;
	
	@Autowired
	private GenerateExcel generateExcel;
	
	@Autowired
	private SeleniumConfig seleniumConfig;
	
	@Autowired
	private ExcelConstrant excelConstrant;
	
	private WebDriver webDriver;
	
	public void executeDailyWork() throws IOException, MusicInfoException {
		System.out.println("開始取得平台日榜資料.......");
		try {
			webDriver = seleniumConfig.getWebDriver();
			
			generateExcel.generate(fridayDailyCollection.getMusicInfo(webDriver), excelConstrant.getFridayDaily());
			
			generateExcel.generate(itunesDailyCollection.getMusicInfo(webDriver), excelConstrant.getiTunesDaily());
			
			generateExcel.generate(kkboxDailyCollection.getMusicInfo(webDriver), excelConstrant.getKKboxDaily());
			
			generateExcel.generate(myMusicDailyCollection.getMusicInfo(webDriver), excelConstrant.getMyMusicDaily());
			
			generateExcel.generate(spotifyDailyCollection.getMusicInfo(webDriver), excelConstrant.getSpotifyDaily());
			
			webDriver.close();
		} catch (WebDriveException e) {
			e.printStackTrace();
			if(webDriver != null)
				webDriver.close();
		}
	}
	
}
