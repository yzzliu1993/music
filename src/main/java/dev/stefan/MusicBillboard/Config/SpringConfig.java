package dev.stefan.MusicBillboard.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import dev.stefan.MusicBillboard.Collections.FridayDailyCollection;
import dev.stefan.MusicBillboard.Collections.FridayWeeklyCollection;
import dev.stefan.MusicBillboard.Collections.ItunesDailyCollection;
import dev.stefan.MusicBillboard.Collections.KkboxDailyCollection;
import dev.stefan.MusicBillboard.Collections.KkboxWeeklyCollection;
import dev.stefan.MusicBillboard.Collections.MyMusicDailyCollection;
import dev.stefan.MusicBillboard.Collections.MyMusicWeeklyCollection;
import dev.stefan.MusicBillboard.Collections.SpotifyDailyCollection;
import dev.stefan.MusicBillboard.Collections.SpotifyWeeklyCollection;
import dev.stefan.MusicBillboard.Constant.ExcelConstrant;
import dev.stefan.MusicBillboard.Daily.AppleMusicDaily;
import dev.stefan.MusicBillboard.Daily.FridayDaily;
import dev.stefan.MusicBillboard.Daily.ItunesDaily;
import dev.stefan.MusicBillboard.Daily.KkboxDaily;
import dev.stefan.MusicBillboard.Daily.MyMusicDaily;
import dev.stefan.MusicBillboard.Daily.SpotifyDaily;
import dev.stefan.MusicBillboard.Generate.GenerateExcel;
import dev.stefan.MusicBillboard.Service.DailyService;
import dev.stefan.MusicBillboard.Service.WeeklyService;
import dev.stefan.MusicBillboard.Weekly.FridayWeekly;
import dev.stefan.MusicBillboard.Weekly.KkboxWeekly;
import dev.stefan.MusicBillboard.Weekly.MyMusicWeekly;
import dev.stefan.MusicBillboard.Weekly.SpotifyWeekly;

@Configuration
@PropertySource(value = { "classpath:spotify.properties", "classpath:friday.properties", "classpath:mymusic.properties",
		"classpath:kkbox.properties", "classpath:itunes.properties", "classpath:selenium.properties",
		"classpath:excel.properties" }, encoding = "utf-8")
public class SpringConfig {

	@Bean
	public SeleniumConfig SeleniumConfig() {
		return new SeleniumConfig();
	}

	@Bean
	public GenerateExcel GenerateExcel() {
		return new GenerateExcel();
	}

	@Bean
	public ExcelConstrant excelConstrant() {
		return new ExcelConstrant();
	}

	@Bean
	public FridayDaily fridayDaily() {
		return new FridayDaily();
	}

	@Bean
	public FridayWeekly fridayWeekly() {
		return new FridayWeekly();
	}

	@Bean
	public ItunesDaily ItunesDaily() {
		return new ItunesDaily();
	}

	@Bean
	public AppleMusicDaily appleMusicDaily() {
		return new AppleMusicDaily();
	}

	@Bean
	public KkboxDaily KkboxDaily() {
		return new KkboxDaily();
	}

	@Bean
	public KkboxWeekly kkboxWeekly() {
		return new KkboxWeekly();
	}

	@Bean
	public MyMusicDaily myMusicDaily() {
		return new MyMusicDaily();
	}

	@Bean
	public MyMusicWeekly myMusicWeekly() {
		return new MyMusicWeekly();
	}

	@Bean
	public SpotifyDaily spotifyDaily() {
		return new SpotifyDaily();
	}

	@Bean
	public SpotifyWeekly spotifyWeekly() {
		return new SpotifyWeekly();
	}

	@Bean
	public FridayDailyCollection fridayDailyCollection() {
		return new FridayDailyCollection();
	}

	@Bean
	public FridayWeeklyCollection fridayWeeklyCollection() {
		return new FridayWeeklyCollection();
	}

	@Bean
	public ItunesDailyCollection itunesDailyCollection() {
		return new ItunesDailyCollection();
	}

	@Bean
	public KkboxDailyCollection kkboxDailyCollection() {
		return new KkboxDailyCollection();
	}

	@Bean
	public KkboxWeeklyCollection kkboxWeeklyCollection() {
		return new KkboxWeeklyCollection();
	}

	@Bean
	public MyMusicWeeklyCollection myMusicWeeklyCollection() {
		return new MyMusicWeeklyCollection();
	}

	@Bean
	public MyMusicDailyCollection myMusicDailyCollection() {
		return new MyMusicDailyCollection();
	}

	@Bean
	public SpotifyDailyCollection spotifyDailyCollection() {
		return new SpotifyDailyCollection();
	}

	@Bean
	public SpotifyWeeklyCollection spotifyWeeklyCollection() {
		return new SpotifyWeeklyCollection();
	}

	@Bean
	public DailyService dailyService() {
		return new DailyService();
	}

	@Bean
	public WeeklyService weeklyService() {
		return new WeeklyService();
	}

}
