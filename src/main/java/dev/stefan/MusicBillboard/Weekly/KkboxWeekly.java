package dev.stefan.MusicBillboard.Weekly;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dev.stefan.MusicBillboard.Bean.MusicInfo;
import dev.stefan.MusicBillboard.Expection.MusicInfoException;
import dev.stefan.MusicBillboard.Operator.BasicOperator;

public class KkboxWeekly implements WeeklyWork {

	private static final String Para_Message = "KKbox週榜參數有誤";

	private static final String Execute_Message = "於KKbox週榜網頁發生錯誤";

	private List<MusicInfo> musicInfoList = null;

	private MusicInfo musicInfo;

	private WebDriver webDriver;

	private String url;
	
	@Override
	public List<MusicInfo> getWeeklyWorkInfo(BasicOperator basicBean) throws MusicInfoException {

		if (!(basicBean.getObjectArray()[0] instanceof WebDriver) || !(basicBean.getObjectArray()[1] instanceof String))
			throw new MusicInfoException(Para_Message);

		webDriver = (WebDriver) basicBean.getObjectArray()[0];
		url = (String) basicBean.getObjectArray()[1];
		musicInfoList = new ArrayList<MusicInfo>();
		
		try {
			webDriver.navigate().to(url);

			Thread.sleep(5000);
			List<WebElement> elements = webDriver.findElements(By.className("charts-list-row"));

			for (int i = 0; i < elements.size(); i++) {
				musicInfo = new MusicInfo();
				WebElement song = elements.get(i);
				String rank = song.findElement(By.cssSelector("span.charts-list-rank")).getText().trim();
				String songName = song.findElement(By.cssSelector("span.charts-list-song")).getText().trim();
				String talentName = song.findElement(By.cssSelector("span.charts-list-artist")).getText().trim();

				musicInfo.setRank(rank);
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
