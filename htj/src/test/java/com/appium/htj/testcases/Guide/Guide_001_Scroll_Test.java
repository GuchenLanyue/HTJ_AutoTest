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
		
//		/**获取引导页数量*/
//		List<?> guideList = GuidePageHelper.getGuidePages(appiumUtil);
//		logger.info("引导页数量为："+guideList.size());
//		
//		/**滑动引导页*/
//		for(int i = 0 ; i < guideList.size() ; i++){
//			GuidePageHelper.scrollGuide(appiumUtil);
//			logger.info("滑动第【"+i+"】张引导页");
//			/**等待1s*/
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		/**检查引导页图片是否显示*/
		GuidePageHelper.guideIsDisplayed(appiumUtil);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
