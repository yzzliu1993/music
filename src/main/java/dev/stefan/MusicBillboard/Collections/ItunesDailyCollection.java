package dev.stefan.MusicBillboard.Collections;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import dev.stefan.MusicBillboard.Bean.MusicInfo;
import dev.stefan.MusicBillboard.Daily.AppleMusicDaily;
import dev.stefan.MusicBillboard.Daily.ItunesDaily;
import dev.stefan.MusicBillboard.Expection.MusicInfoException;
import dev.stefan.MusicBillboard.Operator.Itunes;

public class ItunesDailyCollection extends BasicCollection {

	@Autowired
	private ItunesDaily itunesDaily;
	
	@Autowired
	private AppleMusicDaily appleMusicDaily;
	
	@Value("${itunes.url.track}")
	private String trackUrl;
	
	@Value("${itunes.url.album}")
	private String albumUrl;
	
	@Value("${itunes.url.apple.track}")
	private String appleTrackUrl;
	
	@Value("${itunes.daily.track}")
	private String itunesTrackSheet;
	
	@Value("${itunes.daily.album}")
	private String itunesAlbumSheet;
	
	@Value("${itunes.daily.apple.track}")
	private String appleTrackSheet;
	
	public Map<String, List<MusicInfo>> getMusicInfo(WebDriver webDriver) throws MusicInfoException {
		System.out.println("開始取得iTunes日榜資料.......");
		
		musicInfoMap = new HashedMap<String, List<MusicInfo>>();
		
		musicInfoMap.put(itunesTrackSheet, 
				itunesDaily.getDailyMusicInfos(new Itunes(webDriver, trackUrl)));
		
		musicInfoMap.put(itunesAlbumSheet, 
				itunesDaily.getDailyMusicInfos(new Itunes(webDriver, albumUrl)));
		
		musicInfoMap.put(appleTrackSheet, 
				appleMusicDaily.getDailyMusicInfos(new Itunes(webDriver, appleTrackUrl)));
		
		return musicInfoMap;
	}
	
}
