package com.appium.htj.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.appium.htj.pages.loginPage.LoginPage;
import com.appium.htj.utils.AppiumUtil;
import com.sun.jna.platform.win32.WinDef.BYTE;

public class LoginPageHelper {
	
	//本类日志对象
	public static Logger logger = Logger.getLogger(GuidePageHelper.class);
	
	/**等待登录页面元素加载*/
	public static void waitForLoginUI(AppiumUtil appiumUtil,int elementTimeOut) {
		logger.info("等待登录页页面元素加载");
		appiumUtil.waitForElementToLoad(elementTimeOut, LoginPage.Login_TextView_Title);
		appiumUtil.waitForElementToLoad(elementTimeOut, LoginPage.login_EditText_PhoneNumber);
		appiumUtil.waitForElementToLoad(elementTimeOut, LoginPage.Login_TextView_Accept);
		appiumUtil.waitForElementToLoad(elementTimeOut, LoginPage.Login_TextView_Protocol);
		logger.info("登录页面元素加载完成");
	}
	
	public static void loginPageClick(AppiumUtil appiumUtil,By by) {
		appiumUtil.click(by);
	}
	
	public static void typeText(AppiumUtil appiumUtil,By byElement, String str) {
		appiumUtil.typeContent(byElement, str);
	}
	
	public static void checkText(AppiumUtil appiumUtil,By elementLocator,String attribute,String expected) {
		String actual = appiumUtil.getAttributeText(elementLocator, attribute);
		appiumUtil.isTextCorrect(actual, expected);
	}
}
