package com.appium.htj.pages;

import org.openqa.selenium.By;

/**@author Young
 * @description APP每次初始化出现的元素 页面元素类
 * */

public class InitPage {
	/**允许定位*/
	 public static final By IP_BUTTON_ACCEPT = By.id("flyme:id/accept"); 
	/**拒绝定位*/
	 public static final By IP_BUTTON_CANCEL = By.id("flyme:id/reject"); 
	 
	 /**元素组*/
	public static  By byElements[] = {IP_BUTTON_ACCEPT,IP_BUTTON_CANCEL};
	

}
