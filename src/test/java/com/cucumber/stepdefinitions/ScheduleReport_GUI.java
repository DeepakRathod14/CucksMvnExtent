/*
 *
 */
package com.cucumber.stepdefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cucumber.listener.Reporter;
import com.selenium.pageobject.ScheduleReportPage;
import com.utility.selenium.BaseTestScript;
import com.utility.selenium.CMEAssert;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// TODO: Auto-generated Javadoc
/**
 * The Class ScheduleReport_GUI.
 */
public class ScheduleReport_GUI extends BaseTestScript {

	ScheduleReportPage schedulepage;


	@Before
	public void cucumberBefore(Scenario scenario) throws IOException, InterruptedException {
		Reporter.assignAuthor("Deepak Rathod");
		Reporter.addScenarioLog(scenario.getName());
		schedulepage = new ScheduleReportPage();
	}

	/**
	 * Click on tab.
	 *@author GS-1496
	 * @param arg1 the arg 1
	 * @throws Throwable the throwable
	 */
	@When("^Click on \"([^\"]*)\" tab\\.$")
	public void click_on_tab(String arg1) throws Throwable {
		Reporter.addScenarioLog("Testnig");
	}

	/**
	 * Scheduled report grid should display its column name.
	 *@author GS-1496
	 * @param scheduleheaderlist
	 * @throws Throwable the throwable
	 */
	@Then("^Scheduled Report Grid should display its column name$")
	public void scheduled_Report_Grid_should_display_its_column_name(DataTable scheduleheaderlist) throws Throwable {
		Reporter.addStepLog(" - Going to verify Schedule Grid Headers Name.");
		List<List<String>> data = scheduleheaderlist.raw();
		ArrayList<String> headings = new ArrayList<String>();
		for (int i = 0; i < data.size(); i++)
		{
			headings.add(data.get(i).get(0).trim());
		}
		boolean isAllHeadersAvailable = schedulepage.verifyGridHeading(headings);
		CMEAssert.assertTrue(isAllHeadersAvailable);
		Reporter.addStepLog("Expected Result");
		Reporter.addStepLog("==================");
		Reporter.addStepLog("PASS: All Headers are available in SR Grid, verification sccessfully.");

	}

	/**
	 * Verify scheduled grid page should display maximum records in single page.
	 *@author GS-1496
	 * @param arg1 the arg 1
	 * @throws Throwable the throwable
	 */
	@Then("^Verify Scheduled Grid Page should display maximum \"([^\"]*)\" recoreds in single page\\.$")
	public void verify_Scheduled_Grid_Page_should_display_maximum_recoreds_in_single_page(String maxschedulecount)
			throws Throwable {
	}

	/**
	 * User select any scheduled recored and option from action menu.
	 *@author GS-1496
	 * @param arg1 the arg 1
	 * @throws Throwable the throwable
	 */
	@When("^User select any scheduled recored and \"([^\"]*)\" option from action menu$")
	public void user_select_any_scheduled_recored_and_option_from_action_menu(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Reporter.addScenarioLog("Testnig");
	}

}
