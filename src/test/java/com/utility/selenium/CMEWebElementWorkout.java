/*
 *
 */
package com.utility.selenium;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.selenium.listener.CMESelenium;

public class CMEWebElementWorkout implements CMESelenium {

	/** The Seconds. */
	public static int Seconds = 30;
	/** The logger. */
	private static Logger logger;
	/** The test url. */
	private String testUrl;
	/** The selenium. */
	protected WebDriver selenium;
	/** The action time. */
	protected String actionTime;
	/** The build. */
	private Actions build;
	/** The jse. */
	private JavascriptExecutor scriptExecutor;

	/**
	 * Instantiates a new CME web element.
	 * @author GS-1629
	 * @param driver the driver
	 */
	public CMEWebElementWorkout(WebDriver driver)
	{
		PropertyConfigurator.configure("configuration/log4j.properties");
		this.selenium = driver;
		logger = Logger.getLogger(this.getClass().getName());
		build = new Actions(selenium);
		scriptExecutor = (JavascriptExecutor) selenium;
	}

	/**
	 * Override method of selenium which will click on elemenet. This is more
	 * stable override method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return void
	 * @category Click
	 * @see org.openqa.selenium.WebElement#click()
	 */
	@Override
	public void click() {

	}

	/**
	 * Override method of selenium which will clickOnLinkText on elemenet. This
	 * is more stable override method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return void
	 * @category Click
	 * @see org.openqa.selenium.WebElement#clickOnLinkText()
	 */
	@Override
	public void clickOnLinkText(String linkText) {

	}

	/**
	 * Override method of selenium which will Submit on Element. This is more
	 * stable override method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return void
	 * @category Click
	 * @see org.openqa.selenium.WebElement#submit()
	 */
	@Override
	public void submit() {
		// do something
	}

	/**
	 * Override method of Selenium which will clear TextBox on Element. This is
	 * more stable override method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return void
	 * @category Keys
	 * @see org.openqa.selenium.WebElement#clear()
	 */
	@Override
	public void clear() {

	}

	/**
	 * Override method of Selenium which will sendKeys in TextBox on Element.
	 * This is more stable override method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return void
	 * @category Keys
	 * @see org.openqa.selenium.WebElement#sendKeys(CharSequence... keysToSend)
	 */
	@Override
	public void sendKeys(CharSequence... keysToSend) {

	}

	/**
	 * Override method of Selenium which will send sequence of Keys slowly in
	 * TextBox on Element. This is more stable override method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return void
	 * @category Keys
	 * @see com.utility.selenium.CMEWebElement.sendKeyswait(boolean
	 *      cleanElement, CharSequence... keysToSend)
	 */
	@Override
	public void sendKeyswait(boolean cleanElement, CharSequence... keysToSend) {
		// TODO Auto-generated method stub

	}

	/**
	 * Override method of Selenium which will getText from TextBox and return
	 * String. This is more stable override method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return String
	 * @category Keys
	 * @see org.openqa.selenium.WebElement#getText()
	 */
	@Override
	public String getText() {
		return null;
	}

	/**
	 * Override method of Selenium which will getText from list of TextBoxs or
	 * grid or listed table and return List<String>. This is more stable
	 * override method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return List<String>
	 * @category Keys
	 * @see org.openqa.selenium.WebElement#getTextAsList()
	 */
	@Override
	public List<String> getTextAsList(int sizeOfElements) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Override method of Selenium which will getTagName from TextBox and return
	 * String. This is more stable override method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return String
	 * @category Element
	 * @see org.openqa.selenium.WebElement#getTagName()
	 */
	@Override
	public String getTagName() {
		return null;
	}

	/**
	 * Override method of Selenium which will getAttribute from Element and
	 * return its attribute. This is more stable override method of
	 * CMEWebElement.
	 *
	 * @author GS-1629
	 * @return String
	 * @category Keys
	 * @see org.openqa.selenium.WebElement#getAttribute()
	 */
	@Override
	public String getAttribute(String attribute) {
		return null;
	}

