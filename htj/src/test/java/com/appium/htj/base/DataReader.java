package com.appium.htj.base;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataReader {
private InputStream fs = null;
private Workbook workbook = null;
private Sheet sheet = null;
private String path;
private HashMap<String, HashMap<String, String>> map= new HashMap<String, HashMap<String, String>>();
private HashMap<String, String> titleMap = new HashMap< String , String>();
public DataReader() {
	super();
}

public DataReader(String path,String sheetName,int TitleRows,int ValueCol) {
	this();
	readCase(path,sheetName, TitleRows, ValueCol);
	readTitle(TitleRows);
}

public void readCase(String dataPath,String sheetName,int titleRows,int ValueCol){

	path = dataPath;
	File sdCardDir=new File("/sdcard");
	String filepath = sdCardDir+path;
	
	try {
		fs = new FileInputStream(filepath);
		workbook = Workbook.getWorkbook(fs);
	} catch (BiffException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	sheet = workbook.getSheet(sheetName);
	
	for (int row = titleRows; row < sheet.getRows(); row++) {
		
		HashMap<String, String> mylist = new HashMap<String,String>();
		
		for (int col = ValueCol; col < sheet.getColumns(); col++) {	
			mylist.put(sheet.getCell(col,0).getContents(),sheet.getCell(col,row).getContents());
		}
		
		map.put(sheet.getCell(0,row).getContents(), mylist);
		
	}
}

public void readTitle(int titileRows) {
	if (titileRows == 2) {
		Cell[] cell = sheet.getRow(0);
		for (int i = 0; i < cell.length; i++) {
			titleMap.put(sheet.getCell(i,0).getContents(), sheet.getCell(i,1).getContents());
		}
	}else{
		Cell[] cell = sheet.getRow(0);
		for (int i = 0; i < cell.length; i++) {
			titleMap.put(sheet.getCell(i,0).getContents(), sheet.getCell(i,0).getContents());
		}
	}
}

public HashMap<String, String> getTitle(){
	return titleMap;
}

public HashMap<String, HashMap<String, String>> getMap(){
	return map;
}


}
