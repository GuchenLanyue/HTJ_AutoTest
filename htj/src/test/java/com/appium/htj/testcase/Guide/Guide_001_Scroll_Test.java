package com.appium.htj.testcase.Guide;

import java.util.Map;

import org.testng.annotations.Test;

import com.appium.htj.base.BasePrepare;
import com.appium.htj.pageshelper.GuidePageHelper;;

public class Guide_001_Scroll_Test extends BasePrepare{
	
	@Test(dataProvider="testData")
	public void uiCheck(Map<String, String> data){
		/**滑动引导页*/
		GuidePageHelper.scrollGuide(appiumUtil);
	}
}
