package com.appium.htj.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.appium.htj.pages.Guide;
import com.appium.htj.utils.AppiumUtil;
/**
 * 首页帮助类
 * 
 * */

public class GuidePageHelper {
	//本类日志对象
	public static Logger logger = Logger.getLogger(GuidePageHelper.class);
	
	/**
	 * @author Sam
	 * @param appiumUtil Appium封装对象引用
	 * @param byElement 要点击的元素By对象
	 * @description 在引导页上进行滑动操作
	 * */
	public static  void scrollGuide(AppiumUtil appiumUtil){
		int size[] = appiumUtil.getSize();
		int beginX = (int) (size[0]*0.8);
		int beginY = (int) (size[1]*0.5);
		int endX = (int) (size[0]*0.3);
		int endY = (int) (size[1]*0.5);
		
		appiumUtil.swipe(beginX, beginY, endX, endY);
	}
	
	/**等待首页元素显示出来*/
	public static void waitHomeUI(AppiumUtil appiumUtil,int elementTimeOut){
		logger.info("正在等待APP首页元素加载");
		appiumUtil.waitForElementToLoad(elementTimeOut, Guide.Guide_image_p);
		logger.info("APP首页元素加载完成");
	}
	
//	/**验证首页部分文本内容*/
//	public static void checkHomeUIText(AppiumUtil appiumUtil,String expected){
//		logger.info("正在验证APP首页文本内容是否正确");
//		appiumUtil.isTextCorrect(appiumUtil.getText(HomePage.HP_LINK_STORY), expected);
//		logger.info("验证APP首页文本内容完成");
//	}

}
