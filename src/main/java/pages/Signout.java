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

public class Signout extends ReusableLibrary {
	   protected WebDriver driver;
	    protected String firstName,password,signin,image,name,passwords,popup,termsandConditions;
	    String jsonPath,jsonData;
	    
	    public Signout(WebDriver driver)
	    {
	    	super(driver);
	    	this.driver = driver;

	    	jsonPath = getObjectfile(this.getClass().getSimpleName());
	    	jsonData = getDatatfile(this.getClass().getSimpleName());
	    }
	    public void FreemiumSignout() throws InterruptedException 
	    {			
			try {
//			SwitchtoFrame("platform-iframe");
			ClickElement(locatorParser(jsonParser(jsonPath, "Signout", "signoutDropdown")), "signout Dropdown");                                       Thread.sleep(2000);
			ClickElement(locatorParser(jsonParser(jsonPath, "Signout", "signout")), "signout");																	Thread.sleep(2000);
			if(isDisplayed(locatorParser(jsonParser(jsonPath, "Signout", "signoutMsg")), "signoutMsg")==true)
			{
					System.out.println("Signed out!!!");
			}
		
			}
			catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	    }
}
