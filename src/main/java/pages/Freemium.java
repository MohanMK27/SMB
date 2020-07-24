package pages;

import java.io.FileNotFoundException;
import pages.Scheduler;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browserFactory.ReusableLibrary;
import executionEngine.DriverScript;

public class Freemium extends ReusableLibrary {

	protected WebDriver driver;
	String jsonPath, jsonData;
	Scheduler use= new Scheduler(driver);

	// JSON object and Data location
	// Constructor for scheduler
	public Freemium(WebDriver driver) {

		super(driver);
		this.driver = driver;
		jsonPath = getObjectfile(this.getClass().getSimpleName());
		jsonData = getDatatfile(this.getClass().getSimpleName());

	}
	
	public void signin() throws IOException, ParseException
	{
	
				//System.out.println("");
				getApplication(readPropertyFile("URL1"));
				//if (isDisplayed(locatorParser(jsonParser(jsonPath, "login", "checkPage")), "Checking sign in page"))
				{
					ImplicitWaitSwitch(3000);
				EnterText(locatorParser(jsonParser(jsonPath, "signin", "email")),jsonParser(jsonData, "signin", "email"));
				EnterText(locatorParser(jsonParser(jsonPath, "signin", "password")), jsonParser(jsonData, "signin", "password"));
				ClickElement(locatorParser(jsonParser(jsonPath, "signin", "signin")), "signin");
				if (isDisplayed(locatorParser(jsonParser(jsonPath, "signin", "checkSignin")), "Checking sign in"))
					System.out.println("Signed in!!!");
				}
		
	}
	public void signup() throws IOException, ParseException
	{
	
				//System.out.println("");
				getApplication(readPropertyFile("URL"));
				//if (isDisplayed(locatorParser(jsonParser(jsonPath, "login", "checkPage")), "Checking sign in page"))
				{
				EnterText(locatorParser(jsonParser(jsonPath, "signup", "companyname")),jsonParser(jsonData, "signup", "companyname"));
				EnterText(locatorParser(jsonParser(jsonPath, "signup", "fullname")),jsonParser(jsonData, "signup", "fullname"));
				EnterText(locatorParser(jsonParser(jsonPath, "signup", "phone")),jsonParser(jsonData, "signup", "phone"));
				EnterText(locatorParser(jsonParser(jsonPath, "signup", "email")),jsonParser(jsonData, "signup", "email"));
				EnterText(locatorParser(jsonParser(jsonPath, "signup", "password")),jsonParser(jsonData, "signup", "password"));
				EnterText(locatorParser(jsonParser(jsonPath, "signup", "cnfpassword")),jsonParser(jsonData, "signup", "cnfpassword"));
				ClickElement(locatorParser(jsonParser(jsonPath, "signup", "signupBtn")), "signupBtn");
				if (isDisplayed(locatorParser(jsonParser(jsonPath, "signin", "checkSignin")), "Checking sign in"))
					System.out.println("Signed in!!!");
				ImplicitWaitSwitch(3000);
				isDisplayed(locatorParser(jsonParser(jsonPath, "properties", "checkOnmarket")), "Checking checkOnmarket");
				
				}
		
	}
	public void addProperties() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		if (isDisplayed(locatorParser(jsonParser(jsonPath, "navbar", "onMarket")), "onMarket"))
			ClickElement(locatorParser(jsonParser(jsonPath, "navbar", "onMarket")), "onMarket Selected");
		else {
			ClickElement(locatorParser(jsonParser(jsonPath, "navbar", "properties")), "properties selected");
			ClickElement(locatorParser(jsonParser(jsonPath, "navbar", "onMarket")), "onMarket Selected");
			}
			SwitchtoFrame("platform-iframe");
			ImplicitWaitSwitch(3000);
			isDisplayed(locatorParser(jsonParser(jsonPath, "properties", "checkOnmarket")), "checkOnmarket");
			ClickElement(locatorParser(jsonParser(jsonPath, "properties", "addProperties")), "addProperties Selected");
			if (isDisplayed(locatorParser(jsonParser(jsonPath, "properties", "checkAddProperties")), "checkAddProperties"))
				ClickElement(locatorParser(jsonParser(jsonPath, "properties", "selectPropertyType")), "selectPropertyType Selected");
			liSelect(locatorParser(jsonParser(jsonPath, "properties", "selectPropertyUL")),jsonParser(jsonData, "properties", "propertyType"));
			EnterTextByEntert(locatorParser(jsonParser(jsonPath, "properties", "address")),jsonParser(jsonData, "properties", "address"));
			//EnterBtn();
			EnterText(locatorParser(jsonParser(jsonPath, "properties", "price")),jsonParser(jsonData, "properties", "price"));
			EnterText(locatorParser(jsonParser(jsonPath, "properties", "bed")),jsonParser(jsonData, "properties", "bed"));
			EnterText(locatorParser(jsonParser(jsonPath, "properties", "bath")),jsonParser(jsonData, "properties", "bath"));
																																																						Thread.sleep(1000);
			ClickElement(locatorParser(jsonParser(jsonPath, "properties", "saveBtn")), "save button Selected");
			
			if (isDisplayed(locatorParser(jsonParser(jsonPath, "properties", "availSetup")), "availSetup popup"))
				ClickElement(locatorParser(jsonParser(jsonPath, "properties", "later")), "later button Selected");
																																																																																					Thread.sleep(1000);
	}
	public void addAgents() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		
		if (isDisplayed(locatorParser(jsonParser(jsonPath, "navbar", "agents")), "agents"))
			ClickElement(locatorParser(jsonParser(jsonPath, "navbar", "agents")), "agents Selected");
		else 
		{
			ClickElement(locatorParser(jsonParser(jsonPath, "navbar", "company")), "Company selected");
																																				Thread.sleep(1000);
			ClickElement(locatorParser(jsonParser(jsonPath, "navbar", "agents")), "agents Selected");
			}
			SwitchtoFrame("platform-iframe");
			ImplicitWaitSwitch(5000);
			isDisplayed(locatorParser(jsonParser(jsonPath, "agent", "checkAgent")), "checkAgent");
																																																			Thread.sleep(2000);
			ClickElement(locatorParser(jsonParser(jsonPath, "agent", "addAgentBtn")), "addAgentBtn Selected");
																																																			Thread.sleep(2000);
			EnterText(locatorParser(jsonParser(jsonPath, "agent", "agentName")),jsonParser(jsonData, "agent", "agentName"));
			EnterText(locatorParser(jsonParser(jsonPath, "agent", "agentEmail")),jsonParser(jsonData, "agent", "agentEmail"));
			EnterText(locatorParser(jsonParser(jsonPath, "agent", "agentMobile")),jsonParser(jsonData, "agent", "agentMobile"));
			ClickElement(locatorParser(jsonParser(jsonPath, "agent", "agentRole")), "agentRole Selected");
			liSelect(locatorParser(jsonParser(jsonPath, "agent", "agentRoleLi")),jsonParser(jsonData, "agent", "agentRole"));
																																																																						Thread.sleep(1000);
			ClickElement(locatorParser(jsonParser(jsonPath, "agent", "SaveBtn")), "SaveBtn Selected");
			
	}
}