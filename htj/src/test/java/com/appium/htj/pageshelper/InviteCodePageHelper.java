package com.appium.htj.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.appium.htj.pages.loginPage.InviteCodePage;
import com.appium.htj.utils.AppiumUtil;

/**
 * @author sam
 * @description 登录后输入邀请码页面
 * */
public class InviteCodePageHelper {
	
	public static Logger logger = Logger.getLogger(InitPageHelper.class);
	
	/**等待加载输入邀请码页面UI*/
	public static void waitforInviterPageUI(AppiumUtil appiumUtil , int elementTimeOut){
		logger.info("等待加载输入邀请码页面UI");
		appiumUtil.waitForElementToLoad(elementTimeOut, InviteCodePage.InvitePage_Success_Image);
		appiumUtil.waitForElementToLoad(elementTimeOut, InviteCodePage.InvitePage_Success_Text);
		appiumUtil.waitForElementToLoad(elementTimeOut, InviteCodePage.InvitePage_TypeCode_EditText);
		appiumUtil.waitForElementToLoad(elementTimeOut, InviteCodePage.InvitePage_Tips_TextView);
		appiumUtil.waitForElementToLoad(elementTimeOut, InviteCodePage.InvitePage_Next_Button);
		logger.info("输入邀请码页面UI加载完毕");
	}
	
	/**验证输入邀请码页面登录成功文本*/
	public static void checkSuccessText(AppiumUtil appiumUtil,String expected){
		String actual = appiumUtil.getAttributeText(InviteCodePage.InvitePage_Success_Text, "name");
		appiumUtil.isTextCorrect(actual, expected);
	}
	
	/**验证输入邀请码页面输入邀请码文本*/
	public static void checkTypeCodeText(AppiumUtil appiumUtil,String expected){
		String actual = appiumUtil.getAttributeText(InviteCodePage.InvitePage_TypeCode_EditText, "name");
		appiumUtil.isTextCorrect(actual, expected);
	}
	
	/**验证输入邀请码页面输入邀请码所获得奖励文本*/
	public static void checkTipsText(AppiumUtil appiumUtil,String expected){
		String actual = appiumUtil.getAttributeText(InviteCodePage.InvitePage_Tips_TextView, "name");
		appiumUtil.isTextCorrect(actual, expected);
	}
	
	/**验证输入邀请码页面去点餐文本*/
	public static void checkNextText(AppiumUtil appiumUtil,String expected){
		String actual = appiumUtil.getAttributeText(InviteCodePage.InvitePage_Next_Button, "name");
		appiumUtil.isTextCorrect(actual, expected);
	}
	
	/**点击*/
	public static void clickInviteCodePage(AppiumUtil appiumUtil,By byElement) {
		appiumUtil.click(byElement);
	}
}
