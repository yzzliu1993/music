package dev.stefan.MusicBillboard.Constant;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

public class ExcelConstrant {

	@Value("${daily.path}")
	private String dailyPath;
	
	@Value("${daily.firday}")
	private String fridayDailyExcel;
	
	@Value("${daily.kkbox}")
	private String kkboxDailyExcel;
	
	@Value("${daily.spotify}")
	private String spotifyDailyExcel;
	
	@Value("${daily.mymusic}")
	private String mymusicDailyExcel;
	
	@Value("${daily.iTunes}")
	private String itunesDailyExcel;
	
	@Value("${weekly.path}")
	private String weeklyPath;
	
	@Value("${weekly.spotify}")
	private String spotifyWeeklyExcel;
	
	@Value("${weekly.firday}")
	private String fridayWeeklyExcel;
	
	@Value("${weekly.kkbox}")
	private String kkboxWeeklyExcel;
	
	@Value("${weekly.mymusic}")
	private String mymusicWeeklyExcel;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	private String getDate() {
		return sdf.format(new Date());
	}
	
	public String getFridayDaily() {
		return dailyPath+getDate()+fridayDailyExcel;
	}
	
	public String getFridayWeeky() {
		return dailyPath+getDate()+fridayWeeklyExcel;
	}
	
	public String getSpotifyDaily() {
		return dailyPath+getDate()+spotifyDailyExcel;
	}
	
	public String getSpotifyWeeky() {
		return dailyPath+getDate()+spotifyWeeklyExcel;
	}
	
	public String getKKboxDaily() {
		return dailyPath+getDate()+kkboxDailyExcel;
	}
	
	public String getKKboxWeekly() {
		return dailyPath+getDate()+kkboxWeeklyExcel;
	}
	
	public String getMyMusicDaily() {
		return dailyPath+getDate()+mymusicDailyExcel;
	}
	
	public String getMyMusicWeekly() {
		return dailyPath+getDate()+mymusicWeeklyExcel;
	}
	
	public String getiTunesDaily() {
		return dailyPath+getDate()+itunesDailyExcel;
	}
	
	
	
}
