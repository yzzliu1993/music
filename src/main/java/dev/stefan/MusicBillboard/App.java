package dev.stefan.MusicBillboard;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.stefan.MusicBillboard.Config.SpringConfig;
import dev.stefan.MusicBillboard.Expection.MusicInfoException;
import dev.stefan.MusicBillboard.Service.DailyService;
import dev.stefan.MusicBillboard.Service.WeeklyService;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(SpringConfig.class);
		DailyService dailyService = cxt.getBean(DailyService.class);
		WeeklyService weeklyService = cxt.getBean(WeeklyService.class);

		try {

//			dailyService.executeDailyWork();
			weeklyService.executeWeeklyWork();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (MusicInfoException e) {
			e.printStackTrace();
		} 

	}
}
