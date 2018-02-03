/*
 *
 */
package com.selenium.pageobject;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.utility.selenium.CMEWebElement;

/**
 * The Class TestPage.
 */
public class TestPage extends CMEWebElement{

	/** The account link. */
	@FindBy(how = How.ID, using = "account")
	public CMEWebElement accountLink;


}
