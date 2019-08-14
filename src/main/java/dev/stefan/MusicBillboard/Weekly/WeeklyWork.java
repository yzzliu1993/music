package dev.stefan.MusicBillboard.Weekly;

import java.util.List;

import dev.stefan.MusicBillboard.Bean.MusicInfo;
import dev.stefan.MusicBillboard.Expection.MusicInfoException;
import dev.stefan.MusicBillboard.Operator.BasicOperator;

public interface WeeklyWork {

	public List<MusicInfo> getWeeklyWorkInfo(BasicOperator basicBean)throws MusicInfoException;
	
}
