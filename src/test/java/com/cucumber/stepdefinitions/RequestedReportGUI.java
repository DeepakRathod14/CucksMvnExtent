/*
 * This is Requested Report page step definition which is useful for
 * Integration of feature file and pageObject.
 * All pageObjects methods and assertion are call here. This is bridge between POM and feature file.
 */
package com.cucumber.stepdefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cucumber.listener.Reporter;
import com.selenium.pageobject.RequestedReportPage;
import com.utility.constant.CmeSelenium;
import com.utility.file.Downloaded_Verifier;
import com.utility.selenium.BaseTestScript;
import com.utility.selenium.CMEAssert;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * The Class RequestedReportGUI.
 * This is Requested Report page step definition which is useful for
 * Integration of feature file and pageObject.
 * All pageObjects methods and assertion are call here. This is bridge between POM and feature file.
 */
public class RequestedReportGUI extends BaseTestScript {

	RequestedReportPage reportpage;


	/**
	 * Cucumber before.
	 * @author GS-1629
	 * @param scenario the scenario
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	@Before
	public void cucumberBefore(Scenario scenario) throws IOException, InterruptedException {
		Reporter.assignAuthor("Deepak Rathod");
		Reporter.addScenarioLog(scenario.getName());
		reportpage = new RequestedReportPage();
	}


	/**
	 * Verify report requested page.
	 * @author GS-1629
	 * @throws Throwable the throwable
	 */
	@Given("^Requested Reports page as landing page after successfully login.$")
	public void verifyReportRequestedPage() throws Throwable {
		Reporter.addStepLog(" - Going to verification of current page title.");
		boolean isPageTitleMatch = reportpage.verifyCurrentPage("Requested Report");
		CMEAssert.assertTrue(isPageTitleMatch);
		Reporter.addStepLog("Expected Result");
		Reporter.addStepLog("==================");
		Reporter.addStepLog("PASS : Page Title verification successfully");
	}


	/**
	 * Verify current page visibility.
	 * @author GS-1629
	 * @param pageName the page name
	 * @throws Throwable the throwable
	 */
	@Then("^Verify (.*) Page is display.$")
	public void verifyCurrentPage(String pageName) throws Throwable {
		Reporter.addStepLog(" - Going to current loaded page "+pageName+".");
		Reporter.addStepLog("Expected Result");
		Reporter.addStepLog("==================");
		Reporter.addStepLog("PASS : "+pageName+" page verification successfully");
	}


	/**
	 * Verify breadcrumbs on report request page.
	 * @author GS-1629
	 * @throws Throwable the throwable
	 */
	@Then("^Verify breadcrumbs on Report Request Page\\.$")
	public void verifyBreadcrumbs() throws Throwable {
		Reporter.addStepLog(" - Going to performed breadcrumbs verification");
		boolean isSitemapAvailable = reportpage.verifyBreadcrumbs();
		CMEAssert.assertTrue(isSitemapAvailable);
		Reporter.addStepLog("Expected Result");
		Reporter.addStepLog("==================");
		Reporter.addStepLog("PASS: Breadcrumbs verification sccessfully.");
	}

	/**
	 * Verify new report request button.
	 * @author GS-1629
	 * @throws Throwable the throwable
	 */
	@Then("^Verify New Report Request Button\\.$")
	public void verifyNewReportRequestBtn() throws Throwable {
		Reporter.addStepLog(" - Going to verify New Report Request Butoon");
		boolean isButtonVisible = reportpage.verifyNewReportRequestButton();
		CMEAssert.assertTrue(isButtonVisible);
		Reporter.addStepLog("Expected Result");
		Reporter.addStepLog("==================");
		Reporter.addStepLog("PASS: New Repoer Requested Button verification sccessfully.");
	}


