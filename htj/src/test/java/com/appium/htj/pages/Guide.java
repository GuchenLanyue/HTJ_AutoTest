package com.appium.htj.pages;

import org.openqa.selenium.By;

/**@author Sam
 * @description APP引导页
 * */

public class Guide {
//	/**搜索按钮*/
//	 public static final By HP_BUTTON_SEARCH = By.id("com.microsoft.bing:id/search"); 
//	/**更多内容按钮*/
//	 public static final By HP_BUTTON_MORE = By.id("com.microsoft.bing:id/search_homepage_hamburger"); 
//	/**图片按钮*/
//	 public static final By HP_BUTTON_IMAGE = By.id("com.microsoft.bing:id/hp_scope_images"); 
//	/**视频按钮*/
//	 public static final By HP_BUTTON_VDEDIO = By.id("com.microsoft.bing:id/hp_scope_videos"); 
//	/**学术按钮*/
//	 public static final By HP_BUTTON_ACADEMIC = By.id("com.microsoft.bing:id/hp_scope_academic"); 
//	/**词典按钮*/
//	 public static final By HP_BUTTON_DICT = By.id("com.microsoft.bing:id/hp_scope_dict");
//	 /**图片故事*/
//	 public static final By HP_LINK_STORY = By.id("com.microsoft.bing:id/opal_home_picture_story_text1");
	 
	 /**引导页ViewPager*/
	 public static final By Guide_image_pager = By.id("com.huangtaiji.client:id/vPager");
	 
	 /**引导页图片*/
	 public static final By Guide_image_image = By.xpath("//android.support.v4.view.ViewPager/android.widget.ImageView");
	//WebElement el = driver.findElement(By.xpath("//*[@text='Add Contact']"));
}
