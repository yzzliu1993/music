package dev.stefan.MusicBillboard.Generate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dev.stefan.MusicBillboard.Bean.MusicInfo;

public class GenerateExcel {

	public void generate(Map<String, List<MusicInfo>> musicMap, String filePath)throws IOException {
		System.out.println("匯出Excel");
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		XSSFSheet xssfSheet = null;
		XSSFRow xssfRow = null;
		MusicInfo musicInfo = null;
		try (FileOutputStream outputStream = new FileOutputStream(new File(filePath))) {
			for (String sheetName : musicMap.keySet()) {
				xssfSheet = xssfWorkbook.createSheet(sheetName);
				List<MusicInfo> musicInfoList = musicMap.get(sheetName);

				for (int i = 0; i < musicInfoList.size(); i++) {
					musicInfo = musicInfoList.get(i);
					if (i == 0) {
						xssfRow = xssfSheet.createRow(0);
						xssfRow.createCell(0).setCellValue("名次");
						xssfRow.createCell(1).setCellValue("歌曲名稱");
						xssfRow.createCell(2).setCellValue("歌手名稱");
					}

					xssfRow = xssfSheet.createRow(i + 1);
					xssfRow.createCell(0).setCellValue(musicInfo.getRank());
					xssfRow.createCell(1).setCellValue(musicInfo.getTrackName());
					xssfRow.createCell(2).setCellValue(musicInfo.getTalentName());
				}
			}
			xssfWorkbook.write(outputStream);
		} catch (IOException e) {
			throw new IOException("路徑"+filePath+"的資料匯出錯誤");
		}
	}

}
