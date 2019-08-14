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
import dev.stefan.MusicBillboard.Expection.MusicInfoException;
import dev.stefan.MusicBillboard.Operator.Friday;
import dev.stefan.MusicBillboard.Weekly.FridayWeekly;

public class FridayWeeklyCollection extends BasicCollection {

	@Autowired
	private FridayWeekly fridayWeekly;

	@Value("${friday.url}")
	private String url;

	@Value("${weekly.new.track}")
	private String newTrackSheet;

	@Value("${weekly.new.album}")
	private String newAlbumSheet;

	@Value("${weekly.mandarin.track}")
	private String mandarinTrackSheet;

	@Value("${weekly.mandarin.album}")
	private String mandarinAlbumSheet;

	@Value("${weekly.tv.track}")
	private String tvTrackSheet;

	@Value("${weekly.tv.album}")
	private String tvAlbumSheet;

	@Value("${weekly.movie.track}")
	private String movieTrackSheet;

	@Value("${weekly.movie.album}")
	private String movieAlbumSheet;

	public Map<String, List<MusicInfo>> getMusicInfo(WebDriver webDriver) throws MusicInfoException {
		musicInfoMap = new HashedMap<String, List<MusicInfo>>();
		System.out.println("開始取得Friday週榜資料");

		musicInfoMap.put(newTrackSheet,
				fridayWeekly.getWeeklyWorkInfo(new Friday(webDriver, url, MusicStyleEnum.新歌, MusicTypeEnum.單曲)));

		musicInfoMap.put(newAlbumSheet,
				fridayWeekly.getWeeklyWorkInfo(new Friday(webDriver, url, MusicStyleEnum.新歌, MusicTypeEnum.專輯)));

		musicInfoMap.put(mandarinTrackSheet,
				fridayWeekly.getWeeklyWorkInfo(new Friday(webDriver, url, MusicStyleEnum.國語, MusicTypeEnum.單曲)));

		musicInfoMap.put(mandarinAlbumSheet,
				fridayWeekly.getWeeklyWorkInfo(new Friday(webDriver, url, MusicStyleEnum.國語, MusicTypeEnum.專輯)));

		musicInfoMap.put(tvTrackSheet,
				fridayWeekly.getWeeklyWorkInfo(new Friday(webDriver, url, MusicStyleEnum.電視, MusicTypeEnum.單曲)));

		musicInfoMap.put(tvAlbumSheet,
				fridayWeekly.getWeeklyWorkInfo(new Friday(webDriver, url, MusicStyleEnum.電視, MusicTypeEnum.專輯)));

		musicInfoMap.put(movieTrackSheet,
				fridayWeekly.getWeeklyWorkInfo(new Friday(webDriver, url, MusicStyleEnum.電影, MusicTypeEnum.單曲)));

		musicInfoMap.put(movieAlbumSheet,
				fridayWeekly.getWeeklyWorkInfo(new Friday(webDriver, url, MusicStyleEnum.電影, MusicTypeEnum.專輯)));

		return musicInfoMap;
	}

}
