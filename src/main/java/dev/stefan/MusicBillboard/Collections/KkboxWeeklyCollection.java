package dev.stefan.MusicBillboard.Collections;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import dev.stefan.MusicBillboard.Bean.MusicInfo;
import dev.stefan.MusicBillboard.Expection.MusicInfoException;
import dev.stefan.MusicBillboard.Operator.Kkbox;
import dev.stefan.MusicBillboard.Weekly.KkboxWeekly;

public class KkboxWeeklyCollection extends BasicCollection {

	@Autowired
	private KkboxWeekly kkboxWeekly;

	@Value("${kkbox.weekly.mandarin.new}")
	private String mandarinNewSheet;

	@Value("${kkbox.weekly.mandarin.track}")
	private String mandarinTrackSheet;

	@Value("${kkbox.weekly.soundtrack.track}")
	private String soundtrackTrackSheet;

	@Value("${kkbox.weekly.soundtrack.album}")
	private String soundtrackAlbumSheet;

	@Value("${kkbox.weekly.hiphop.track}")
	private String hiphopTrackSheet;

	@Value("${kkbox.weekly.hiphop.album}")
	private String hiphopAlbumSheet;

	@Value("${kkbox.url.weekly.mandarin.new}")
	private String mandarinNewUrl;

	@Value("${kkbox.url.weekly.mandarin.track}")
	private String mandarinTrackUrl;

	@Value("${kkbox.url.weekly.soundtrack.track}")
	private String soundtrackTrackUrl;

	@Value("${kkbox.url.weekly.soundtrack.album}")
	private String soundtrackAlbumUrl;

	@Value("${kkbox.url.weekly.hiphop.track}")
	private String hiphopTrackUrl;

	@Value("${kkbox.url.weekly.hiphop.album}")
	private String hiphopAlbumUrl;

	@Override
	public Map<String, List<MusicInfo>> getMusicInfo(WebDriver webDriver) throws MusicInfoException {
		System.out.println("開始取得KKBOX週榜資料");
		musicInfoMap = new HashedMap<String, List<MusicInfo>>();

		musicInfoMap.put(mandarinNewSheet, kkboxWeekly.getWeeklyWorkInfo(new Kkbox(webDriver, mandarinNewUrl)));

		musicInfoMap.put(mandarinTrackSheet, kkboxWeekly.getWeeklyWorkInfo(new Kkbox(webDriver, mandarinTrackUrl)));

		musicInfoMap.put(soundtrackTrackSheet,
				kkboxWeekly.getWeeklyWorkInfo(new Kkbox(webDriver, soundtrackTrackUrl)));

		musicInfoMap.put(soundtrackAlbumSheet,
				kkboxWeekly.getWeeklyWorkInfo(new Kkbox(webDriver, soundtrackAlbumUrl)));

		musicInfoMap.put(hiphopTrackSheet, kkboxWeekly.getWeeklyWorkInfo(new Kkbox(webDriver, hiphopTrackUrl)));

		musicInfoMap.put(hiphopAlbumSheet, kkboxWeekly.getWeeklyWorkInfo(new Kkbox(webDriver, hiphopAlbumUrl)));

		return musicInfoMap;
	}

}
