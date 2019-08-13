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
import dev.stefan.MusicBillboard.Expection.DailyMusicInfoException;

public class FridayDailyCollection {

	@Autowired
	private FridayDaily fridayDaily;
	
	private Map<String, List<MusicInfo>> fridayMusicInfoMap;
	
	@Value("${friday.url}")
	private String url;
	
	@Value("${daily.new.track}")
	private String newTrack;
	
	@Value("${daily.new.album}")
	private String newAlbum;
	
	@Value("${daily.mandarin.track}")
	private String mandarinTrack;
	
	@Value("${daily.mandarin.album}")
	private String mandarinAlbum;
	
	@Value("${daily.tv.track}")
	private String tvTrack;
	
	@Value("${daily.tv.album}")
	private String tvAlbum;
	
	public Map<String, List<MusicInfo>> getFridayAll(WebDriver webDriver) throws DailyMusicInfoException {
		fridayMusicInfoMap = new HashedMap<String, List<MusicInfo>>();
		System.out.println("開始取得Friday日榜資料.......");
		fridayMusicInfoMap.put(newTrack, 
				fridayDaily.getDailyMusicInfos(new Object[] 
						{webDriver, url, MusicStyleEnum.新歌, MusicTypeEnum.單曲}));
		
		fridayMusicInfoMap.put(newAlbum, 
				fridayDaily.getDailyMusicInfos(new Object[] 
						{webDriver, url, MusicStyleEnum.新歌, MusicTypeEnum.專輯}));
		
		fridayMusicInfoMap.put(mandarinTrack, 
				fridayDaily.getDailyMusicInfos(new Object[] 
						{webDriver, url, MusicStyleEnum.國語, MusicTypeEnum.單曲}));
		
		fridayMusicInfoMap.put(mandarinAlbum, 
				fridayDaily.getDailyMusicInfos(new Object[] 
						{webDriver, url, MusicStyleEnum.國語, MusicTypeEnum.專輯}));
		
		fridayMusicInfoMap.put(tvTrack, 
				fridayDaily.getDailyMusicInfos(new Object[] 
						{webDriver, url, MusicStyleEnum.電視, MusicTypeEnum.單曲}));
		
		fridayMusicInfoMap.put(tvAlbum, 
				fridayDaily.getDailyMusicInfos(new Object[] 
						{webDriver, url, MusicStyleEnum.電視, MusicTypeEnum.專輯}));
		
		return fridayMusicInfoMap;
	}
	
}
