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

public class ForgotPassword extends ReusableLibrary {
	   protected WebDriver driver;
	    protected String firstName,password,signin,image,name,passwords,popup,termsandConditions;
	    String jsonPath,jsonData;
	    
	    public ForgotPassword(WebDriver driver)
	    {
	    	super(driver);
	    	this.driver = driver;

	    	jsonPath = getObjectfile(this.getClass().getSimpleName());
	    	jsonData = getDatatfile(this.getClass().getSimpleName());
	    }
	    public void resetPassword() throws InterruptedException 
	    {			
			
			
			ImplicitWaitSwitch(3000);
			try {
				getApplication(readPropertyFile("URL1"));
				SwitchtoFrame("platform-iframe");
				ClickElement(locatorParser(jsonParser(jsonPath, "forgot", "forgotPassword")), "forgotPassword");												Thread.sleep(2000);
				
				EnterText(locatorParser(jsonParser(jsonPath, "forgot", "emailInput")),jsonParser(jsonData, "forgot", "email"));                             		Thread.sleep(2000);
				ClickElement(locatorParser(jsonParser(jsonPath, "forgot", "resetBtn")), "resetBtn");												Thread.sleep(2000);
				
			if(!(isPresent(locatorParser(jsonParser(jsonPath, "forgot", "successSnackBar")),"successSnackBar")))
				{	
				DriverScript.bResult=false;
				return;
				}
																																									Thread.sleep(4000);
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				DriverScript.bResult=false;
			}			   
	    }
	    
	    public void invalidPassword() throws InterruptedException 
	    {			
			
			
			ImplicitWaitSwitch(3000);
			try {
				getApplication(readPropertyFile("URL1"));
				SwitchtoFrame("platform-iframe");
				ClickElement(locatorParser(jsonParser(jsonPath, "forgot", "forgotPassword")), "forgotPassword");												Thread.sleep(2000);
				
				EnterTextTabClear(locatorParser(jsonParser(jsonPath, "forgot", "emailInput")),jsonParser(jsonData, "forgot1", "email"));                             		Thread.sleep(2000);
				
			if(!(isPresent(locatorParser(jsonParser(jsonPath, "forgot", "invalidMail")),"invalidMail")))
				{	
				DriverScript.bResult=false;
				return;
				}
			
			EnterTextTabClear(locatorParser(jsonParser(jsonPath, "forgot", "emailInput")),jsonParser(jsonData, "forgot2", "email"));                             		Thread.sleep(2000);
			
			if(!(isPresent(locatorParser(jsonParser(jsonPath, "forgot", "invalidMail")),"invalidMail")))
				{	
				DriverScript.bResult=false;
				return;
				}
																																									Thread.sleep(4000);
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				DriverScript.bResult=false;
			}			   
	    }
	    
	    public void EmptyPassword() throws InterruptedException 
	    {			
			
			
			ImplicitWaitSwitch(3000);
			try {
				//getApplication(readPropertyFile("URL1"));
				//SwitchtoFrame("platform-iframe");
			//	ClickElement(locatorParser(jsonParser(jsonPath, "forgot", "forgotPassword")), "forgotPassword");												Thread.sleep(2000);
				driver.navigate().refresh();																											Thread.sleep(3000);
				SwitchtoFrame("platform-iframe");
				EnterTextTabClear(locatorParser(jsonParser(jsonPath, "forgot", "emailInput")),jsonParser(jsonData, "forgot3", "email"));                             		Thread.sleep(2000);
				
			if(!(isPresent(locatorParser(jsonParser(jsonPath, "forgot", "emptyMail")),"emptyMail")))
				{	
				DriverScript.bResult=false;
				return;
				}
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				DriverScript.bResult=false;
			}	
			   
	    }
	    
}
