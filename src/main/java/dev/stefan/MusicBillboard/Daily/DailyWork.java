package dev.stefan.MusicBillboard.Daily;

import java.util.List;

import dev.stefan.MusicBillboard.Bean.MusicInfo;
import dev.stefan.MusicBillboard.Expection.MusicInfoException;

public interface DailyWork {

	public List<MusicInfo> getDailyMusicInfos(Object ...object )
			throws MusicInfoException;
	
}
