package com.appium.htj.testcases.Guide;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.appium.htj.base.BasePrepare;
import com.appium.htj.pageshelper.GuidePageHelper;
import com.sun.jna.platform.win32.Guid;;

public class Guide_001_Scroll_Test extends BasePrepare{
	
//	@Test(dataProvider="testData")
//	public void uiCheck(Map<String, String> data){
//		/**滑动引导页*/
//		GuidePageHelper.scrollGuide(appiumUtil);
//	}
	
	@Test
	public void guide(){
		
		/**等待引导页显示*/
		GuidePageHelper.waitGuideUI(appiumUtil, elementTimeOut);
		
		/**检查引导页图片是否显示*/
		GuidePageHelper.checkImageDisplayed(appiumUtil);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
