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

public class iqualCollection extends ReusableLibrary {
	   protected WebDriver driver;
	    protected String firstName,password,signin,image,name,passwords,popup,termsandConditions;
	    String jsonPath,jsonData;
	    
	    public iqualCollection(WebDriver driver)
	    {
	    	super(driver);
	    	this.driver = driver;

	    	jsonPath = getObjectfile(this.getClass().getSimpleName());
	    	jsonData = getDatatfile(this.getClass().getSimpleName());
	    }
	    public void iqualFlow() throws InterruptedException 
	    {			
	    	//SwitchtoFrame("platform-iframe");
			
			ImplicitWaitSwitch(3000);
			try {
				if(!(isPresent(locatorParser(jsonParser(jsonPath, "iqualFlow", "checkingIqualCmpltd")),"checkingIqualCmpltd")))
				{
				ClickElement(locatorParser(jsonParser(jsonPath, "iqualFlow", "startBtn")), "startBtn");														Thread.sleep(2000);
				ClickElement(locatorParser(jsonParser(jsonPath, "iqualFlow", "dogInput")), "dogInput");														Thread.sleep(2000);
				liSelect(locatorParser(jsonParser(jsonPath, "iqualFlow", "DropdowntList")),jsonParser(jsonData, "petsCount", "three"));														Thread.sleep(2000);
				
				ClickElement(locatorParser(jsonParser(jsonPath, "iqualFlow", "dogBreedSize")), "dogBreedSize");														Thread.sleep(2000);
				liSelect(locatorParser(jsonParser(jsonPath, "iqualFlow", "DropdowntList")),jsonParser(jsonData, "breedSize", "m"));														Thread.sleep(2000);
				
				ClickElement(locatorParser(jsonParser(jsonPath, "iqualFlow", "catInput")), "catInput");														Thread.sleep(2000);
				liSelect(locatorParser(jsonParser(jsonPath, "iqualFlow", "DropdowntList")),jsonParser(jsonData, "petsCount", "one"));														Thread.sleep(2000);
	
				ClickElement(locatorParser(jsonParser(jsonPath, "iqualFlow", "nextBtn")), "nextBtn");														Thread.sleep(2000);
				
				ClickElement(locatorParser(jsonParser(jsonPath, "iqualFlow", "monthlyRent")), "monthlyRent");														Thread.sleep(2000);
				liSelect(locatorParser(jsonParser(jsonPath, "iqualFlow", "DropdowntList")),jsonParser(jsonData, "monthlyRent", "2.0X"));														Thread.sleep(2000);
	
				ClickElement(locatorParser(jsonParser(jsonPath, "iqualFlow", "nextBtn")), "nextBtn");														Thread.sleep(2000);
				
				ClickElement(locatorParser(jsonParser(jsonPath, "iqualFlow", "bankruptcy")), "bankruptcy");														Thread.sleep(2000);
				ClickElement(locatorParser(jsonParser(jsonPath, "iqualFlow", "landlord")), "landlord");														Thread.sleep(2000);
				ClickElement(locatorParser(jsonParser(jsonPath, "iqualFlow", "evictions")), "evictions");														Thread.sleep(2000);
				ClickElement(locatorParser(jsonParser(jsonPath, "iqualFlow", "bankruptcy")), "bankruptcy");														Thread.sleep(2000);
				ClickElement(locatorParser(jsonParser(jsonPath, "iqualFlow", "evictions")), "evictions");														Thread.sleep(2000);
				
				ClickElement(locatorParser(jsonParser(jsonPath, "iqualFlow", "nextBtn")), "nextBtn");														Thread.sleep(2000);
				
				EnterTextClear(locatorParser(jsonParser(jsonPath, "iqualFlow", "conditionalCreditScore")), jsonParser(jsonData,"creditScore", "invalidConditionally"));												 Thread.sleep(1500);
				EnterTextClear(locatorParser(jsonParser(jsonPath, "iqualFlow", "typicalyCreditScore")), jsonParser(jsonData,"creditScore", "invalidTypically"));												 Thread.sleep(1500);
				
				EnterTextClear(locatorParser(jsonParser(jsonPath, "iqualFlow", "conditionalCreditScore")), jsonParser(jsonData,"creditScore", "conditionally"));												 Thread.sleep(1500);
				EnterTextClear(locatorParser(jsonParser(jsonPath, "iqualFlow", "typicalyCreditScore")), jsonParser(jsonData,"creditScore", "typically"));												 Thread.sleep(1500);
				
				
			//	dragAndDrop(locatorParser(jsonParser(jsonPath, "iqualFlow", "conditionalSlider")), 120,0);												 Thread.sleep(1500);
				dragAndDrop(locatorParser(jsonParser(jsonPath, "iqualFlow", "conditionalSlider")), 90,0);												 Thread.sleep(1500);
				ClickElement(locatorParser(jsonParser(jsonPath, "iqualFlow", "doneBtn")), "doneBtn");														Thread.sleep(2000);	    
				
				if(!(isPresent(locatorParser(jsonParser(jsonPath, "iqualFlow", "creditscoreSnackbar")),"creditscoreSnackbar")))
				{	
					DriverScript.bResult=false;
				return;
				}
			}	
				
				ClickElement(locatorParser(jsonParser(jsonPath, "iqualFlow", "gotIt")), "gotIt button");														Thread.sleep(2000);
					
				
				ClickElement(locatorParser(jsonParser(jsonPath, "iqualFlow", "welcomePage")), "welcomePage");														Thread.sleep(2000);
				
	
				
				
				
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				DriverScript.bResult=false;
			}			   
	    }
	  	    
}
