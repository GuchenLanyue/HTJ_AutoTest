package com.appium.htj.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.appium.htj.pages.loginPage.AdvertisingPage;
import com.appium.htj.utils.AppiumUtil;

/**
 * @author sam
 * @description 广告页帮助类
 * */
public class AdvertisingPageHelper{
	//本类日志对象
	public static Logger logger = Logger.getLogger(GuidePageHelper.class);
	
	/**等待广告页加载*/
	public static void waitforAdvertisingUI(AppiumUtil appiumUtil,int elementTimeOut) {
		logger.info("正在等待广告页元素加载");
		/**等待跳过按钮显示*/
		appiumUtil.waitForElementToLoad(elementTimeOut, AdvertisingPage.advertising_button_next);
		/**等待广告图片显示*/
		appiumUtil.waitForElementToLoad(elementTimeOut, AdvertisingPage.advertising_image_image);
		logger.info("广告页元素加载完毕");
	}
	
	/**广告页点击*/
	public static void advertisingClick(AppiumUtil appiumUtil,By byElement){
		appiumUtil.click(byElement);
	}
}
