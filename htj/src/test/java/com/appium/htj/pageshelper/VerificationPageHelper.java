package com.appium.htj.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.appium.htj.pages.loginPage.VerificationPage;
import com.appium.htj.utils.AppiumUtil;

public class VerificationPageHelper {
	//本类日志对象
	public static Logger logger = Logger.getLogger(GuidePageHelper.class);
	
	/**等待页面元素加载完成*/
	public static void waitforVerificationUI(AppiumUtil appiumUtil , int elementTimeOut){
		logger.info("等待加载验证码页面UI元素");
		appiumUtil.waitForElementToLoad(elementTimeOut, VerificationPage.Verification_Title_TextView);
		appiumUtil.waitForElementToLoad(elementTimeOut, VerificationPage.Verification_Code_Text1);
		appiumUtil.waitForElementToLoad(elementTimeOut, VerificationPage.Verification_Code_Text2);
		appiumUtil.waitForElementToLoad(elementTimeOut, VerificationPage.Verification_Code_Text3);
		appiumUtil.waitForElementToLoad(elementTimeOut, VerificationPage.Verification_Code_Text4);
		appiumUtil.waitForElementToLoad(elementTimeOut, VerificationPage.Verification_GetAgain_Button);
		appiumUtil.waitForElementToLoad(elementTimeOut, VerificationPage.Verification_Background_Image);
		logger.info("验证码页面UI元素加载完毕");
	}
	
	/**检查首页title文本
	 * @param expected 期望显示文本
	 * */
	public static void checkTitleT(AppiumUtil appiumUtil , String expected) {
		String actual = appiumUtil.getAttributeText(VerificationPage.Verification_Title_TextView, "name");
		appiumUtil.isTextCorrect(actual, expected);
	}
	
	/**验证重新发送验证码按钮是否包含指定文本
	 * @param expect 期望显示文本
	 * */
	public static void checkBtnTextContains(AppiumUtil appiumUtil , String expect) {
		String actual = appiumUtil.getAttributeText(VerificationPage.Verification_GetAgain_Button, "name");
		appiumUtil.isContains(actual, expect);
	}
	
	/**验证重新发送验证码按钮文本是否与期望文本显示一致
	 * @param expected 期望显示文本
	 * */
	public static void checkBtnTextCorrect(AppiumUtil appiumUtil , String expected) {
		String actual = appiumUtil.getAttributeText(VerificationPage.Verification_GetAgain_Button, "name");
		appiumUtil.isTextCorrect(actual, expected);
	}
	
	/**输入验证码*/
	public static void typeCode(AppiumUtil appiumUtil , String code){
		
		appiumUtil.typeContent(VerificationPage.Verification_Code_Text1, code);
		
	}
}
