package com.appium.htj.pages;

import org.openqa.selenium.By;

public class LoginPage {
	/**@author Sam
	 * @description APP引导页
	 * */
	/**登录页title*/
	public static final By Login_TextView_Title = By.id("com.huangtaiji.client:id/activity_title");
	/**登录页手机号码输入框*/
	public static final By login_EditText_PhoneNumber = By.id("com.huangtaiji.client:id/et_phone_number");
	/**登录页我已阅读并同意文本框*/
//	public static final By Login_TextView_Accept = By.xpath("//*[contains(@id,'com.huangtaiji.client:id/ll_tips')]/android.widget.TextView");
	public static final By Login_TextView_Accept = By.name("我已阅读并同意");
	/**登录页用户协议文本框*/
	public static final By Login_TextView_Protocol = By.id("com.huangtaiji.client:id/tv_protocol");
	/**登录页下一步按钮*/
	public static final By Login_Button_Next = By.id("com.huangtaiji.client:id/bt_next_step");
}
