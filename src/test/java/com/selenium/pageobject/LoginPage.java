/*
 * This is pageObject which is contains all internal logic of selenium and java
 * PageObject contains methods and those methods will expose in step definition file
 * along with object.
 */
package com.selenium.pageobject;

import java.io.IOException;

import org.openqa.selenium.By;

import com.utility.selenium.BasePageObject;

/**
 * The Class LoginPage.
 * This is pageObject which is contains all internal logic of selenium and java
 * PageObject contains methods and those methods will expose in step definition file
 * along with object.
 * @param <T> the generic type
 */
public class LoginPage<T> extends BasePageObject<T>{

	/** The email ID. */
	private String emailID="Login_email";

	/** The Password ID. */
	private String PasswordID="Login_password";

	/** The remamber me name. */
	private String remamberMeName="autoLogin";

	/** The login btn xpath. */
	private String loginBtnXpath="//*[@id=\"Login\"]/div/div/div/div/div/div[2]/div[2]/div[1]/button";

	/**
	 * Do login.
	 * @author GS-1629
	 * @param username the username
	 * @param password the password
	 * @param remamber the remamber
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void doLogin(String username, String password, boolean remamber) throws IOException
	{
		sendKeys(By.id(emailID), username);
		sendKeys(By.id(PasswordID), password);
		if(remamber)
		{
			click(By.name(remamberMeName));
		}
	}

	/**
	 * Click on login btn.
	 * @author GS-1629
	 * @return the base page object
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public BasePageObject<T> clickOnLoginBtn() throws IOException
	{
		click(By.xpath(loginBtnXpath));
		return detectPage();
	}

	/**
	 * Verify invalid login message.
	 * @author GS-1629
	 * @return true, if successful
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public boolean verifyInvalidLoginMessage() throws IOException
	{
		return isDisplayed(By.xpath(""));
	}

	/**
	 * Lets login.
	 * @author GS-1629
	 */
	public void letsLogin()
	{
		selenium.findElement(By.id("abc")).click();
	}
}