	/**
	 * Verify tab should be.
	 * @author GS-1629
	 * @param pageName the page name
	 * @param action the action
	 * @throws Throwable the throwable
	 */
	@Then("^Verify \"([^\"]*)\" tab should be \"([^\"]*)\"\\.$")
	public void verifyTabs(String pageName, String action) throws Throwable {
		Reporter.addStepLog(" - Going to verify tabs visiblity according to action");
		if(pageName.equalsIgnoreCase("Requested Reports") && action.equalsIgnoreCase("Enable"))
		{
			Reporter.addStepLog(" - Verify "+CmeSelenium.REQUESTED_REPORTS+" Tab is Enable and display it's all features.");
			boolean isReportTabEnable = reportpage.verifyTabsVisibility(CmeSelenium.REQUESTED_REPORTS, CmeSelenium.ENABLE);
			CMEAssert.assertTrue(isReportTabEnable);
		}
		if(pageName.equalsIgnoreCase("Requested Reports") && action.equalsIgnoreCase("Disable"))
		{
			Reporter.addStepLog(" - Verify "+CmeSelenium.REQUESTED_REPORTS+" Tab is Disable and Hide it's all features.");
			boolean isReportTabDisable = reportpage.verifyTabsVisibility(CmeSelenium.SCHEDULE_REPORTS, CmeSelenium.DISABLE);
			CMEAssert.assertTrue(isReportTabDisable);
		}
		else if(pageName.equalsIgnoreCase("Schedule Reports")  && action.equalsIgnoreCase("Enable"))
		{
			Reporter.addStepLog(" - Verify "+CmeSelenium.SCHEDULE_REPORTS+" Tab is Enable and display it's all features.");
			boolean isScheduleTabEnable = reportpage.verifyTabsVisibility(CmeSelenium.REQUESTED_REPORTS, CmeSelenium.ENABLE);
			CMEAssert.assertTrue(isScheduleTabEnable);
		}
		else if(pageName.equalsIgnoreCase("Schedule Reports")  && action.equalsIgnoreCase("Disable"))
		{
			Reporter.addStepLog(" - Verify "+CmeSelenium.REQUESTED_REPORTS+" Tab is Disable and Hide it's all features.");
			boolean isScheduleTabDisable = reportpage.verifyTabsVisibility(CmeSelenium.SCHEDULE_REPORTS, CmeSelenium.DISABLE);
			CMEAssert.assertTrue(isScheduleTabDisable);
		}
		Reporter.addStepLog("Expected Result");
		Reporter.addStepLog("==================");
		Reporter.addStepLog("PASS: Current loaded Page verification sccessfully.");
	}


	/**
	 * Verify page should display placeholder message.
	 * @author GS-1629
	 * @param String as display Message into the Requested Report Grid
	 * @throws Throwable the throwable
	 */
	@Then("^Verify page should display placeholder message \"([^\"]*)\"\\.$")
	public void verifyPlaceHolderMsgFromGrid(String displayMessage) throws Throwable {
		Reporter.addStepLog(" - Going to verify Empty Grid Place Holder Message.");
		boolean isPlaceHolderMsgMatch = reportpage.verifyBlankPagePlaceHolderMsg(displayMessage);
		CMEAssert.assertTrue(isPlaceHolderMsgMatch);
		Reporter.addStepLog("Expected Result");
		Reporter.addStepLog("==================");
		Reporter.addStepLog("PASS: Current loaded Page verification sccessfully.");
	}


	/**
	 * Requested report grid should display its column name.
	 * @author GS-1629
	 * @param gridHeaderList the grid header list
	 * @throws Throwable the throwable
	 */
	@Then("^Requested Report Grid should display its column name$")
	public void verifyColumnsFromGrid(DataTable gridHeaderList) throws Throwable {
		Reporter.addStepLog(" - Going to verify Grid Headers Name.");
		List<List<String>> data = gridHeaderList.raw();
		ArrayList<String> headings = new ArrayList<String>();
		for (int i = 0; i < data.size(); i++)
		{
			headings.add(data.get(i).get(0).trim());
		}
		boolean isAllHeadersAvailable = reportpage.verifyGridHeading(headings);
		CMEAssert.assertTrue(isAllHeadersAvailable);
		Reporter.addStepLog("Expected Result");
		Reporter.addStepLog("==================");
		Reporter.addStepLog("PASS: All Headers are available in RR Grid, verification sccessfully.");
	}


	/**
	 * User create default report requests for verify pagination.
	 * @author GS-1629
	 * @param numberOfReports the number of reports
	 * @throws Throwable the throwable
	 */
	@When("^User create \"([^\"]*)\" default report requests for verify pagination\\.$")
	public void createBunchReportRequest(String numberOfReports) throws Throwable {
		Reporter.addStepLog(" - Going to create "+numberOfReports+ " number of Request for verify pagination.");
	}

