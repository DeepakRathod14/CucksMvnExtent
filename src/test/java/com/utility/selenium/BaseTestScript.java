/*
 *
 */
package com.utility.selenium;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

/**
 * @author GS-1629
 * The Class BaseTestScript for loading all browser related settings
 */
// ---------------------------------------------- BaseTestScript (BaseClass) for All TestScripts ---------------------------------------------
public class BaseTestScript
{

	/** The selenium. */
	public static WebDriver selenium = null;

	/** The ip. */
	private static String IP = "";

	/** The current username. */
	private static String CURRENT_USERNAME=System.getProperty("user.name");

	/** The browser. */
	public static String BROWSER;

	/** The application url. */
	public static String APPLICATIONURL;

	/** The username. */
	public static String USERNAME;

	/** The password. */
	public static String PASSWORD;

	/** The report location. */
	public static String REPORTLOCATION;

	/** The mail send. */
	public static String MAILSEND;

	/** The mail from. */
	public static String MAILFROM;

	/** The mail mailhost. */
	public static String MAILHOST;

	/** The mail to. */
	public static String MAILTO;

	/** The mail subject. */
	public static String MAILSUBJECT;

	/** The mail sub prefix. */
	public static String MAILSUBPREFIX;

	/** The db domain. */
	public static String DBDOMAIN;

	/** The db port. */
	public static String DBPORT;

	/** The db username. */
	public static String DBUSERNAME;

	/** The db password. */
	public static String DBPASSWORD;

	/** The db name. */
	public static String DBNAME;

	/** The api accept type. */
	public static String APIACCEPTTYPE;

	/** The api content type. */
	public static String APICONTENTTYPE;

	/** The logger. */
	public static final Logger logger = Logger.getLogger(BaseTestScript.class);