	/**
	 * Override method of Selenium which will verify whether element is
	 * isSelected or not and return boolean. This is more stable override method
	 * of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return boolean
	 * @category BooleanElements
	 * @see org.openqa.selenium.WebElement#isSelected()
	 */
	@Override
	public boolean isSelected() {
		return false;
	}

	/**
	 * Override method of Selenium which will verify whether element is
	 * isEnabled or not and return boolean. This is more stable override method
	 * of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return boolean
	 * @category BooleanElements
	 * @see org.openqa.selenium.WebElement#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return false;
	}

	/**
	 * Override method of Selenium which will verify whether element is
	 * isDisplayed or not and return boolean. This is more stable override
	 * method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return boolean
	 * @category BooleanElements
	 * @see org.openqa.selenium.WebElement#isDisplayed()
	 */
	@Override
	public boolean isDisplayed() {
		return false;
	}

	/**
	 * Override method of Selenium which will verify whether element is
	 * isClickable or not and return boolean. This is more stable override
	 * method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return boolean
	 * @category BooleanElements
	 * @see org.openqa.selenium.WebElement#isClickable()
	 */
	@Override
	public boolean isClickable() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Override method of Selenium which will verify whether Link Text is
	 * display or not and return boolean. This is more stable override method of
	 * CMEWebElement.
	 *
	 * @author GS-1629
	 * @return boolean
	 * @category BooleanElements
	 * @see org.openqa.selenium.WebElement#isLinkTextDisplay()
	 */
	@Override
	public boolean isLinkTextDisplay(String linkText) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Override method of Selenium which will find multiple Elements as per its
	 * locator and return List of WebElement from DOM. This is more stable
	 * override method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return List<WebElement>
	 * @category FindElements
	 * @see org.openqa.selenium.WebElement#findElements()
	 */
	@Override
	public List<WebElement> findElements(By by) {
		return null;
	}

	/**
	 * Override method of Selenium which will find Single Elements as per its
	 * locator and return WebElement from DOM. This is more stable override
	 * method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return WebElement
	 * @category FindElements
	 * @see org.openqa.selenium.WebElement#findElement()
	 */
	@Override
	public WebElement findElement(By by) {
		return null;
	}

	/**
	 * Override method of Selenium which will Drag and Drop element from one
	 * place to other place. This is more stable override method of
	 * CMEWebElement.
	 *
	 * @author GS-1629
	 * @return void
	 * @category CustomizedWebElement
	 * @see com.utility.selenium.CMEWebElement.dragAndDrop();
	 */
	@Override
	public void dragAndDrop() {

	}

	/**
	 * Override method of Selenium which will handle(Accept) the Alert and
	 * getText and return that text as string. This is more stable override
	 * method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return String
	 * @category CustomizedWebElement
	 * @see com.utility.selenium.CMEWebElement.getPopupMsgAndAccept();
	 */
	@Override
	public String getPopupMsgAndAccept() {
		return null;
	}

	/**
	 * Override method of Selenium which will vertical scroll to page. This is
	 * more stable override method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return void
	 * @category CustomizedWebElement
	 * @see com.utility.selenium.CMEWebElement.scroll();
	 */
	@Override
	public void scroll(int verticalScroll) {
	}

	/**
	 * Override method of Selenium which will scroll to particular element if
	 * that element hide under scroll. This is more stable override method of
	 * CMEWebElement.
	 *
	 * @author GS-1629
	 * @return void
	 * @category CustomizedWebElement
	 * @see com.utility.selenium.CMEWebElement.scrollToElement();
	 */
	@Override
	public void scrollToElement() {
	}

