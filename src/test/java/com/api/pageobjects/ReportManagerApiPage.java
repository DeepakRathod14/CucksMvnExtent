/*
 * This class is used for implementing Reporting Manager
 * Related API calls inside this pageObject.
 */
package com.api.pageobjects;

import com.utility.api.BaseApiClass;

/**
 * The Class ReportManagerApiPage.
 * This class is used for implementing Reporting Manager
 * Related API calls inside this pageObject.
 */
public class ReportManagerApiPage extends BaseApiClass{

	/** The report manager api. */
	private static ReportManagerApiPage reportManagerApi = null;

	/**
	 * Instantiates a new report manager api page.
	 *
	 * @author GS-1629
	 * Instantiates a new report manager API page.
	 */
	private ReportManagerApiPage()
	{
		// It is for restricting creating object of ReportManager from outside of class
	}

	/**
	 * Gets the single instance of ReportManagerApiPage.
	 *@author GS-1629
	 * @return single instance of ReportManagerApiPage
	 */
	public static synchronized ReportManagerApiPage getInstance()
	{
		if (reportManagerApi == null)
		{
			reportManagerApi = new ReportManagerApiPage();
		}
		return reportManagerApi;
	}
}
