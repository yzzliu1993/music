package dev.stefan.MusicBillboard.Collections;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import dev.stefan.MusicBillboard.Bean.MusicInfo;
import dev.stefan.MusicBillboard.Daily.MyMusicDaily;
import dev.stefan.MusicBillboard.Expection.MusicInfoException;
import dev.stefan.MusicBillboard.Operator.MyMusic;

public class MyMusicDailyCollection extends BasicCollection {

	@Autowired
	private MyMusicDaily myMusicDaily;
	
	@Value("${mymusic.daily.all.new.track}")
	private String allNewTrackSheet;
	
	@Value("${mymusic.daily.all.track}")
	private String allTrackSheet;
	
	@Value("${mymusic.daily.mandarin.track}")
	private String mandarinTrackSheet;
	
	@Value("${mymusic.daily.movie.track}")
	private String movieTrackSheet;
	
	@Value("${mymusic.daily.hiphop.track}")
	private String hiphopTrackSheet;
	
	@Value("${mymusic.daily.url.all.new.track}")
	private String allNewTrackUrl;
	
	@Value("${mymusic.daily.url.all.track}")
	private String allTrackUrl;
	
	@Value("${mymusic.daily.url.mandarin.track}")
	private String mandarinTrackUrl;
	
	@Value("${mymusic.daily.url.movie.track}")
	private String movieTrackUrl;
	
	@Value("${mymusic.daily.url.hiphop.track}")
	private String hiphopTrackUrl;
	
	@Value("${mymusic.daily.page.all.new.track}")
	private int allNewTrackPagNum;
	
	@Value("${mymusic.daily.page.all.track}")
	private int allTrackPagNum;
	
	@Value("${mymusic.daily.page.mandarin.track}")
	private int mandarinTrackPagNum;
	
	@Value("${mymusic.daily.page.movie.track}")
	private int movieTrackPagNum;
	
	@Value("${mymusic.daily.page.hiphop.track}")
	private int hiphopTrackPagNum;
	
	@Override
	public Map<String, List<MusicInfo>> getMusicInfo(WebDriver webDriver) throws MusicInfoException {
		System.out.println("開始取得MyMusic日榜資料");
		
		musicInfoMap = new HashedMap<String, List<MusicInfo>>();
		
		musicInfoMap.put(allNewTrackSheet, 
				myMusicDaily.getDailyMusicInfos(new MyMusic(webDriver, allNewTrackUrl, allNewTrackPagNum)));
		
		musicInfoMap.put(allTrackSheet, 
				myMusicDaily.getDailyMusicInfos(new MyMusic(webDriver, allTrackUrl, allTrackPagNum)));
		
		musicInfoMap.put(mandarinTrackSheet, 
				myMusicDaily.getDailyMusicInfos(new MyMusic(webDriver, mandarinTrackUrl, mandarinTrackPagNum)));
		
		musicInfoMap.put(movieTrackSheet, 
				myMusicDaily.getDailyMusicInfos(new MyMusic(webDriver, movieTrackUrl, movieTrackPagNum)));
		
		musicInfoMap.put(hiphopTrackSheet, 
				myMusicDaily.getDailyMusicInfos(new MyMusic(webDriver, hiphopTrackUrl, hiphopTrackPagNum)));
		
		return musicInfoMap;
	}

}
