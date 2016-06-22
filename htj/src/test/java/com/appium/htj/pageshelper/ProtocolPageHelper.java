package com.appium.htj.pageshelper;

import com.appium.htj.pages.ProtocolPage;
import com.appium.htj.utils.AppiumUtil;

public class ProtocolPageHelper {
	
	/**点击返回按钮*/
	public static void clickBackBtn(AppiumUtil appiumUtil){
		appiumUtil.click(ProtocolPage.Protocol_Back_LinearLayout);
	}
}