	/**
	 * Click on page link from pagination navigator.
	 * @author GS-1629
	 * @param pageNumber the page number
	 * @throws Throwable the throwable
	 */
	@Then("^Click on \"([^\"]*)\" page link from pagination navigator$")
	public void clickOnPaginationLink(String pageNumber) throws Throwable {
		Reporter.addStepLog(" - Going to click on PageNumner: "+pageNumber+" from pagination.");
		reportpage.clickOnPaginationNumber(pageNumber);
	}


	/**
	 * Verify on page and link should be disable.
	 * @author GS-1629
	 * @param navigationLink1 the navigation link 1
	 * @param navigationLink2 the navigation link 2
	 * @throws Throwable the throwable
	 */
	@Then("^Verify on page \"([^\"]*)\" and \"([^\"]*)\" link should be disable\\.$")
	public void verifyPaginationLinks(String navigationLink1, String navigationLink2) throws Throwable {
		Reporter.addStepLog(" - Going to verify page navigation links visibility");
		boolean isLink1Enable = reportpage.verifyPageNavigationLinkEnable(navigationLink1);
		boolean isLink2Enable = reportpage.verifyPageNavigationLinkEnable(navigationLink2);
		CMEAssert.assertTrue(isLink1Enable && isLink2Enable);
		Reporter.addStepLog("Expected Result");
		Reporter.addStepLog("==================");
		Reporter.addStepLog("PASS: All Headers are available in RR Grid, verification sccessfully.");
	}


	/**
	 * Verify requested report grid page should display maximum records in single page.
	 * @author GS-1629
	 * @param maxRecoredCount the max recored count
	 * @throws Throwable the throwable
	 */
	@Then("^Verify Requested Report Grid Page should display maximum \"([^\"]*)\" recoreds in single page\\.$")
	public void verifyMaxRecordFromGrid(String maxRecordsCount)
			throws Throwable {
		Reporter.addStepLog(" - Going to verify maximum row count");
		int row = Integer.parseInt(maxRecordsCount);
		boolean isdefaultSize = reportpage.verifyGridMaxRowSize(row);
		CMEAssert.assertTrue(isdefaultSize);
		Reporter.addStepLog("Expected Result");
		Reporter.addStepLog("==================");
		Reporter.addStepLog("PASS: Grid Default size is match with max count.");
	}


	/**
	 * Verify requested reports for all column sorting in ordered.
	 * @author GS-1629
	 * @param gridHeaderList the grid header list
	 * @throws Throwable the throwable
	 */
	@Then("^verify Requested Reports shorting functionality for all column.$")
	public void verifyShortingFromGrid(DataTable gridHeaderList) throws Throwable {
		Reporter.addStepLog(" - Going to verify sorting as per given table");
		List<List<String>> data = gridHeaderList.raw();
		for (int i = 0; i < data.size(); i++)
		{
			boolean isSorted = reportpage.VerifyGridSorting(data.get(i).get(0).trim(), data.get(i).get(2).trim());
			CMEAssert.assertTrue(isSorted);
		}
		Reporter.addStepLog("Expected Result");
		Reporter.addStepLog("==================");
		Reporter.addStepLog("PASS: All columns sorting functionality working fine.");
	}


	/**
	 * Enter as report name into globle search.
	 * @author GS-1629
	 * @param searchKeywork the search keywork
	 * @throws Throwable the throwable
	 */
	@Then("^Enter \"([^\"]*)\" as keyword into globle search$")
	public void globleSearchKeyword(String searchKeywork) throws Throwable {
		Reporter.addStepLog(" - Going to performed globle search");
		reportpage.gotoGlobleSearch(searchKeywork);
	}


	/**
	 * Verify search result should be display all in grid.
	 * @author GS-1629
	 * @param searchKeyword the search keyword
	 * @param columnHeading the column heading
	 * @throws Throwable the throwable
	 */
	@Then("^Verify globle search result should be display all records of  \"([^\"]*)\" under \"([^\"]*)\" heading in grid.$")
	public void verifySearchResultFromGrid(String searchKeyword, String columnHeading) throws Throwable {
		Reporter.addStepLog(" - Going to verify searching result in Requested Report Grid.");
		boolean isRecoredDisplay = reportpage.verifyGridGlobleSearchRecored(columnHeading, searchKeyword);
		CMEAssert.assertTrue(isRecoredDisplay);
		Reporter.addStepLog("Expected Result");
		Reporter.addStepLog("==================");
		Reporter.addStepLog("PASS: Only those records are display as per searching.");
	}


