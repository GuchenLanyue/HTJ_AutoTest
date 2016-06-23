package com.appium.htj.testcases.Guide;

import java.util.Map;

import org.testng.annotations.Test;

import com.appium.htj.base.BasePrepare;
import com.appium.htj.pageshelper.GuidePageHelper;
import com.appium.htj.utils.PropertiesDataProvider;

public class GuidePage_001_Scroll_Test extends BasePrepare{	
	@Test(dataProvider = "testData")
	public void guide(Map<String, String> data){
		
		/**等待引导页显示*/
		GuidePageHelper.waitGuideUI(appiumUtil, elementTimeOut);
		
		/**获取引导页数量*/
		String accountStr = data.get("ImgAccount");
		
		/**将excle中获取的String类型的值转为int*/
		int imgAccount = Integer.valueOf(accountStr).intValue();
		
		/**检查引导页图片是否显示*/
		GuidePageHelper.checkImageDisplayed(appiumUtil,imgAccount);
		
		/**点击引导页图片*/
		GuidePageHelper.guideClick(appiumUtil);
		
	}
}
