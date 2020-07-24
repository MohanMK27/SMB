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

public class FreemiumSignup extends ReusableLibrary {
	   protected WebDriver driver;
	    protected String firstName,password,signup,image,name,passwords,popup,termsandConditions;
	    String jsonPath,jsonData;
	    
	    public FreemiumSignup(WebDriver driver)
	    {
	    	super(driver);
	    	this.driver = driver;

	    	jsonPath = getObjectfile(this.getClass().getSimpleName());
	    	jsonData = getDatatfile(this.getClass().getSimpleName());
	    }
	    public void Signup(String jsonObj) throws IOException, ParseException, InterruptedException
	    {			
			getApplication(readPropertyFile("URL"));
			SwitchtoFrame("platform-iframe");
			EnterText(locatorParser(jsonParser(jsonPath, "signup", "email")), jsonParser(jsonData, jsonObj, "email")); Thread.sleep(1500);
			ClickElement(locatorParser(jsonParser(jsonPath, "signup", "startForFree")), "startForFree");
			ImplicitWaitSwitch(3000);
			EnterText(locatorParser(jsonParser(jsonPath, "signup", "companyname")),jsonParser(jsonData, jsonObj, "companyname")); Thread.sleep(1500);
			//EnterText(locatorParser(jsonParser(jsonPath, "signup", "fullname")), jsonParser(jsonData, jsonObj, "fullname")); Thread.sleep(1500);
			EnterText(locatorParser(jsonParser(jsonPath, "signup", "phone")), jsonParser(jsonData, jsonObj, "phone")); Thread.sleep(1500);
			
			EnterText(locatorParser(jsonParser(jsonPath, "signup", "password")), jsonParser(jsonData, jsonObj, "password")); Thread.sleep(1500);
			//EnterText(locatorParser(jsonParser(jsonPath, "signup", "cnfpassword")), jsonParser(jsonData, jsonObj, "cnfpassword")); Thread.sleep(1500);
			if(!(isPresent(locatorParser(jsonParser(jsonPath, "signup", "emptyMail")),"emptyMail")||isPresent(locatorParser(jsonParser(jsonPath, "signup", "invalidMail")),"invalidMail")||isPresent(locatorParser(jsonParser(jsonPath, "signup", "emptyCompanyName")),"emptyCompanyName")||isPresent(locatorParser(jsonParser(jsonPath, "signup", "emptyPhone")),"emptyPhone")||isPresent(locatorParser(jsonParser(jsonPath, "signup", "invalidPhone")),"invalidPhone")||isPresent(locatorParser(jsonParser(jsonPath, "signup", "emptyPassword")),"emptyPassword")||isPresent(locatorParser(jsonParser(jsonPath, "signup", "invalidPassword")),"invalidPassword")))
			ClickElement(locatorParser(jsonParser(jsonPath, "signup", "launchNowBtn")), "launchNowBtn");
			else
				System.out.println("validation issue!!!");
				   
	    }
}
