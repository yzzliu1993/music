package dev.stefan.MusicBillboard.Config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import dev.stefan.MusicBillboard.Collections.FridayDailyCollection;
import dev.stefan.MusicBillboard.Constant.ExcelConstrant;
import dev.stefan.MusicBillboard.Daily.FridayDaily;
import dev.stefan.MusicBillboard.Generate.GenerateExcel;
import dev.stefan.MusicBillboard.Service.DailyService;

@Configuration
@PropertySource({ "classpath:friday.properties", "classpath:selenium.properties", "classpath:excel.properties" })
public class SpringConfig {

	@Bean
	public SeleniumConfig SeleniumConfig() {
		return new SeleniumConfig();
	}

	@Bean
	public GenerateExcel GenerateExcel() {
		return new GenerateExcel();
	}

	@Bean
	public ExcelConstrant excelConstrant() {
		return new ExcelConstrant();
	}

	@Bean
	public FridayDaily fridayDaily() {
		return new FridayDaily();
	}

	@Bean
	public FridayDailyCollection fridayDailyCollection() {
		return new FridayDailyCollection();
	}

	@Bean
	public DailyService dailyService() {
		return new DailyService();
	}

}
