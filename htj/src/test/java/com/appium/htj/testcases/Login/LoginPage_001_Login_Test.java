package com.appium.htj.testcases.Login;

import java.util.Map;

import org.testng.annotations.Test;

import com.appium.htj.base.BasePrepare;
import com.appium.htj.pages.AdvertisingPage;
import com.appium.htj.pages.InviteCodePage;
import com.appium.htj.pages.LoginPage;
import com.appium.htj.pages.ProtocolWebViewPage;
import com.appium.htj.pageshelper.AdvertisingPageHelper;
import com.appium.htj.pageshelper.InviteCodePageHelper;
import com.appium.htj.pageshelper.LoginPageHelper;
import com.appium.htj.pageshelper.ProtocolPageHelper;
import com.appium.htj.pageshelper.ProtocolWebViewPageHelper;
import com.appium.htj.pageshelper.VerificationPageHelper;

public class LoginPage_001_Login_Test extends BasePrepare{
	@Test(dataProvider="testData")
	public void login(Map<String, String> data) {
		
		/**等待元素加载完成*/
		LoginPageHelper.waitForLoginUI(appiumUtil, elementTimeOut);
		
		/**检查title文本*/
		LoginPageHelper.checkText(appiumUtil, LoginPage.Login_TextView_Title, "name", data.get("Title"));
		
		/**检查accept文本*/
		LoginPageHelper.checkText(appiumUtil, LoginPage.Login_TextView_Accept, "name", data.get("Accept"));

		/**检查用户协议文本*/
		LoginPageHelper.checkText(appiumUtil, LoginPage.Login_TextView_Protocol, "name", data.get("Protocol"));
		
		/**检查下一步按钮文本*/
		LoginPageHelper.checkText(appiumUtil, LoginPage.Login_Button_Next, "name", data.get("Next"));
		
		/**点击用户协议*/
		LoginPageHelper.loginPageClick(appiumUtil, LoginPage.Login_TextView_Protocol);
		
//		/**进入WebView*/
//		ProtocolWebViewPageHelper.enterWebview(appiumUtil, ProtocolWebViewPage.WEBVIEW_NAME);
		
		/**点击返回键*/
		ProtocolPageHelper.clickBackBtn(appiumUtil);
		
		/**等待元素加载完成*/
		LoginPageHelper.waitForLoginUI(appiumUtil, elementTimeOut);
		
		/**输入手机号*/
		LoginPageHelper.typeText(appiumUtil, LoginPage.login_EditText_PhoneNumber, data.get("PhoneNumber"));
		
		/**点击下一步按钮*/
		LoginPageHelper.loginPageClick(appiumUtil, LoginPage.Login_Button_Next);
		
		/**等待验证码页面元素加载*/
		VerificationPageHelper.waitforVerificationUI(appiumUtil, elementTimeOut);
		
		/**验证获取验证码页面Title文案*/
		VerificationPageHelper.checkTitleT(appiumUtil, data.get("VerificationTitle"));
		
		/**验证验证码倒计时文案*/
		VerificationPageHelper.checkBtnTextContains(appiumUtil, data.get("Countdown"));

		/**等待60s*/
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/**验证验证码页面重新获取验证码文案*/
		VerificationPageHelper.checkBtnTextCorrect(appiumUtil, data.get("GetAgain"));
		
		/**输入验证码*/
		VerificationPageHelper.typeCode(appiumUtil, "4743");
		
		/**等待加载输入邀请码页面UI*/
		InviteCodePageHelper.waitforInviterPageUI(appiumUtil, elementTimeOut);
		
		/**校验输入邀请码页面文本*/
		InviteCodePageHelper.checkSuccessText(appiumUtil, data.get("Success"));
		InviteCodePageHelper.checkTypeCodeText(appiumUtil, data.get("TypeCode"));
		InviteCodePageHelper.checkTipsText(appiumUtil, data.get("Tips"));
		InviteCodePageHelper.checkNextText(appiumUtil, data.get("OrderNext"));
		
		/**点击去点餐按钮*/
		InviteCodePageHelper.clickInviteCodePage(appiumUtil, InviteCodePage.InvitePage_Next_Button);
		
		/**等待广告页加载*/
		AdvertisingPageHelper.waitforAdvertisingUI(appiumUtil, elementTimeOut);
		
		/**点击跳过按钮*/
		AdvertisingPageHelper.advertisingClick(appiumUtil, AdvertisingPage.advertising_button_next);
		
		/***/
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
