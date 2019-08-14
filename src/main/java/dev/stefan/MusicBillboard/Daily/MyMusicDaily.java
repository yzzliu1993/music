package dev.stefan.MusicBillboard.Daily;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dev.stefan.MusicBillboard.Bean.MusicInfo;
import dev.stefan.MusicBillboard.Expection.MusicInfoException;
import dev.stefan.MusicBillboard.Operator.BasicOperator;

public class MyMusicDaily implements DailyWork {

	private static final String Para_Message = "MyMusic日榜參數有誤";

	private static final String Execute_Message = "於MyMusic日榜網頁發生錯誤";

	private List<MusicInfo> musicInfoList = null;

	private MusicInfo musicInfo;

	private WebDriver webDriver;

	private String url;

	private int pageNum;

	@Override
	public List<MusicInfo> getDailyMusicInfos(BasicOperator basicBean) throws MusicInfoException {
		if (!(basicBean.getObjectArray()[0] instanceof WebDriver)
				|| !(basicBean.getObjectArray()[1] instanceof String) 
				|| !(basicBean.getObjectArray()[2] instanceof Integer))
			throw new MusicInfoException(Para_Message);

		webDriver = (WebDriver) basicBean.getObjectArray()[0];
		url = (String) basicBean.getObjectArray()[1];
		pageNum = (Integer) basicBean.getObjectArray()[2];
		musicInfoList = new ArrayList<MusicInfo>();

		try {

			webDriver.navigate().to(url);
			Thread.sleep(5000);
			for (int i = 0; i < pageNum; i++) {
				List<WebElement> elements = webDriver.findElement(By.cssSelector("ul.pagination.pagination-sm"))
						.findElements(By.tagName("li"));

				elements.get(i + 2).findElement(By.tagName("a")).click();
				Thread.sleep(5000);

				List<WebElement> songlist = webDriver.findElement(By.className("charts-list-complete"))
						.findElements(By.tagName("li"));

				for (int j = 0; j < songlist.size(); j++) {
					musicInfo = new MusicInfo();
					WebElement song = songlist.get(j);
					String rank = song.findElement(By.tagName("span")).getText().trim();
					String songName = song.findElement(By.cssSelector("div.charts-song.charts-song-long")).getText()
							.trim();
					String talentName = song.findElement(By.cssSelector("div.charts-artist.charts-artist-long"))
							.getText().trim();
					musicInfo.setRank(rank);
					musicInfo.setTalentName(talentName);
					musicInfo.setTrackName(songName);
					musicInfoList.add(musicInfo);
				}
			}
		} catch (InterruptedException e) {
			throw new MusicInfoException(Execute_Message);
		}
		return musicInfoList;
	}

}