	/**
	 * @author GS-1629
	 * Static block for load property which load required configuration.
	 */
	static{
		FileReader propReader = null;
		try {
			propReader = new FileReader(new File("configuration/configuration.properties").getCanonicalPath());
			Properties prop=new Properties();
			prop.load(propReader);

			// PRIMARY SETTING FETCH
			BROWSER=prop.getProperty("Browser");
			APPLICATIONURL=prop.getProperty("Application.Base.Url");
			USERNAME=prop.getProperty("Username");
			PASSWORD=prop.getProperty("Password");
			REPORTLOCATION=prop.getProperty("Report.Output.Location");

			// MAIL CONFIGURATION SETTINGS
			MAILSEND=prop.getProperty("Mail.send");
			MAILHOST=prop.getProperty("Mail.Mailhost");
			MAILFROM=prop.getProperty("Mail.From");
			MAILTO=prop.getProperty("Mail.To");
			MAILSUBJECT=prop.getProperty("Mail.Subject");
			MAILSUBPREFIX=prop.getProperty("Mail.Subject.Prefix");

			// DATABASE CONFIGURATION SETTINGS
			DBDOMAIN=prop.getProperty("Db.Domain");
			DBPORT=prop.getProperty("Db.Port");
			DBUSERNAME=prop.getProperty("Db.Username");
			DBPASSWORD=prop.getProperty("Db.Password");
			DBNAME=prop.getProperty("Db.Name");

			// API CONFIGURATION SETTINGS
			APIACCEPTTYPE=prop.getProperty("Api.Accept.Type");
			APICONTENTTYPE=prop.getProperty("Api.Content.Type");

		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				propReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * Before test will load browser and initialized webdriver object.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// ----------------------------------------------- Always Run First for Test and Initialize WebDriver ----------------------------------------
	@BeforeTest
	public void beforeTest() throws IOException, InterruptedException
	{
		getStaticData();
		try
		{
			selenium = getSelenium();
			new CMEWebElement();
		}
		catch (UnhandledAlertException | InterruptedException AlertException)
		{
			logger.info("Some Exception is generate ");
		}
		logger.info("===============================================");
		logger.info("TESTCASE START TIME : " + systemTime());
		logger.info("===============================================");
	}

	/**
	 * This method will use for note test case start time.
	 * @author GS-1629
	 */
	@BeforeClass
	public void testCaseStartTime()
	{
		Reporter.log("==================================================");
		Reporter.log("Testcase Start Time : " + systemTime());
		Reporter.log("==================================================");
	}

	/**
	 * This method will use for note test case end time.
	 * @author GS-1629
	 */
	@AfterClass
	public void testCaseEndTime()
	{
		Reporter.log("==================================================");
		Reporter.log("Testcase End Time : " + systemTime());
		Reporter.log("==================================================");
	}

	/**
	 * Before method.
	 * @author GS-1629
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@BeforeMethod
	public void beforeMethod() throws InterruptedException, IOException
	{
		timeout(1);
		selenium.get(APPLICATIONURL);
	}

	/**
	 * This method will close browser and quite selenium session and terminate execution
	 * This will execute at the end of execution.
	 * @author GS-1629
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// ---------------------------------------------- Always Run Last for Test and Close Browser and quit to WebDriver ----------------------------
	@AfterTest
	public void afterTest() throws IOException
	{
		try
		{
			logger.info("===============================================");
			logger.info("TESTCASE END TIME : " + systemTime());
			logger.info("===============================================");
			selenium.close();
			selenium.quit();
			timeout(2);
			System.gc();
		}
		catch (Exception e)
		{
			Reporter.log("----------------------------------------------- BROWSER SERVICES DOESN'T CLOSE -----------------------------------------------");
		}
	}

	/**
	 * Gets the static data (On which machine automation is execute).
	 * @author GS-1629
	 * @return the static data
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void getStaticData() throws IOException
	{
		java.net.InetAddress localMachine = null;
		localMachine = java.net.InetAddress.getLocalHost();
		IP = localMachine.getHostAddress();

		logger.info("====================================== Local Machine DETAILS ===================================");
		logger.info("Hostname of local machine [  IP  ]: " + IP);
		logger.info("Hostname of local machine [ NAME ]: " + localMachine.getHostName());
		logger.info("Current LOGIN USER name is        : " + CURRENT_USERNAME);
		logger.info("Current execution BROWSER         : " + BROWSER);
		logger.info("Current execution on URL 		   : " + APPLICATIONURL);
		logger.info("Currently Application USERNAME    : " + USERNAME);
		logger.info("Currently Application PASSWORD    : " + PASSWORD);
		logger.info("=================================================================================================");
	}

	/**
	 * Gets the selenium (Load Driver as per given browser in property file).
	 * @author GS-1629
	 * @return the selenium
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	// -------------------------------------------------- Find Driver which given from properties ------------------------------------------------
	protected WebDriver getSelenium() throws IOException, InterruptedException
	{
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			File driverPath = new File("src/test/resources/drivers/chromedriver.exe").getCanonicalFile();
			System.setProperty("webdriver.chrome.driver", driverPath.getCanonicalPath());
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.content_settings.pattern_pairs.*.multiple-automatic-downloads", 1);
			prefs.put("browser.download.dir", driverPath.getCanonicalPath());
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--start-maximized");

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("chrome.binary", driverPath);
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			return new ChromeDriver(capabilities);
		}
		else if(BROWSER.equalsIgnoreCase("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
			FirefoxProfile profile = new FirefoxProfile();
			DesiredCapabilities dc=DesiredCapabilities.firefox();
			profile.setAcceptUntrustedCertificates(false);
			profile.setAssumeUntrustedCertificateIssuer(true);
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.helperApps.alwaysAsk.force", false);
			profile.setPreference("browser.download.manager.showWhenStarting",false);
			profile.setPreference("browser.download.dir", "src/test/resources/download");
			profile.setPreference("browser.download.downloadDir","src/test/resources/download");
			profile.setPreference("browser.download.defaultFolder","src/test/resources/download");
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/anytext ,text/plain,text/html,application/plain" );
			dc = DesiredCapabilities.firefox();
			dc.setCapability(FirefoxDriver.PROFILE, profile);
			return selenium =  new FirefoxDriver(dc);
		}
		else if(BROWSER.equalsIgnoreCase("InternetExplorer"))
		{
			//it is used to define IE capability
			System.setProperty("webdriver.ie.driver","src/test/resources/drivers/IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
			capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			capabilities.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
			capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,true);
			selenium= new InternetExplorerDriver(capabilities);
			return selenium;
		}
		else if(BROWSER.equalsIgnoreCase("PhanthomJS"))
		{
			File file = new File("src/test/resources/drivers/phantomjs.exe");
			System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
			return selenium = new PhantomJSDriver();
		}
		return null;
	}

	/**
	 * Generate System time in 12 Hrs format.
	 * @author GS-1629
	 * @return the string
	 */
	protected String systemTime()
	{
		Calendar calendar = new GregorianCalendar();
		String am_pm;
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		if (calendar.get(Calendar.AM_PM) == 0)
		{
			am_pm = "AM";
		}
		else
		{
			am_pm = "PM";
		}
		String fix_time = hour + "_" + minute + "_" + second + "_" + am_pm;

		return fix_time;
	}

	/**
	 * Generate Date and system time.
	 * @author GS-1629
	 * @return the date and time as string
	 */
	public static String dateAndSystemTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * Date and system time.
	 * @author GS-1629
	 * @param dateAndTimeFormat the date and time format
	 * @return the string
	 */
	public static String dateAndSystemTime(String dateAndTimeFormat)
	{
		DateFormat dateFormat = new SimpleDateFormat(dateAndTimeFormat);
		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * Gets the alert.
	 * @author GS-1629
	 * @param message the message
	 * @param second the second
	 * @return the alert
	 */
	protected void getAlert(String message, int second)
	{
		try
		{
			((JavascriptExecutor) selenium).executeAsyncScript("setTimeout(arguments[0]);setTimeout(function(){window.alert('" + message + "'); });");
			timeout(second);
			selenium.switchTo().alert().accept();
		}
		catch (Exception e)
		{
			logger.info("Fail To Generated or Handled Alert...!!! " + e.getMessage());
		}
	}

	/**
	 * Gets the random string.
	 * @author GS-1629
	 * @param lenghtOfNumber the lenght of number
	 * @return the random string
	 */
	protected String getRandomString(int lenghtOfNumber)
	{
		return RandomStringUtils.randomAlphabetic(lenghtOfNumber);
	}

	/**
	 * Generate random number.
	 * @author GS-1629
	 * @param charLength the char length
	 * @return the string
	 */
	protected String GenerateRandomNumber(int charLength)
	{
		return RandomStringUtils.randomNumeric(charLength);
	}

	/**
	 * Timeout will wait execution for given time period.
	 * @author GS-1629
	 * @param second the second
	 * @throws InterruptedException the interrupted exception
	 */
	protected void timeout(int second) throws InterruptedException
	{
		selenium.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
	}
}
