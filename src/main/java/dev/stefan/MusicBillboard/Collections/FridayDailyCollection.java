package dev.stefan.MusicBillboard.Collections;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import dev.stefan.MusicBillboard.Bean.MusicInfo;
import dev.stefan.MusicBillboard.Daily.FridayDaily;
import dev.stefan.MusicBillboard.Enum.MusicStyleEnum;
import dev.stefan.MusicBillboard.Enum.MusicTypeEnum;
import dev.stefan.MusicBillboard.Expection.MusicInfoException;
import dev.stefan.MusicBillboard.Operator.Friday;

public class FridayDailyCollection extends BasicCollection {

	@Autowired
	private FridayDaily fridayDaily;

	@Value("${friday.url}")
	private String url;

	@Value("${daily.new.track}")
	private String newTrackSheet;

	@Value("${daily.new.album}")
	private String newAlbumSheet;

	@Value("${daily.mandarin.track}")
	private String mandarinTrackSheet;

	@Value("${daily.mandarin.album}")
	private String mandarinAlbumSheet;

	@Value("${daily.tv.track}")
	private String tvTrackSheet;

	@Value("${daily.tv.album}")
	private String tvAlbumSheet;

	public Map<String, List<MusicInfo>> getMusicInfo(WebDriver webDriver) throws MusicInfoException {
		musicInfoMap = new HashedMap<String, List<MusicInfo>>();
		System.out.println("開始取得Friday日榜資料.......");
		musicInfoMap.put(newTrackSheet, 
				fridayDaily.getDailyMusicInfos(new Friday(webDriver, url, MusicStyleEnum.新歌, MusicTypeEnum.單曲)));
		
		musicInfoMap.put(newAlbumSheet, 
				fridayDaily.getDailyMusicInfos(new Friday(webDriver, url, MusicStyleEnum.新歌, MusicTypeEnum.專輯)));
		
		musicInfoMap.put(mandarinTrackSheet, 
				fridayDaily.getDailyMusicInfos(new Friday(webDriver, url, MusicStyleEnum.國語, MusicTypeEnum.單曲)));

		musicInfoMap.put(mandarinAlbumSheet, 
				fridayDaily.getDailyMusicInfos(	new Friday(webDriver, url, MusicStyleEnum.國語, MusicTypeEnum.專輯)));

		musicInfoMap.put(tvTrackSheet, 
				fridayDaily.getDailyMusicInfos(new Friday(webDriver, url, MusicStyleEnum.電視, MusicTypeEnum.單曲)));
		
		musicInfoMap.put(tvAlbumSheet, 
				fridayDaily.getDailyMusicInfos(new Friday(webDriver, url, MusicStyleEnum.電視, MusicTypeEnum.專輯)));
		
		return musicInfoMap;
	}

}
