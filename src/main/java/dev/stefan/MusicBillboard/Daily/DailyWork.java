package dev.stefan.MusicBillboard.Daily;

import java.util.List;

import dev.stefan.MusicBillboard.Bean.MusicInfo;
import dev.stefan.MusicBillboard.Expection.MusicInfoException;
import dev.stefan.MusicBillboard.Operator.BasicOperator;

public interface DailyWork {

	public List<MusicInfo> getDailyMusicInfos(BasicOperator basicBean)
			throws MusicInfoException;
	
}
