package com.appium.htj.testcases.Guide;

import java.util.Map;

import org.testng.annotations.Test;

import com.appium.htj.base.BasePrepare;
import com.appium.htj.pageshelper.GuidePageHelper;

public class GuidePage_001_Scroll_Test extends BasePrepare{	
	@Test(dataProvider = "testData")
	public void guide(Map<String, String> data){
		
		/**等待引导页显示*/
		GuidePageHelper.waitGuideUI(appiumUtil, elementTimeOut);
		
		/**获取引导页数量*/
		int imgAccount = Integer.getInteger(data.get("ImgAccount"));
		/**检查引导页图片是否显示*/
		GuidePageHelper.checkImageDisplayed(appiumUtil,imgAccount);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
