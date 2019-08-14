package dev.stefan.MusicBillboard.Collections;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import dev.stefan.MusicBillboard.Bean.MusicInfo;
import dev.stefan.MusicBillboard.Expection.MusicInfoException;

public abstract class BasicCollection {
	protected Map<String, List<MusicInfo>> musicInfoMap;
	
	public abstract Map<String, List<MusicInfo>> getMusicInfo(WebDriver webDriver) throws MusicInfoException;
}
