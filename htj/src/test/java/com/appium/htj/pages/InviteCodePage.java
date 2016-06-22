package com.appium.htj.pages;

import org.openqa.selenium.By;

public class InviteCodePage {
	
	/**登录成功文本*/
	public static final By InvitePage_Success_Text = By.id("com.huangtaiji.client:id/tv_login_success");
	
	/**登录成功图片*/
	public static final By InvitePage_Success_Image = By.id("com.huangtaiji.client:id/iv_success");
	
	/**输入邀请码文本框*/
	public static final By InvitePage_TypeCode_EditText = By.id("com.huangtaiji.client:id/et_coupon_code");

	/**输入邀请码所奖励的文本*/
	public static final By InvitePage_Tips_TextView = By.id("com.huangtaiji.client:id/tv_coupon_tips");
	
	/**去点餐按钮*/
	public static final By InvitePage_Next_Button = By.id("com.huangtaiji.client:id/bt_next_step");
	
}