	/**
	 * Verify status in report request grid.
	 * @author GS-1629
	 * @param arg1 the arg 1
	 * @throws Throwable the throwable
	 */
	@Then("^Verify \"([^\"]*)\" status in report request grid\\.$")
	public void verifyStatusFromGrid(String arg1) throws Throwable {
		Reporter.addStepLog(" - Going to verify status into Requested Report grid");

	}

	/**
	 * Creates the new report request of it should display on requested report page.
	 * @author GS-1629
	 * @param reportName the report name
	 * @throws Throwable the throwable
	 */
	@When("^Create new Report Request of \"([^\"]*)\" it should display on Requested Report page\\.$")
	public void createNewReportRequest(String reportName) throws Throwable {
		Reporter.addStepLog(" - Going to create new Report Request : "+reportName);
	}


	/**
	 * User select any recored and option from action menu.
	 * @author GS-1629
	 * @param columnName the column name
	 * @param heading the heading
	 * @param actionMenu the action menu
	 * @throws Throwable the throwable
	 */
	@When("^User select \"([^\"]*)\" report from \"([^\"]*)\" header and goto \"([^\"]*)\" option from action menu$")
	public void selectRecordAndPerformedAction(String recordDetail, String columnName, String actionMenu) throws Throwable {
		Reporter.addStepLog(" - Going to select Record and select "+actionMenu+" from Action Menu.");
		reportpage.gotoFindRecoredPerformedAction(columnName, recordDetail, actionMenu);
	}


	/**
	 * Verify delete popup with warning message should be display.
	 * @author GS-1629
	 * @param deleteWarnningMsg the delete warning msg
	 * @throws Throwable the throwable
	 */
	@Then("^Verify delete popup with warnning message \"([^\"]*)\" should be display\\.$")
	public void verifyDeleteWinWarningMsg(String deleteWarningMsg) throws Throwable {
		Reporter.addStepLog(" - Going to verify Delete Warning Message");
		boolean isWarningMsgMatch = reportpage.verifyDeletePopupMessage(deleteWarningMsg);
		CMEAssert.assertTrue(isWarningMsgMatch);
		Reporter.addStepLog("Expected Result");
		Reporter.addStepLog("==================");
		Reporter.addStepLog("PASS: Delete pop-up warning message is display proper");
	}


	/**
	 * Click on button delete popup.
	 * @author GS-1629
	 * @param deleteAction the delete action
	 * @throws Throwable the throwable
	 */
	@Then("^Click on \"([^\"]*)\" button delete popup$")
	public void deleteConfirmationWindow(String deleteAction) throws Throwable {
		Reporter.addStepLog(" - Going to performed Delete Action "+deleteAction);
		reportpage.gotoDeleteAction(deleteAction);
	}


	/**
	 * Delete popup should be close and recored should delete from grid.
	 * @author GS-1629
	 * @param recordData the record data
	 * @param heading the heading
	 * @param visibility the visibility
	 * @throws Throwable the throwable
	 */
	@Then("^Delete popup should be close and recored of  \"([^\"]*)\" under \"([^\"]*)\" heading should \"([^\"]*)\" delete from grid\\.$")
	public void closeDeleteWindowAndVerifyGridRecord(String recordData, String heading, String visibility) throws Throwable {
		Reporter.addStepLog(" - ");
		boolean isDeleted = reportpage.verifyGridSingleRecored(heading, recordData);
		if(visibility.equalsIgnoreCase("not be"))
		{
			CMEAssert.assertTrue(isDeleted);
		}
		else if(visibility.equalsIgnoreCase("be"))
		{
			CMEAssert.assertFalse(isDeleted);
		}
		Reporter.addStepLog("Expected Result");
		Reporter.addStepLog("==================");
		Reporter.addStepLog("PASS: Delete pop-up close and recored should "+visibility+" deleted");
	}


	/**
	 * Report should be downloaded into download directory.
	 * @author GS-1629
	 * @throws Throwable the throwable
	 */
	@Then("^Report should be downloaded into download directory\\.$")
	public void verifyDownloadFile() throws Throwable {
		Reporter.addStepLog(" - Going to verify download directory");
		Downloaded_Verifier download = new Downloaded_Verifier();
		boolean isDownload = download.verifyDocumentDownloaded("abc.doc");
		CMEAssert.assertTrue(isDownload);
		Reporter.addStepLog("Expected Result");
		Reporter.addStepLog("==================");
		Reporter.addStepLog("PASS: Document is successfully downloaded into download directory");
	}
}
