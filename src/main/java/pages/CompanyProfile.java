package pages;

import org.openqa.selenium.By;
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

public class CompanyProfile extends ReusableLibrary {
	   protected WebDriver driver;
	    protected String firstName,password,signin,image,name,passwords,popup,termsandConditions;
	    String jsonPath,jsonData;
	    int flag=0;
	    
	    public CompanyProfile(WebDriver driver)
	    {
	    	super(driver);
	    	this.driver = driver;

	    	jsonPath = getObjectfile(this.getClass().getSimpleName());
	    	jsonData = getDatatfile(this.getClass().getSimpleName());
	    }
	    public void companyProfileTab() throws InterruptedException
	    {
	    	try {
//	    		SwitchtoFrame("platform-iframe");
				ClickElement(locatorParser(jsonParser(jsonPath, "CompanyProfile", "companyTab")), "companyTab");					Thread.sleep(1000);
	    	} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}												
	    }
	  
	    public void editCompanyProfile()
	    {					
	    	try {
			//companyProfileTab();    	
	    	EnterTextTabClear(locatorParser(jsonParser(jsonPath, "CompanyProfile", "CompanyName")),jsonParser(jsonData, "CompanyProfile", "CompanyName"));						Thread.sleep(2000);
	    	validateName();
	    	EnterTextTabClear(locatorParser(jsonParser(jsonPath, "CompanyProfile", "CompanyMail")), jsonParser(jsonData, "CompanyProfile", "CompanyMail"));					Thread.sleep(2000);
	    	validateMail();
	    	EnterTextTabClear(locatorParser(jsonParser(jsonPath, "CompanyProfile", "CompanyPhone")), jsonParser(jsonData, "CompanyProfile", "CompanyPhone"));					Thread.sleep(2000);
	    	validatePhone();
	    	liSelect(locatorParser(jsonParser(jsonPath, "CompanyProfile", "Timezone")),jsonParser(jsonData, "CompanyProfile", "Timezone") );								Thread.sleep(1000);
	    	
	    	ClickElement(locatorParser(jsonParser(jsonPath, "CompanyProfile", "saveBtn")), "saveBtn");												Thread.sleep(4000);			
	    
	    	if(flag==1)
	    	{
	    		isDisplayed(locatorParser(jsonParser(jsonPath, "CompanyProfile", "wrongSnackbar")), "wrongSnackbar");
	    	}
	    	else
	    	{
	    		isDisplayed(locatorParser(jsonParser(jsonPath, "CompanyProfile", "correctSnackbar")), "correctSnackbar");
	    	}
	    	
	    	} catch (InterruptedException | IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    }
	    public void validateName()
	    {
	    	try {
				if(getText(locatorParser(jsonParser(jsonPath, "CompanyProfile", "CompanyName")))=="")
				{
					isPresent(locatorParser(jsonParser(jsonPath, "CompanyProfile", "nameEmpty")), "Empty Name");
					flag=1;
				}
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    public void validateMail()
	    {
	    	
	    	try {
	    		String mail=getText(locatorParser(jsonParser(jsonPath, "CompanyProfile", "CompanyMail")));
		    	CharSequence value="@.";
				if(mail=="")
				{
					isPresent(locatorParser(jsonParser(jsonPath, "CompanyProfile", "mailEmpty")), "mail Empty");
					flag=1;
				}
				
				if(mail!=""&&!(mail.contains(value)))
				{
					isPresent(locatorParser(jsonParser(jsonPath, "CompanyProfile", "invalidMail")), "invalidMail");
					flag=1;
				}
					
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
	    }
	    public void validatePhone()
	    {
	    	
	    	try {
	    		String phone=getText(locatorParser(jsonParser(jsonPath, "CompanyProfile", "CompanyPhone")));
		    	//CharSequence value="@.";
				if(phone=="")
				{
					isPresent(locatorParser(jsonParser(jsonPath, "CompanyProfile", "phoneEmpty")), "Phone Empty");
					flag=1;
				}
				
				if(phone!=""&&!(phone.length()!=10))
				{
					isPresent(locatorParser(jsonParser(jsonPath, "CompanyProfile", "invalidPhone")), "invalidPhone");
					flag=1;
				}
					
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
	    }
}
