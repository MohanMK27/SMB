package trash;
/*package pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browserFactory.ReusableLibrary;

public class IQualplus extends ReusableLibrary {
	
    protected WebDriver driver;
    String jsonPath,jsonData;
	private CharSequence key;
    public IQualplus(WebDriver driver)
    {
    	super(driver);
    	this.driver = driver;

    	jsonPath = getObjectfile(this.getClass().getSimpleName());
    	jsonData = getDatatfile(this.getClass().getSimpleName());
    	
    }
    public void Register()
    {
    	try {
			getApplication(readPropertyFile("URL"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void iqualMatchCheck() throws FileNotFoundException, IOException, ParseException, InterruptedException
    {
    	Boolean c=true;
    	Register();
    	Thread.sleep(1000);
    	
    	
    	ClickJSElement(locatorParser(jsonParser(jsonPath,"plus","GetMatches")),"Button click");
    	ClickJSElement(locatorParser(jsonParser(jsonPath,"plus","GetMatched")),"Button click");
    	Thread.sleep(5000);
    	sendNumberByAction(locatorParser(jsonParser(jsonPath,"plus","Phonenumber")),jsonParser(jsonData,"IQualplus","Phonenumber"));
    	
    	ClickJSElement(locatorParser(jsonParser(jsonPath,"plus","submit")),"button click");
    	Thread.sleep(3000);
    	sendKeysByAction(locatorParser(jsonParser(jsonPath,"plus","First_name")),jsonParser(jsonData,"IQualplus","First_name"));
    	sendKeysByAction(locatorParser(jsonParser(jsonPath,"plus","Last_name")),jsonParser(jsonData,"IQualplus","Last_name"));
    	sendKeysByAction(locatorParser(jsonParser(jsonPath,"plus","Email")),jsonParser(jsonData,"IQualplus","Email"));
    	sendKeysByAction(locatorParser(jsonParser(jsonPath,"plus","Password")),jsonParser(jsonData,"IQualplus","Password"));
    	ClickElement(locatorParser(jsonParser(jsonPath,"plus","Register")),"Button click");
    	//ImplicitWaitSwitch(100);
    	Thread.sleep(5000);
    	ClickJSElement(locatorParser(jsonParser(jsonPath,"plus","amazon")),"button click");
    	Thread.sleep(5000);
	    waitClick(locatorParser(jsonParser(jsonPath,"plus","Accept")),100);
	    fieldNotNullCheck(locatorParser(jsonParser(jsonPath, "plus", "First")));
	    waitsend(locatorParser(jsonParser(jsonPath,"plus","Street")),jsonParser(jsonData,"IQualplus","Street"),100);
	   	sendKeysByAction1(locatorParser(jsonParser(jsonPath,"plus","State")),jsonParser(jsonData,"IQualplus","State"));
    	sendKeysByAction(locatorParser(jsonParser(jsonPath,"plus","City")),jsonParser(jsonData,"IQualplus","City"));
    	sendKeysByAction(locatorParser(jsonParser(jsonPath,"plus","Code")),jsonParser(jsonData,"IQualplus","Code"));
    	sendKeysByAction1(locatorParser(jsonParser(jsonPath,"plus","Mon")),jsonParser(jsonData,"IQualplus","Mon"));
    	sendKeysByAction1(locatorParser(jsonParser(jsonPath,"plus","Dat")),jsonParser(jsonData,"IQualplus","Dat"));
    	sendKeysByAction1(locatorParser(jsonParser(jsonPath,"plus","Yea")),jsonParser(jsonData,"IQualplus","Yea"));
    	sendKeysByAction(locatorParser(jsonParser(jsonPath,"plus","SSN")),jsonParser(jsonData,"IQualplus","SSN"));
    	sendKeysByAction1(locatorParser(jsonParser(jsonPath,"plus","Month")),jsonParser(jsonData,"IQualplus","Month"));
    	sendKeysByAction1(locatorParser(jsonParser(jsonPath,"plus","Date")),jsonParser(jsonData,"IQualplus","Date"));
    	sendKeysByAction1(locatorParser(jsonParser(jsonPath,"plus","Year")),jsonParser(jsonData,"IQualplus","Year"));
    	sendKeysByAction(locatorParser(jsonParser(jsonPath,"plus","Income")),jsonParser(jsonData,"IQualplus","Income"));
    	Thread.sleep(1000);
    	ClickJSElement(locatorParser(jsonParser(jsonPath,"plus","Sub")),"button click");
    	Thread.sleep(5000);
    	ClickJSElement(locatorParser(jsonParser(jsonPath,"plus","Start")),"button click");
    	waitClick(locatorParser(jsonParser(jsonPath,"plus","iCountry")),30);
    	ClickElement(locatorParser(jsonParser(jsonPath,"plus","izipcode")),"iZipcode");
    	ClickElement(locatorParser(jsonParser(jsonPath,"plus","iamount")),"iamount");
    	ClickElement(locatorParser(jsonParser(jsonPath,"plus","inext1")),"inext1");
    	waitClick(locatorParser(jsonParser(jsonPath,"plus","inext2")),30);
    	sendKeysByAction(locatorParser(jsonParser(jsonPath,"plus","Card")),jsonParser(jsonData,"IQualplus","Card"));
    	sendKeysByAction1(locatorParser(jsonParser(jsonPath,"plus","Mont")),jsonParser(jsonData,"IQualplus","Mont"));
    	sendKeysByAction1(locatorParser(jsonParser(jsonPath,"plus","Yr")),jsonParser(jsonData,"IQualplus","Yr"));
    	sendKeysByAction(locatorParser(jsonParser(jsonPath,"plus","CVV")),jsonParser(jsonData,"IQualplus","CVV"));
    	sendKeysByAction(locatorParser(jsonParser(jsonPath,"plus","zip")),jsonParser(jsonData,"IQualplus","zip"));
    	sendKeysByAction(locatorParser(jsonParser(jsonPath,"plus","Sign")),jsonParser(jsonData,"IQualplus","Sign"));   	
    	dclickByAction(locatorParser(jsonParser(jsonPath,"plus","Agree")));
    	clickByAction(locatorParser(jsonParser(jsonPath,"plus","Agree")));
    	do
    	{
    		
    		if(isDisplayed(locatorParser(jsonParser(jsonPath,"plus","seeIqual")),"seeIqual"))
    		{
    			if(isEnable(locatorParser(jsonParser(jsonPath,"plus","seeIqual")),"seeIqual"))
    			{
    			//score(locatorParser(jsonParser(jsonPath,"plus","seeIqual")));
    			ClickElement(locatorParser(jsonParser(jsonPath,"plus","seeIqual")),"seeIqual");
    			c=false;
    			}
    			else
        		{
        	 			waitUntil(locatorParser(jsonParser(jsonPath,"plus","Rerun")));
        				driver.navigate().refresh();
        		}
    		}
    		else
    		{
    			
    			waitUntil(locatorParser(jsonParser(jsonPath,"plus","Rerun")));
    				driver.navigate().refresh();
    		}
    	}while(c);
    }
        
}*/
