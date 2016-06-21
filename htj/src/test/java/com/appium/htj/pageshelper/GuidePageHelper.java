package com.appium.htj.pageshelper;

import org.apache.log4j.Logger;

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
	
	/**等待引导页元素显示出来*/
	public static void waitGuideUI(AppiumUtil appiumUtil,int elementTimeOut){
		logger.info("正在等待APP引导页元素加载");
		appiumUtil.waitForElementToLoad(elementTimeOut, Guide.Guide_image_pager);
		appiumUtil.waitForElementToLoad(elementTimeOut, Guide.Guide_image_image);
		logger.info("APP引导页元素加载完成");
	}
	
	/**滑动引导页*/
	public static  void swipeGuide(AppiumUtil appiumUtil){
		appiumUtil.swipe(0.8f, 0.5f, 0.1f, 0.5f,1000);
	}
	
	/**点击引导页图片*/
	public static void guideClick(AppiumUtil appiumUtil) {
		appiumUtil.click(Guide.Guide_image_image);
	}
	
	/**判断引导页是否显示，显示则滑动*/
	public static void checkImageDisplayed(AppiumUtil appiumUtil){
		boolean isDesplayed = appiumUtil.elementIsdisplayed(Guide.Guide_image_image);
		if (isDesplayed) {
			for(int i = 0 ;i < 5 ; i++ ){
			logger.info("元素"+ Guide.Guide_image_image +"显示");
			swipeGuide(appiumUtil);
			guideClick(appiumUtil);
			}
			logger.info("引导页滑动完毕");
		}else{
			logger.info("引导页没有显示");
			return;
		}
	}
}
