package dev.stefan.MusicBillboard.Collections;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import dev.stefan.MusicBillboard.Bean.MusicInfo;
import dev.stefan.MusicBillboard.Daily.SpotifyDaily;
import dev.stefan.MusicBillboard.Expection.MusicInfoException;
import dev.stefan.MusicBillboard.Operator.Spotify;

public class SpotifyDailyCollection extends BasicCollection {

	@Autowired
	private SpotifyDaily spotifyDaily;

	@Value("${spotify.daily.hongkong}")
	private String hongkongSheet;

	@Value("${spotify.daily.taiwan}")
	private String taiwanSheet;

	@Value("${spotify.daily.url.hongkong}")
	private String hongkongUrl;

	@Value("${spotify.daily.url.taiwan}")
	private String taiwanUrl;

	@Override
	public Map<String, List<MusicInfo>> getMusicInfo(WebDriver webDriver) throws MusicInfoException {
		System.out.println("開始取得Spotify日榜資料");

		musicInfoMap = new HashedMap<String, List<MusicInfo>>();

		musicInfoMap.put(hongkongSheet, spotifyDaily.getDailyMusicInfos(new Spotify(webDriver, hongkongUrl)));

		musicInfoMap.put(taiwanSheet, spotifyDaily.getDailyMusicInfos(new Spotify(webDriver, taiwanUrl)));

		return musicInfoMap;
	}

}
