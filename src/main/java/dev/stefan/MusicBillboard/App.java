package dev.stefan.MusicBillboard;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.stefan.MusicBillboard.Config.SpringConfig;
import dev.stefan.MusicBillboard.Expection.DailyMusicInfoException;
import dev.stefan.MusicBillboard.Service.DailyService;


public class App 
{
    public static void main( String[] args ){
     AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(SpringConfig.class);
     DailyService dailyService = cxt.getBean(DailyService.class);
    	
     
     try {
    	 
		dailyService.executeDailyWork();
		
		
	} catch (IOException e) {
		e.printStackTrace();
	} catch (DailyMusicInfoException e) {
		e.printStackTrace();
	}
    	
    	
    }
}
