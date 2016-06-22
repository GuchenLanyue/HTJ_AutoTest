package com.appium.htj.testcases.Login;

import java.io.IOException;
import java.util.Map;

import org.json.JSONException;
import org.testng.annotations.Test;

import com.appium.htj.base.BasePrepare;
import com.appium.htj.base.api.LoginSuccess;
import com.appium.htj.pages.LoginPage;
import com.appium.htj.pageshelper.LoginPageHelper;

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
		
//		/**点击用户协议*/
//		LoginPageHelper.loginPageClick(appiumUtil, LoginPage.Login_TextView_Protocol);
//		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		/**点击返回键*/
//		appiumUtil.goBack();
		
		/**等待元素加载完成*/
		LoginPageHelper.waitForLoginUI(appiumUtil, elementTimeOut);
		
		/**输入手机号*/
		LoginPageHelper.typeText(appiumUtil, LoginPage.login_EditText_PhoneNumber, data.get("PhoneNumber"));
		
		/**点击下一步按钮*/
		LoginPageHelper.loginPageClick(appiumUtil, LoginPage.Login_Button_Next);
		
//		API测试代码测试
		LoginSuccess loginSuccess;
		try {
			loginSuccess = new LoginSuccess(1);
			logger.info("Token:"+loginSuccess.getToken());
		} catch (JSONException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
