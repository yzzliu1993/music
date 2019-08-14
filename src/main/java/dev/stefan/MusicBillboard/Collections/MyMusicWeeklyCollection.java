package dev.stefan.MusicBillboard.Collections;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import dev.stefan.MusicBillboard.Bean.MusicInfo;
import dev.stefan.MusicBillboard.Expection.MusicInfoException;
import dev.stefan.MusicBillboard.Operator.MyMusic;
import dev.stefan.MusicBillboard.Weekly.MyMusicWeekly;

public class MyMusicWeeklyCollection extends BasicCollection {

	@Autowired
	private MyMusicWeekly myMusicWeekly;

	@Value("${mymusic.weekly.mandarin.new.track}")
	private String mandarinNewTrackSheet;

	@Value("${mymusic.weekly.mandarin.track}")
	private String mandarinTrackSheet;

	@Value("${mymusic.weekly.mandarin.new.album}")
	private String mandarinNewAlbumSheet;

	@Value("${mymusic.weekly.mandarin.album}")
	private String mandarinAlbumSheet;

	@Value("${mymusic.weekly.movie.track}")
	private String movieTrackSheet;

	@Value("${mymusic.weekly.movie.album}")
	private String movieAlbumSheet;

	@Value("${mymusic.weekly.hiphop.track}")
	private String hiphopTrackSheet;

	@Value("${mymusic.weekly.hiphop.album}")
	private String hiphopAlbumSheet;

	@Value("${mymusic.weekly.url.mandarin.new.track}")
	private String mandarinNewTrackUrl;

	@Value("${mymusic.weekly.url.mandarin.track}")
	private String mandarinTrackUrl;

	@Value("${mymusic.weekly.url.mandarin.new.album}")
	private String mandarinNewAlbumUrl;

	@Value("${mymusic.weekly.url.mandarin.album}")
	private String mandarinAlbumUrl;

	@Value("${mymusic.weekly.url.movie.track}")
	private String movieTrackUrl;

	@Value("${mymusic.weekly.url.movie.album}")
	private String movieAlbumUrl;

	@Value("${mymusic.weekly.url.hiphop.track}")
	private String hiphopTrackUrl;

	@Value("${mymusic.weekly.url.hiphop.album}")
	private String hiphopAlbumUrl;

	@Value("${mymusic.weekly.page.mandarin.new.track}")
	private int mandarinNewTrackPageNum;

	@Value("${mymusic.weekly.page.mandarin.track}")
	private int mandarinTrackPageNum;

	@Value("${mymusic.weekly.page.mandarin.new.album}")
	private int mandarinNewAlbumPageNum;

	@Value("${mymusic.weekly.page.mandarin.album}")
	private int mandarinAlbumPageNum;

	@Value("${mymusic.weekly.page.movie.track}")
	private int movieTrackPageNum;

	@Value("${mymusic.weekly.page.movie.album}")
	private int movieAlbumPageNum;

	@Value("${mymusic.weekly.page.hiphop.track}")
	private int hiphopTrackPageNum;

	@Value("${mymusic.weekly.page.hiphop.album}")
	private int hiphopAlbumPageNum;

	@Override
	public Map<String, List<MusicInfo>> getMusicInfo(WebDriver webDriver) throws MusicInfoException {
		System.out.println("開始取得MyMusic週榜資料");
		musicInfoMap = new HashedMap<String, List<MusicInfo>>();
		
		musicInfoMap.put(mandarinNewTrackSheet, myMusicWeekly
				.getWeeklyWorkInfo(new MyMusic(webDriver, mandarinNewTrackUrl, mandarinNewTrackPageNum)));

		musicInfoMap.put(mandarinTrackSheet, myMusicWeekly
				.getWeeklyWorkInfo(new MyMusic(webDriver, mandarinTrackUrl, mandarinTrackPageNum)));

		musicInfoMap.put(mandarinNewAlbumSheet, myMusicWeekly
				.getWeeklyWorkInfo(new MyMusic(webDriver, mandarinNewAlbumUrl, mandarinNewAlbumPageNum)));

		musicInfoMap.put(mandarinAlbumSheet, myMusicWeekly
				.getWeeklyWorkInfo(new MyMusic(webDriver, mandarinAlbumUrl, mandarinAlbumPageNum)));

		musicInfoMap.put(movieTrackSheet, myMusicWeekly
				.getWeeklyWorkInfo(new MyMusic(webDriver, movieTrackUrl, movieTrackPageNum)));

		musicInfoMap.put(movieAlbumSheet, myMusicWeekly
				.getWeeklyWorkInfo(new MyMusic(webDriver, movieAlbumUrl, movieAlbumPageNum)));
		
		musicInfoMap.put(hiphopTrackSheet, myMusicWeekly
				.getWeeklyWorkInfo(	new MyMusic(webDriver, hiphopTrackUrl, hiphopTrackPageNum)));

		musicInfoMap.put(hiphopAlbumSheet, myMusicWeekly
				.getWeeklyWorkInfo(	new MyMusic(webDriver, hiphopAlbumUrl, hiphopAlbumPageNum)));

		return musicInfoMap;
	}

}
