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

public class FreemiumSignin extends ReusableLibrary {
	   protected WebDriver driver;
	    protected String firstName,password,signin,image,name,passwords,popup,termsandConditions;
	    String jsonPath,jsonData;
	    
	    public FreemiumSignin(WebDriver driver)
	    {
	    	super(driver);
	    	this.driver = driver;

	    	jsonPath = getObjectfile(this.getClass().getSimpleName());
	    	jsonData = getDatatfile(this.getClass().getSimpleName());
	    }
	    public void Signin(String jsonObj) throws InterruptedException 
	    {			
			
			
			ImplicitWaitSwitch(3000);
			try {
				getApplication(readPropertyFile("URL1"));
				SwitchtoFrame("platform-iframe");
				EnterText(locatorParser(jsonParser(jsonPath, "newSignIn", "emailInput")),jsonParser(jsonData, jsonObj, "email"));                             		Thread.sleep(2000);
				EnterTextTabClear(locatorParser(jsonParser(jsonPath, "newSignIn", "passwordInput")), jsonParser(jsonData, jsonObj, "password"));			Thread.sleep(2000);
				
			if(!(isPresent(locatorParser(jsonParser(jsonPath, "newSignIn", "emptyMail")),"mail empty")||isPresent(locatorParser(jsonParser(jsonPath, "newSignIn", "emptyPassword")),"empty password")))
				{	
				ClickElement(locatorParser(jsonParser(jsonPath, "newSignIn", "signInBtn")), "signin");												Thread.sleep(2000);
				
			if(isPresent(locatorParser(jsonParser(jsonPath, "newSignIn", "invalidSigninSnackbarText")),"invalid credentials"))
				System.out.println("Invalid Credentials");
				
			else
				{
													
					SwitchtoFrame("platform-iframe");
					if(isPresent(locatorParser(jsonParser(jsonPath, "newSignIn", "signin_success")),"signin_success"))
						System.out.println("Signed in!!!");	
				
				}
				
				}		
				Thread.sleep(4000);
				
				
				
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				DriverScript.bResult=false;
			}			   
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	/*
	 * public void Signin(String jsonObj) throws InterruptedException {
	 * 
	 * 
	 * ImplicitWaitSwitch(3000); try { getApplication(readPropertyFile("URL1"));
	 * EnterText(locatorParser(jsonParser(jsonPath, "signin",
	 * "email_textbox")),jsonParser(jsonData, jsonObj, "email"));
	 * Thread.sleep(2000); EnterText(locatorParser(jsonParser(jsonPath, "signin",
	 * "password_textbox")), jsonParser(jsonData, jsonObj, "password"));
	 * Thread.sleep(2000); ClickElement(locatorParser(jsonParser(jsonPath, "signin",
	 * "signin_button")), "signin"); Thread.sleep(2000);
	 * 
	 * if(isPresent(locatorParser(jsonParser(jsonPath, "signin",
	 * "invalidCredentials")),"invalid credentials"))
	 * System.out.println("Invalid Credentials");
	 * 
	 * else if (isPresent(locatorParser(jsonParser(jsonPath, "signin",
	 * "invalid")),"invalid")) System.out.println("Invalid email / password"); else
	 * {
	 * 
	 * SwitchtoFrame("platform-iframe");
	 * if(isPresent(locatorParser(jsonParser(jsonPath, "signin",
	 * "signin_success")),"signin_success")) System.out.println("Signed in!!!");
	 * 
	 * }
	 * 
	 * 
	 * Thread.sleep(4000);
	 * 
	 * 
	 * 
	 * } catch (IOException | ParseException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */
	    
	    
	    
}
