/*
 *
 */
package com.utility.selenium;

import java.io.IOException;

import org.apache.log4j.Logger;

public class BasePageObject<T> extends CMEWebElement
{
	/** The logger. */
	public Logger logger = Logger.getLogger(getClass());

	/** The test url. */
	public String testUrl;

	/** The Seconds. */
	public int Seconds = 15;

	public static BasePageObject resultpage;

	public synchronized static BasePageObject getInstance()
	{
		if(resultpage==null)
		{
			resultpage = new BasePageObject();
		}
		return resultpage;
	}

	/**
	 * Detect page method will help us to identify which HTML page is currently on screen
	 * and based on that java will create object of that page and return it for further use.
	 * @author GS-1629
	 * @return the base page object BasePageObject<T>
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("unchecked")
	public BasePageObject<T> detectPage() throws IOException
	{
		delay();
		logger.info(selenium.getCurrentUrl());
		String url = selenium.getCurrentUrl();
		testUrl = BaseTestScript.APPLICATIONURL;

		if (url.startsWith(testUrl))
		{
			//			if (waitFordetectPage(By.xpath(".//body[@class='restrictedPage normalScreenMode']")))
			//			{
			//				return PageFactory.initElements(selenium, BasePageObject.class);
			//			}
		}
		else
		{
			logger.info("URL : " + url);
			logger.warn("No Page Detected");
			return null;
		}
		return null;

	}

	/**
	 * If we want to move back from current screen then this method will help us to move back
	 * @author GS-1629
	 * @return BasePageObject<T>
	 * @throws IOException
	 */
	public BasePageObject<T> gotoBackOnBrowser() throws IOException
	{
		selenium.navigate().back();
		timeInterval();
		return detectPage();
	}

	/**
	 * If we want to move forward from current screen then this method will help us to move forward
	 * @author GS-1629
	 * @return BasePageObject<T>
	 * @throws IOException
	 */
	public BasePageObject<T> gotoForwardOnBrowser() throws IOException
	{
		selenium.navigate().forward();
		timeInterval();
		return detectPage();
	}
}
