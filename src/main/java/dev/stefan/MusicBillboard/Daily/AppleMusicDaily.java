package dev.stefan.MusicBillboard.Daily;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dev.stefan.MusicBillboard.Bean.MusicInfo;
import dev.stefan.MusicBillboard.Expection.MusicInfoException;

public class AppleMusicDaily implements DailyWork {

	private static final String Para_Message = "Apple Music日榜參數有誤";

	private static final String Execute_Message = "於Apple Music日榜網頁發生錯誤";

	private List<MusicInfo> musicInfoList = null;

	private MusicInfo musicInfo;

	private WebDriver webDriver;

	private String url;

	@Override
	public List<MusicInfo> getDailyMusicInfos(Object... object) throws MusicInfoException {

		if (!(object[0] instanceof WebDriver) || !(object[1] instanceof String))
			throw new MusicInfoException(Para_Message);

		webDriver = (WebDriver) object[0];
		url = (String) object[1];
		musicInfoList = new ArrayList<MusicInfo>();

		try {
			webDriver.navigate().to(url);
			Thread.sleep(5000);

			List<WebElement> elements = webDriver.findElement(By.cssSelector("div.product-hero__tracks"))
					.findElement(By.tagName("ol")).findElements(By.tagName("li"));

			for (int i = 0; i < elements.size(); i++) {
				musicInfo = new MusicInfo();
				WebElement song = elements.get(i);

				String songName = song.findElement(By.cssSelector("div.tracklist-item__first-line"))
						.findElement(By.tagName("a")).getText();
				String talentName = song.findElement(By.cssSelector(
						"div.we-truncate.tracklist-item__second-line--shifted.we-truncate--single-line.ember-view"))
						.findElement(By.tagName("a")).getText();

				musicInfo.setRank(String.valueOf(i + 1));
				musicInfo.setTrackName(songName);
				musicInfo.setTalentName(talentName);
				musicInfoList.add(musicInfo);
			}
		} catch (InterruptedException e) {
			throw new MusicInfoException(Execute_Message);
		}

		return musicInfoList;
	}

}
