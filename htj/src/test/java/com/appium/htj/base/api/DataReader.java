package com.appium.htj.base.api;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.appium.htj.utils.ExcelDataProvider;

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
public static Logger logger = Logger.getLogger(ExcelDataProvider.class.getName());

/**
 * @author sam
 * @description 读取excel数据
 * */
public DataReader() {
	super();
}

/**
 * @author sam
 * @description 读取excel数据
 * */
public DataReader(String path,String sheetName,int TitleRows,int ValueCol) {
	this();
	readCase(path,sheetName, TitleRows, ValueCol);
	readTitle(TitleRows);
}

/**
 * @author sam
 * @description 读取case数据
 * @param dataPath excel存放路径
 * @param sheetName excel sheet名称
 * @param titleRows excel title所占的行数
 * @param ValueCol excel 中case开始的行数
 * */
public void readCase(String dataPath,String sheetName,int titleRows,int ValueCol){
	
	try {
		fs = new FileInputStream(dataPath);
		workbook = Workbook.getWorkbook(fs);
	} catch (BiffException | IOException e) {
		// TODO Auto-generated catch block
		logger.info("没有找到"+dataPath+"文件");
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

/**
 * @author sam
 * @description 读取excel title数据
 * @param titleRows excel 中title所占的行数
 * */
public void readTitle(int titleRows) {
	if (titleRows == 2) {
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

/**
 * @author sam
 * @description get excel title数据
 * */
public HashMap<String, String> getTitle(){
	return titleMap;
}

/**
 * @author sam
 * @description get excel case数据
 * */
public HashMap<String, HashMap<String, String>> getMap(){
	return map;
}


}
