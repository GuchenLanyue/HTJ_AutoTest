package com.appium.htj.pageshelper;

import org.testng.log4testng.Logger;

import com.appium.htj.utils.AppiumUtil;

public class ProtocolWebViewPageHelper {
	
	static Logger logger = Logger.getLogger(ProtocolWebViewPageHelper.class);
	/**进入指定的webview内容中*/
	public static void enterWebview(AppiumUtil appiumUtil,String webview){
		appiumUtil.switchWebview(webview);
	}
	
}
