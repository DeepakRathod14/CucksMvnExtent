@RequestedReport
Feature: As a User of CME-EDB Reporting I am on Report Request Page. I am trying to validating all possible features and scenario of Report Request.

  @TC_RR_001 @Regression
  Scenario: Verify Components Visibility in Requested Report (landing) Page (TC_RR_001).
    Given Requested Reports page as landing page after successfully login.
    Then Verify "Requested Reports" Page is display.
    Then Verify breadcrumbs on Report Request Page.
    Then Verify New Report Request Button.
    Then Verify "Requested Reports" tab should be "Enable".
    And Verify "Schedule Reports" tab should be "Disable".

  @TC_RR_002
  Scenario: Verify Components Visibility in Blank Requested Reports (landing) Page (TC_RR_002).
    Given Requested Reports page as landing page after successfully login.
    Then Verify "Requested Reports" Page is display.
    And Verify page should display placeholder message "No requested to show".

  @TC_RR_003
  Scenario: Verify Grid Column Names in Requested Report Page (TC_RR_003)
    Given Requested Reports page as landing page after successfully login.
    Then Requested Report Grid should display its column name
      | ColumnName |
      | User ID    |
      | Report     |
      | Criteria   |
      | Time       |
      | Status     |

  @TC_RR_004
  Scenario: Verify Pagination Functionality in Requested Report Page (TC_RR_004)
    Given Requested Reports page as landing page after successfully login.
    When User create "30" default report requests for verify pagination.
    Then Click on "1" page link from pagination navigator
    And Verify on page "Previous" and "First" link should be disable.
    Then Click on "3" page link from pagination navigator
    And Verify on page "Next" and "Last" link should be disable.

  @TC_RR_005
  Scenario: Verify Grid Row Display Functionality in Requested Report Per Page (TC_RR_005)
    Given Requested Reports page as landing page after successfully login.
    Then Verify Requested Report Grid Page should display maximum "10" recoreds in single page.

  @TC_RR_006
  Scenario: Verify Sorting Functionality on Requested Report Page (TC_RR_006)
    Given Requested Reports page as landing page after successfully login.
    Then verify Requested Reports shorting functionality for all column.
      | ColumnName | Sorting Type |
      | User ID    | Accending    |
      | User ID    | Decending    |
      | Report     | Accending    |
      | Report     | Decending    |
      | Criteria   | Accending    |
      | Criteria   | Decending    |
      | Time       | Accending    |
      | Time       | Decending    |
      | Status     | Accending    |
      | Status     | Decending    |

  @TC_RR_007
  Scenario: Verify Search Functionality in Requested Reports (TC_RR_007)
    Given Requested Reports page as landing page after successfully login.
    When Create new Report Request of "Active Clerks" it should display on Requested Report page.
    Then Enter "Active Clerks" as keyword into globle search
    And Verify globle search result should be display all records of "Active Clerks" under "Report" heading in grid.
    Then Enter "Requested" as as keyword into globle search
    And Verify globle search result should be display all records of "Requested" under "Status" heading in grid.

  @TC_RR_008
  Scenario: Verify Status Icone Functionality in Requested Reports (TC_RR_008)
    Given Requested Reports page as landing page after successfully login.
    Then Verify "Requested" status in report request grid.
    And Verify "Ready" status in report request grid.
    And Verify "Done" status in report request grid.
    And Verify "No Recoreds" status in report request grid.
    And Verify "Failed" status in report request grid.

  @TC_RR_009
  Scenario: Verify Delete Report Functionality in Requested Reports (TC_RR_009)
    Given Requested Reports page as landing page after successfully login.
    When User select "Active Clerks" report from "Report" header and goto "Delete" option from action menu
    Then Verify delete popup with warnning message "Are you sure you want to delete" should be display.
    Then Click on "Cancel" button delete popup
    And Delete popup should be close and recored of "Active Clerks" under "Reports" heading should "Not be" delete from grid.
    When User select any recored and "Delete" option from action menu
    Then Click on "Ok" button delete popup
    And Delete popup should be close and recored should "Be" delete from grid.

  @TC_RR_010
  Scenario: Verify Download Report Functionality in Requested Reports (TC_RR_010)
    Given Requested Reports page as landing page after successfully login.
    When User select "Active Clerks" report from "Report" header and goto "Download" option from action menu
    Then Report should be downloaded into download directory.