	/**
	 * Override method of Selenium which will highlight webElement by
	 * javaScriptExecutor, so we can get see on screen which element is going to
	 * performed This is more stable override method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return void
	 * @category CustomizedWebElement
	 * @see com.utility.selenium.CMEWebElement.getHighlightElement();
	 */
	@Override
	public WebElement getHighlightElement() {
		return null;
	}

	/**
	 * Override method of Selenium which will delay until page load. This will
	 * give more stability to our execution. This is more stable override method
	 * of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return void
	 * @category CustomizedWebElement
	 * @see com.utility.selenium.CMEWebElement.delay();
	 */
	@Override
	public void delay() {

	}

	/**
	 * Override method of Selenium which will wait 500 Mili Second. This will
	 * give more stability to our execution. This is more stable override method
	 * of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return void
	 * @category CustomizedWebElement
	 * @see com.utility.selenium.CMEWebElement.delay();
	 */
	@Override
	public void timeInterval() {
	}

	/**
	 * Override method of Selenium which will wait for element to display until condition is not satisfied. This will
	 * give more stability to our execution. This is more stable override method
	 * of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return void
	 * @category CustomizedWebElement
	 * @see com.utility.selenium.CMEWebElement.waitForParticularElement();
	 */
	@Override
	public void waitForParticularElement(int second) {
	}

	/**
	 * Override method of Selenium which will getLocation of element it will
	 * return X,Y coordination of screen and return points. This is more stable
	 * override method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return Point (X,Y)
	 * @category FindWebElement
	 * @see org.openqa.selenium.WebElement#getLocation()
	 */
	@Override
	public Point getLocation() {
		return null;
	}

	/**
	 * Override method of Selenium which will getSize of screen it will return
	 * X,Y Dimension of screen and return points. This is more stable override
	 * method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return Dimension (X,Y)
	 * @category FindWebElement
	 * @see org.openqa.selenium.WebElement#getSize()
	 */
	@Override
	public Dimension getSize() {
		return null;
	}

	/**
	 * Override method of Selenium which will getRect area of screen. This is
	 * more stable override method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return Rectangle
	 * @category FindWebElement
	 * @see org.openqa.selenium.WebElement#getRect()
	 */
	@Override
	public Rectangle getRect() {
		return null;
	}

	/**
	 * Override method of Selenium which will getCssValue of given element and
	 * return it's CSS attribute whatever we wants as string. This is more
	 * stable override method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return String
	 * @category FindWebElement
	 * @see org.openqa.selenium.WebElement#getRect()
	 */
	@Override
	public String getCssValue(String propertyName) {
		return null;
	}

	/**
	 * Override method of Selenium which will getScreenshotAs different format
	 * it can be use for take picture of current screen. This is more stable
	 * override method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return <X> X
	 * @category ScreenShot
	 * @see org.openqa.selenium.WebElement#getScreenshotAs()
	 */
	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		return null;
	}

	/**
	 * Override method of Selenium which will use for select value from DropDown. This is more stable
	 * override method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return <X> X
	 * @category DropDownElement
	 * @see org.openqa.selenium.WebElement#selectOptionFromDropDown()
	 */
	@Override
	public void selectOptionFromDropDown(String option) {
		// TODO Auto-generated method stub
	}

	/**
	 * Override method of Selenium which will use for fetch value from DropDown and return as string. This is more stable
	 * override method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return <X> X
	 * @category DropDownElement
	 * @see org.openqa.selenium.WebElement#selectOptionFromDropDown()
	 */
	@Override
	public String getValueFromDropDown() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Override method of Selenium which will use for fetch all options from DropDown and return as List<string>. This is more stable
	 * override method of CMEWebElement.
	 *
	 * @author GS-1629
	 * @return <X> X
	 * @category DropDownElement
	 * @see org.openqa.selenium.WebElement#selectOptionFromDropDown()
	 */
	@Override
	public List<String> getValuesFromDropDown() {
		// TODO Auto-generated method stub
		return null;
	}
}
