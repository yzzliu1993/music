package dev.stefan.MusicBillboard.Daily;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dev.stefan.MusicBillboard.Bean.MusicInfo;
import dev.stefan.MusicBillboard.Enum.MusicStyleEnum;
import dev.stefan.MusicBillboard.Enum.MusicTypeEnum;
import dev.stefan.MusicBillboard.Expection.DailyMusicInfoException;

public class FridayDaily implements DailyWork {

	private static final String PARA_MESSAGE = "取得Friday Music日榜參數出現錯誤";

	private static final String CLICK_MESSAGE = "於Friday Music網頁取得資料時發生錯誤";
	
	private WebDriver webDriver = null;

	private MusicStyleEnum musicStyleEnum;

	private MusicTypeEnum musicTypeEnum;

	private List<MusicInfo> musicInfoList = null;

	private MusicInfo musicInfo;

	private String url;

	public List<MusicInfo> getDailyMusicInfos(Object... object) throws DailyMusicInfoException {

		if (!(object[0] instanceof WebDriver) || !(object[1] instanceof String)
				|| !(object[2] instanceof MusicStyleEnum) || !(object[3] instanceof MusicTypeEnum))
			throw new DailyMusicInfoException(PARA_MESSAGE);

		webDriver = (WebDriver) object[0];
		url = (String) object[1];
		musicStyleEnum = (MusicStyleEnum) object[2];
		musicTypeEnum = (MusicTypeEnum) object[3];

		musicInfoList = new ArrayList<MusicInfo>();

		
		try {
			webDriver.navigate().to(url);
			// 點選音樂類型 新歌、國語、西洋....
			webDriver
					.findElement(By.cssSelector(
							"ul.idTabs.ui-tabs-nav.ui-helper-reset.ui-helper-clearfix.ui-widget-header.ui-corner-all"))
					.findElements(By.tagName("li")).get(musicStyleEnum.ordinal()).findElement(By.tagName("a")).click();
			Thread.sleep(5000);

			// 點選單曲、專輯
			webDriver.findElement(By.id("ui-tabs-" + (musicStyleEnum.ordinal() + 1)))
					.findElement(By.className("topchart_left_box")).findElement(By.cssSelector("ul.idTabs.topchart_menu"))
					.findElements(By.tagName("li")).get(musicTypeEnum.ordinal()).findElement(By.tagName("a")).click();
			Thread.sleep(5000);

			// 點選顯示更多
			((JavascriptExecutor) webDriver).executeScript("arguments[0].click()",
					webDriver.findElement(By.id("ui-tabs-" + (musicStyleEnum.ordinal() + 1)))
							.findElement(By.className("topchart_left_box")).findElement(By.className("topchart_box"))
							.findElements(By.className("rankShow")).get(musicTypeEnum.ordinal())
							.findElement(By.cssSelector("a.topchart_more_box")));
			Thread.sleep(5000);

			// 取得歌曲List
			List<WebElement> elements = webDriver.findElement(By.id("ui-tabs-" + (musicStyleEnum.ordinal() + 1)))
					.findElement(By.className("topchart_left_box")).findElement(By.className("topchart_box"))
					.findElements(By.className("rankShow")).get(musicTypeEnum.ordinal())
					.findElements(By.className("topchart_songlist_right_box"));
			Thread.sleep(5000);

			for (int i = 0; i < elements.size(); i++) {
				musicInfo = new MusicInfo();
				WebElement track = elements.get(i);

				String songName = track.findElement(By.className("topchart_songlist_info_container"))
						.findElement(By.className("topchart_songlist_01_txt")).getText().trim();

				String talentName = musicTypeEnum.ordinal() == 0
						? track.findElement(By.className("topchart_songlist_info_container"))
								.findElement(By.className("topchart_songlist_03_txt")).getText().trim()
						: track.findElement(By.className("topchart_songlist_info_container"))
								.findElement(By.className("topchart_songlist_02_txt")).getText().trim();

				musicInfo.setRank(String.valueOf(i + 1));
				musicInfo.setTrackName(songName);
				musicInfo.setTalentName(talentName);
				musicInfoList.add(musicInfo);
			}
		} catch (InterruptedException e) {
			throw new DailyMusicInfoException(CLICK_MESSAGE);
		}

		return musicInfoList;
	}

}
