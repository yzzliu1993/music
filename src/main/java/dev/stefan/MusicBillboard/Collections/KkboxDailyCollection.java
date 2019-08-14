package dev.stefan.MusicBillboard.Collections;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import dev.stefan.MusicBillboard.Bean.MusicInfo;
import dev.stefan.MusicBillboard.Daily.KkboxDaily;
import dev.stefan.MusicBillboard.Expection.MusicInfoException;
import dev.stefan.MusicBillboard.Operator.Kkbox;

public class KkboxDailyCollection extends BasicCollection {

	@Autowired
	private KkboxDaily kkboxDaily;
	
	@Value("${kkbox.daily.mandarin.new}")
	private String mandarinNewSheet;
	
	@Value("${kkbox.daily.mandarin.track}")
	private String mandarinTrackSheet;
	
	@Value("${kkbox.url.daily.mandarin.new}")
	private String mandarinNewUrl;
	
	@Value("${kkbox.url.daily.mandarin.track}")
	private String mandarinTrackUrl;
	
	public Map<String, List<MusicInfo>> getMusicInfo(WebDriver webDriver) throws MusicInfoException{
		System.out.println("開始取得KKBOX日榜資料");
		musicInfoMap = new HashedMap<String, List<MusicInfo>>();
		
		musicInfoMap.put(mandarinNewSheet, 
				kkboxDaily.getDailyMusicInfos(new Kkbox(webDriver, mandarinNewUrl)));
		
		musicInfoMap.put(mandarinTrackSheet, 
				kkboxDaily.getDailyMusicInfos(new Kkbox(webDriver, mandarinTrackUrl)));
		
		return musicInfoMap;
	}
	
	
	
}
