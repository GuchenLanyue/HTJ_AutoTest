package com.appium.htj.pages;

import org.openqa.selenium.By;

/**
 * @author sam
 * @description 验证码页面
 * */
public class VerificationPage {
	
	/**验证码页面title*/
	public static final By Verification_Title_TextView = By.id("com.huangtaiji.client:id/activity_title");
	
	/**第一位验证码输入框*/
	public static final By Verification_Code_Text1 = By.id("com.huangtaiji.client:id/tv_1");
	
	/**第二位验证码输入框*/
	public static final By Verification_Code_Text2 = By.id("com.huangtaiji.client:id/tv_2");
	
	/**第三位验证码输入框*/
	public static final By Verification_Code_Text3 = By.id("com.huangtaiji.client:id/tv_3");
	
	/**第四位验证码输入框*/
	public static final By Verification_Code_Text4 = By.id("com.huangtaiji.client:id/tv_4");
	
	/**重新发送验证码按钮*/
	public static final By Verification_GetAgain_Button = By.id("com.huangtaiji.client:id/bt_send_code");
	
	/**背景图片*/
	public static final By Verification_Background_Image = By.id("com.huangtaiji.client:id/dynamic_image_view");

}
