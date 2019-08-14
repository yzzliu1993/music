package dev.stefan.MusicBillboard.Collections;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import dev.stefan.MusicBillboard.Bean.MusicInfo;
import dev.stefan.MusicBillboard.Expection.MusicInfoException;
import dev.stefan.MusicBillboard.Operator.Spotify;
import dev.stefan.MusicBillboard.Weekly.SpotifyWeekly;

public class SpotifyWeeklyCollection extends BasicCollection {

	@Autowired
	private SpotifyWeekly spotifyWeekly;
	
	@Value("${spotify.weekly.hongkong}")
	private String hongkongSheet;
	
	@Value("${spotify.weekly.taiwan}")
	private String taiwanSheet;
	
	@Value("${spotify.weekly.url.hongkong}")
	private String hongknogUrl;
	
	@Value("${spotify.weekly.url.taiwan}")
	private String taiwanUrl;
	
	@Override
	public Map<String, List<MusicInfo>> getMusicInfo(WebDriver webDriver) throws MusicInfoException {
		System.out.println("開始取得Spotify週榜資料");

		musicInfoMap = new HashedMap<String, List<MusicInfo>>();

		musicInfoMap.put(hongkongSheet, spotifyWeekly.getWeeklyWorkInfo(new Spotify(webDriver, hongknogUrl)));

		musicInfoMap.put(taiwanSheet, spotifyWeekly.getWeeklyWorkInfo(new Spotify(webDriver, taiwanUrl)));

		return musicInfoMap;
	}

}
