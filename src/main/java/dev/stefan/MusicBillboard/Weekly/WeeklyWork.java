package dev.stefan.MusicBillboard.Weekly;

import java.util.List;

import dev.stefan.MusicBillboard.Bean.MusicInfo;
import dev.stefan.MusicBillboard.Expection.WeeklyMusicInfoException;

public interface WeeklyWork {

	public List<MusicInfo> getWeeklyWorkInfo(Object... object)throws WeeklyMusicInfoException;
	
}
