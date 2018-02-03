/*
 *
 */
package com.utility.selenium;

import java.util.List;

import org.openqa.selenium.WebDriver;

public abstract class CMEDropDownElement extends CMEWebElementWorkout{



	public CMEDropDownElement(WebDriver driver) {
		super(driver);
	}

	@Override
	public void selectOptionFromDropDown(String option) {
		// TODO Auto-generated method stub
	}

	@Override
	public String getValueFromDropDown() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getValuesFromDropDown() {
		// TODO Auto-generated method stub
		return null;
	}
}
