/*
 *
 */
package com.selenium.listener;
import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * The Interface CMESelenium which is extending WebElement interface
 * and also override all defaults methods of WenElement.
 */
public interface CMESelenium extends WebElement{

	/**
	 * CMEWebElement will take care of below methods.
	 * @author GS-1629
	 * @param cleanElement the clean element
	 * @param keysToSend the keys to send
	 */
	public abstract void sendKeyswait(boolean cleanElement,CharSequence... keysToSend);

	/**
	 * Checks if is clickable.
	 * @author GS-1629
	 * @return true, if is clickable
	 */
	public abstract boolean isClickable();

	/**
	 * Click on link text.
	 * @author GS-1629
	 * @param linkText the link text
	 */
	public abstract void clickOnLinkText(String linkText);

	/**
	 * Checks if is link text display.
	 * @author GS-1629
	 * @param linkText the link text
	 * @return true, if is link text display
	 */
	public abstract boolean isLinkTextDisplay(String linkText);

	/**
	 * Gets the text as list.
	 * @author GS-1629
	 * @param sizeOfElements the size of elements
	 * @return the text as list
	 */
	public abstract List<String> getTextAsList(int sizeOfElements);

	/**
	 * Drag and drop.
	 * @author GS-1629
	 */
	public abstract void dragAndDrop();

	/**
	 * Gets the popup msg and accept.
	 *@author GS-1629
	 * @return the popup msg and accept
	 */
	public abstract String getPopupMsgAndAccept();

	/**
	 * Scroll.
	 * @author GS-1629
	 * @param verticalPoint the vertical point
	 */
	public abstract void scroll(int verticalPoint);

	/**
	 * Scroll to element.
	 * @author GS-1629
	 */
	public abstract void scrollToElement();

	/**
	 * Wait for particular element.
	 * @author GS-1629
	 * @param second the second
	 */
	public abstract void waitForParticularElement(int second);

	/**
	 * Gets the highlight element.
	 * @author GS-1629
	 * @return the highlight element
	 */
	public abstract WebElement getHighlightElement();

	/**
	 * Delay.
	 * @author GS-1629
	 */
	public abstract void delay();

	/**
	 * Time interval.
	 * @author GS-1629
	 */
	public abstract void timeInterval();

	/**
	 * CMEDropDownElement will take care of below methods.
	 * @author GS-1629
	 * @param option the option
	 */
	public abstract void selectOptionFromDropDown(String option);

	/**
	 * Gets the value from drop down.
	 * @author GS-1629
	 * @return the value from drop down
	 */
	public abstract String getValueFromDropDown();

	/**
	 * Gets the values from drop down.
	 * @author GS-1629
	 * @return the values from drop down
	 */
	public abstract List<String> getValuesFromDropDown();


}
