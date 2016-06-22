package com.appium.htj.base.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class WriteExcel {
   
    /**
     * @param datas 封装着Object[]的列表, 一般是String内容.
     * @param title 每个sheet里的标题.
     */
    public void writeExcel(Workbook wb,String filepath,List list, String[] title , boolean booleanResult) {
        if(list == null) {
            throw new IllegalArgumentException("要写入excel的数据不能为空！");
        }
        
        int rowNum = 0;    //要写的行，jxl操作excel时，第一行是从0开始，以此类推
        
        try {
        	
    		WritableWorkbook workbook = Workbook.createWorkbook(new File(filepath), wb);
            WritableSheet ws = workbook.getSheet("result");//创建sheet
            
            if(title != null) {
                putRow(ws, 0, title,booleanResult);//压入标题
            }
            rowNum = ws.getRows();
            for(int i=0; i<list.size(); i++, rowNum++) {//写sheet
                Object[] cells = (Object[]) list.get(i);
                putRow(ws, rowNum, cells,booleanResult);    //压一行到sheet
            }
            workbook.write();
            workbook.close();    //一定要关闭, 否则没有保存Excel
        }catch (RowsExceededException e) {
            System.out.println("jxl write RowsExceededException: "+e.getMessage());
        } catch (WriteException e) {
            System.out.println("jxl write WriteException: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("jxl write file i/o exception!, cause by: "+e.getMessage());
        }
    }

    private void putRow(WritableSheet ws, int rowNum, Object[] cells,boolean booleanResult) throws RowsExceededException, WriteException {
    	
    	//1.添加带有字型Formatting的对象 
    	   WritableFont headerFont = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.RED);  //字体

    	//2.Format 
    	   WritableCellFormat headerFormat = new WritableCellFormat (headerFont);  //Format 一下

    	//3.加入标签  (列,行,"内容",字体)

//    	jxl.write.Label labelCF = new jxl.write.Label(1, 0, "This is a Label Cell", headerFormat );
    	if (booleanResult||rowNum==0) {
    		for(int j=0; j<cells.length; j++) {//写一行
                Label cell = new Label(j, rowNum, ""+cells[j]);
                ws.addCell(cell);
            }
		}else{
			for(int j=0; j<cells.length; j++) {//写一行
	            Label cell = new Label(j, rowNum, ""+cells[j],headerFormat);
	            ws.addCell(cell);
	        }
		}
    }
   
    public void result(String testCase,String msg,boolean booleanResult) {
    	
    	String result = "false";
    	if (booleanResult) {
			result = "true";
		}
    	File sdCardDir=new File("/sdcard");
    	String filepath = sdCardDir+"/robotium/data.xls";
    	InputStream fs = null;
    	Workbook wb = null;
    	
    	List list = new ArrayList();
		//组装写入excel的数据

        String[] data = {testCase,msg,result};
        list.add(data);
        
		try {
			fs = new FileInputStream(filepath);
			wb = Workbook.getWorkbook(fs);
			writeExcel(wb,filepath,list, new String[] {"TestCase", "msg","result"},booleanResult);
	        wb.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (BiffException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
