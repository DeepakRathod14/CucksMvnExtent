/*
 * This class is for implementing all API calls
 * related to ReportRequestPage.
 */
package com.api.pageobjects;

import com.utility.api.BaseApiClass;

/**
 * The Class ReportRequestApiPage.
 * This class is for implementing all API calls
 * related to ReportRequestPage.
 */
public class ReportRequestApiPage extends BaseApiClass{

	/** The report request api. */
	private static ReportRequestApiPage reportRequestApi = null;

	/**
	 * Instantiates a new report request api page.
	 *
	 * @author GS-1629
	 * Instantiates a new report request api page.
	 */
	private ReportRequestApiPage()
	{
		// It is for restricting creating object of ReportRequest from outside of class
	}

	/**
	 * Gets the single instance of ReportRequestApiPage.
	 *@author GS-1629
	 * @return single instance of ReportRequestApiPage
	 */
	public static synchronized ReportRequestApiPage getInstance()
	{
		if (reportRequestApi == null)
		{
			reportRequestApi = new ReportRequestApiPage();
		}
		return reportRequestApi;
	}
}
