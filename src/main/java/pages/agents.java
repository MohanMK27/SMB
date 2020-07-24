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

public class agents extends ReusableLibrary {
	   protected WebDriver driver;
	    protected String firstName,password,signin,image,name,passwords,popup,termsandConditions;
	    String jsonPath,jsonData;
	    
	    public agents(WebDriver driver)
	    {
	    	super(driver);
	    	this.driver = driver;

	    	jsonPath = getObjectfile(this.getClass().getSimpleName());
	    	jsonData = getDatatfile(this.getClass().getSimpleName());
	    }
	    
	    public void agentTab() throws InterruptedException
	    {
	    	try {
	    		//SwitchtoFrame("platform-iframe");
				ClickElement(locatorParser(jsonParser(jsonPath, "agents", "agentsTab")), "agentsTab");					Thread.sleep(3000);
	    	} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}												
	    }
	  
	    
	    
	    public void addAgents() throws InterruptedException 
	    {
	    	try {			
			ClickElement(locatorParser(jsonParser(jsonPath, "agents", "addAgent")), "addAgent");														Thread.sleep(2000);
			EnterText(locatorParser(jsonParser(jsonPath, "agents", "agentName")), jsonParser(jsonData, "agents", "agentName"));												Thread.sleep(2000);				
			EnterText(locatorParser(jsonParser(jsonPath, "agents", "agentEmail")), jsonParser(jsonData, "agents", "agentEmail"));												Thread.sleep(2000);				
			EnterText(locatorParser(jsonParser(jsonPath, "agents", "agentMobile")), jsonParser(jsonData, "agents", "agentMobile"));												Thread.sleep(2000);
			ClickElement(locatorParser(jsonParser(jsonPath, "agents", "agentRole")), "agentRole");																				Thread.sleep(2000);
			liSelect(locatorParser(jsonParser(jsonPath, "agents", "agentRoleLi")), jsonParser(jsonData, "agents", "agentRole"));												Thread.sleep(2000);
			
				ClickElement(locatorParser(jsonParser(jsonPath, "agents", "saveBtn")), "saveBtn");																				Thread.sleep(2000);
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}														
	    }
	    public void editAgents() throws InterruptedException 
	    {
	    	try {			
	    	EnterTextClear(locatorParser(jsonParser(jsonPath, "toolbar", "searchBar")), jsonParser(jsonData, "agents", "agentName"));												Thread.sleep(2000);
	    	ClickElement(locatorParser(jsonParser(jsonPath, "agents", "agentSelect")), "agentSelect");														Thread.sleep(2000);
			ClickElement(locatorParser(jsonParser(jsonPath, "agents", "editIcon")), "editIcon");														Thread.sleep(2000);
			//EnterTextClear(locatorParser(jsonParser(jsonPath, "agents", "agentName")), jsonParser(jsonData, "editAgents", "agentName"));												Thread.sleep(2000);				
			EnterTextClear(locatorParser(jsonParser(jsonPath, "agents", "agentEmail")), jsonParser(jsonData, "editAgents", "agentEmail"));												Thread.sleep(2000);				
			EnterTextClear(locatorParser(jsonParser(jsonPath, "agents", "agentMobile")), jsonParser(jsonData, "editAgents", "agentMobile"));												Thread.sleep(2000);
			ClickElement(locatorParser(jsonParser(jsonPath, "agents", "agentRole")), "agentRole");																				Thread.sleep(2000);
			liSelect(locatorParser(jsonParser(jsonPath, "agents", "agentRoleLi")), jsonParser(jsonData, "editAgents", "agentRole"));												Thread.sleep(2000);
			
			ClickElement(locatorParser(jsonParser(jsonPath, "agents", "saveBtn")), "saveBtn");																				Thread.sleep(2000);
			
	    	} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}														
	    }
	    public void deleteAgents() throws InterruptedException 
	    {
	    	try {			
	    	EnterTextClear(locatorParser(jsonParser(jsonPath, "toolbar", "searchBar")), jsonParser(jsonData, "agents", "agentName"));												Thread.sleep(2000);
	    	ClickElement(locatorParser(jsonParser(jsonPath, "agents", "agentSelect")), "agentSelect");														Thread.sleep(2000);
			ClickElement(locatorParser(jsonParser(jsonPath, "agents", "editIcon")), "editIcon");														Thread.sleep(4000);
			ClickElement(locatorParser(jsonParser(jsonPath, "agents", "deleteBtn")), "deleteBtn");																				Thread.sleep(2000);
			ClickElement(locatorParser(jsonParser(jsonPath, "agents", "confirmDeleteBtn")), "confirmDeleteBtn");																				Thread.sleep(4000);
			
	    	} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}														
	    }
	    
	    public void searchAgentByName() throws InterruptedException 
	    {
	    	try {			
	    	EnterTextClear(locatorParser(jsonParser(jsonPath, "toolbar", "searchBar")), jsonParser(jsonData, "toolbar", "agentName"));												Thread.sleep(4000);
	    	ClickElement(locatorParser(jsonParser(jsonPath, "toolbar", "clearAll")), "clearAll");														Thread.sleep(2000);
	    	} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}														
	    }
	    
	    //Search agents using mail id in the agent listing page
	    public void searchAgentByMail() throws InterruptedException 
	    {
	    	try {			
	    	EnterTextClear(locatorParser(jsonParser(jsonPath, "toolbar", "searchBar")), jsonParser(jsonData, "toolbar", "agentMail"));												Thread.sleep(4000);
	    	ClickElement(locatorParser(jsonParser(jsonPath, "toolbar", "clearAll")), "clearAll");														Thread.sleep(2000);
	    	} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}														
	    }
	    
	    
	    public void filterAgent() throws InterruptedException 
	    {
	    	try {	
	    	ClickElement(locatorParser(jsonParser(jsonPath, "toolbar", "agentRoleFltr")), "agentRoleFltr");												Thread.sleep(2000);	
	    	ClickElement(locatorParser(jsonParser(jsonPath, "toolbar", "leasingFilter")),"leasing agent clicked");												Thread.sleep(4000);
	    	ClickElement(locatorParser(jsonParser(jsonPath, "toolbar", "leasingFilter")),"leasing agent clicked");												Thread.sleep(4000);
	    	ClickElement(locatorParser(jsonParser(jsonPath, "toolbar", "adminFilter")), "admin filter clicked");												Thread.sleep(4000);
	    	
	    	} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}														
	    }
	    
}
