package com.appium.htj.pages;

import org.openqa.selenium.By;

/**@author Sam
 * @description APP引导页
 * */

public class Guide {

	 /**引导页ViewPager*/
	 public static final By Guide_image_pager = By.id("com.huangtaiji.client:id/vPager");
	 
	 /**引导页图片*/
	 public static final By Guide_image_image = By.xpath("//android.support.v4.view.ViewPager/android.widget.ImageView");
	//WebElement el = driver.findElement(By.xpath("//*[@text='Add Contact']"));
}
