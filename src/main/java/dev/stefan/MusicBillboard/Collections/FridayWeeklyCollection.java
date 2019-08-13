package dev.stefan.MusicBillboard.Collections;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import dev.stefan.MusicBillboard.Bean.MusicInfo;
import dev.stefan.MusicBillboard.Enum.MusicStyleEnum;
import dev.stefan.MusicBillboard.Enum.MusicTypeEnum;
import dev.stefan.MusicBillboard.Expection.WeeklyMusicInfoException;
import dev.stefan.MusicBillboard.Weekly.FridayWeekly;

public class FridayWeeklyCollection {
	
	@Autowired
	private FridayWeekly fridayWeekly;
	
	private Map<String, List<MusicInfo>> fridayMusicInfoMap;
	
	@Value("${friday.url}")
	private String url;

	@Value("${weekly.new.track}")
	private String newTrack;

	@Value("${weekly.new.album}")
	private String newAlbum;

	@Value("${weekly.mandarin.track}")
	private String mandarinTrack;

	@Value("${weekly.mandarin.album}")
	private String mandarinAlbum;

	@Value("${weekly.tv.track}")
	private String tvTrack;

	@Value("${weekly.tv.album}")
	private String tvAlbum;
	
	@Value("${weekly.movie.track}")
	private String movieTrack;
	
	@Value("${weekly.movie.album}")
	private String movieAlbum;
	
	public Map<String, List<MusicInfo>> getFridayAll(WebDriver webDriver) throws WeeklyMusicInfoException{
		fridayMusicInfoMap = new HashedMap<String, List<MusicInfo>>();
		
		fridayMusicInfoMap.put(newTrack,
				fridayWeekly.getWeeklyWorkInfo(new Object[] 
						{webDriver, url, MusicStyleEnum.新歌, MusicTypeEnum.單曲}));
		
		fridayMusicInfoMap.put(newAlbum,
				fridayWeekly.getWeeklyWorkInfo(new Object[] 
						{webDriver, url, MusicStyleEnum.新歌, MusicTypeEnum.專輯}));
		
		fridayMusicInfoMap.put(mandarinTrack, 
				fridayWeekly.getWeeklyWorkInfo(new Object[] 
						{webDriver, url, MusicStyleEnum.國語, MusicTypeEnum.單曲}));
		
		fridayMusicInfoMap.put(mandarinAlbum, 
				fridayWeekly.getWeeklyWorkInfo(new Object[] 
						{webDriver, url, MusicStyleEnum.國語, MusicTypeEnum.專輯}));
		
		fridayMusicInfoMap.put(tvTrack, 
				fridayWeekly.getWeeklyWorkInfo(new Object[] 
						{webDriver, url, MusicStyleEnum.電視, MusicTypeEnum.單曲}));
		
		fridayMusicInfoMap.put(tvAlbum, 
				fridayWeekly.getWeeklyWorkInfo(new Object[] 
						{webDriver, url, MusicStyleEnum.電視, MusicTypeEnum.專輯}));
		
		fridayMusicInfoMap.put(movieTrack, 
				fridayWeekly.getWeeklyWorkInfo(new Object[] 
						{webDriver, url, MusicStyleEnum.電影, MusicTypeEnum.單曲}));
		
		fridayMusicInfoMap.put(movieAlbum, 
				fridayWeekly.getWeeklyWorkInfo(new Object[] 
						{webDriver, url, MusicStyleEnum.電影, MusicTypeEnum.專輯}));
		
		return fridayMusicInfoMap;
	}
	
}
