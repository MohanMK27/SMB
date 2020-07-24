package pages;

import org.openqa.selenium.WebDriver;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Test;
//import browserFactory.*;
import browserFactory.ReusableLibrary;
import config.ActionKeywords;
//import browserFactory.ScriptHelper;
import executionEngine.DriverScript;

public class featureFake extends ReusableLibrary {
	protected WebDriver driver;
	String jsonPath, jsonData;

	public featureFake(WebDriver driver) {
		super(driver);
		this.driver = driver;

		jsonPath = getObjectfile(this.getClass().getSimpleName());
		jsonData = getDatatfile(this.getClass().getSimpleName());
	}

	public void contactUsForm() throws InterruptedException {
		try {
			//company name field
			clearText(locatorParser(jsonParser(jsonPath, "contactUs", "companyName")),locatorParser(jsonParser(jsonPath, "contactUs", "contactUsName")));																									Thread.sleep(2000);
			if(isDisplayed(locatorParser(jsonParser(jsonPath, "contactUs", "companyNameReq")), "companyNameReq")&&isBtnEnable(locatorParser(jsonParser(jsonPath, "contactUs", "send")), "send checking "))
			EnterText(locatorParser(jsonParser(jsonPath, "contactUs", "companyName")), jsonParser(jsonData, "contactUs", "companyName"));										Thread.sleep(1000);
			
			//UserName field
			clearText(locatorParser(jsonParser(jsonPath, "contactUs", "userName")),locatorParser(jsonParser(jsonPath, "contactUs", "contactUsName")));																									Thread.sleep(2000);
			if(isDisplayed(locatorParser(jsonParser(jsonPath, "contactUs", "userNameReq")), "userNameReq")&&isBtnEnable(locatorParser(jsonParser(jsonPath, "contactUs", "send")), "send checking "))
			EnterText(locatorParser(jsonParser(jsonPath, "contactUs", "userName")), jsonParser(jsonData, "contactUs", "userName"));										Thread.sleep(1000);
			
			//email field
			clearText(locatorParser(jsonParser(jsonPath, "contactUs", "email")),locatorParser(jsonParser(jsonPath, "contactUs", "contactUsName")));																									Thread.sleep(2000);
			if(isDisplayed(locatorParser(jsonParser(jsonPath, "contactUs", "emailReq")), "emailReq")&&isBtnEnable(locatorParser(jsonParser(jsonPath, "contactUs", "send")), "send checking "))
				{
				EnterTextTabClear(locatorParser(jsonParser(jsonPath, "contactUs", "email")), jsonParser(jsonData, "contactUs", "invalidEmail"));										Thread.sleep(1000);
				}
			if(isDisplayed(locatorParser(jsonParser(jsonPath, "contactUs", "emailInvalid")), "emailInvalid")&&isBtnEnable(locatorParser(jsonParser(jsonPath, "contactUs", "send")), "send checking "))
				{
				
				EnterTextClear(locatorParser(jsonParser(jsonPath, "contactUs", "email")), jsonParser(jsonData, "contactUs", "email"));										Thread.sleep(1000);
				}
			
			//phone number field
			clearText(locatorParser(jsonParser(jsonPath, "contactUs", "phoneNumber")),locatorParser(jsonParser(jsonPath, "contactUs", "contactUsName")));																									Thread.sleep(2000);
			if(isDisplayed(locatorParser(jsonParser(jsonPath, "contactUs", "phoneReq")), "phoneReq")&&isBtnEnable(locatorParser(jsonParser(jsonPath, "contactUs", "send")), "send checking "))
				{
				EnterTextTabClear(locatorParser(jsonParser(jsonPath, "contactUs", "phoneNumber")), jsonParser(jsonData, "contactUs", "invalidPhone"));										Thread.sleep(1000);
				}
			if(isDisplayed(locatorParser(jsonParser(jsonPath, "contactUs", "phoneInvalid")), "phoneInvalid")&&isBtnEnable(locatorParser(jsonParser(jsonPath, "contactUs", "send")), "send checking "))
				EnterTextClear(locatorParser(jsonParser(jsonPath, "contactUs", "phoneNumber")), jsonParser(jsonData, "contactUs", "phoneNumber"));										Thread.sleep(1000);
			
			
			//Click send
			ClickElement(locatorParser(jsonParser(jsonPath, "contactUs", "send")), "Send button in the pop-up"); 							Thread.sleep(2000);
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void propertyGroup() throws InterruptedException {
		try {
			
			ClickElement(locatorParser(jsonParser(jsonPath, "featureFakePage", "propertyGroup")), "propertyGroup");       								Thread.sleep(3000);
			ClickElement(locatorParser(jsonParser(jsonPath, "featureFakePage", "scheduleDemo")), "scheduleDemo");       								Thread.sleep(3000);
			
			contactUsForm();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void device() throws InterruptedException {
		try {
			
			ClickElement(locatorParser(jsonParser(jsonPath, "featureFakePage", "device")), "device");																Thread.sleep(3000);
			ClickElement(locatorParser(jsonParser(jsonPath, "featureFakePage", "learnMore")), "learnMore");       								Thread.sleep(4000);
			checkURL(jsonParser(jsonPath, "featureFakePage", "learnMore"));																											Thread.sleep(3000);
			//closedriver();
		
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selfShowingSettings() throws InterruptedException {
		try {
			
			ClickElement(locatorParser(jsonParser(jsonPath, "featureFakePage", "selfShowingSettings")), "selfShowingSettings");																		Thread.sleep(3000);
			ClickElement(locatorParser(jsonParser(jsonPath, "featureFakePage", "learnMore")), "learnMore");       																			Thread.sleep(3000);
				checkURL(jsonParser(jsonPath, "featureFakePage", "learnMore"));																																	Thread.sleep(3000);
			//closedriver();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void leads() throws InterruptedException {
		try {
			
			ClickElement(locatorParser(jsonParser(jsonPath, "featureFakePage", "leads")), "leads");															Thread.sleep(3000);
		
			ClickElement(locatorParser(jsonParser(jsonPath, "featureFakePage", "contactUs")), "contactUs");       								Thread.sleep(3000);
			
			contactUsForm();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void applicants() throws InterruptedException {
		try {
			// SwitchtoFrame("platform-iframe");
			ClickElement(locatorParser(jsonParser(jsonPath, "featureFakePage", "applicants")), "applicants");												Thread.sleep(3000);
			ClickElement(locatorParser(jsonParser(jsonPath, "featureFakePage", "contactUs")), "contactUs");       								Thread.sleep(3000);
			
			contactUsForm();
			
			
		} catch (IOException | ParseException e) {
			// \] Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void vendors() throws InterruptedException {
		try {
			// SwitchtoFrame("platform-iframe");
			ClickElement(locatorParser(jsonParser(jsonPath, "featureFakePage", "vendors")), "vendors");																	Thread.sleep(3000);
		
			ClickElement(locatorParser(jsonParser(jsonPath, "featureFakePage", "contactUs")), "contactUs");       								Thread.sleep(3000);
			
			contactUsForm();
		
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
