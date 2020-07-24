package pages;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import browserFactory.ExtendReportClass;
import browserFactory.ReusableLibrary;



public class Properties extends ReusableLibrary {

	protected WebDriver driver;
	String jsonPath,jsonData;
	static ExtentTest test;
	public Properties(WebDriver driver) {
		
		super(driver);
    	this.driver = driver;
    	jsonPath = getObjectfile(this.getClass().getSimpleName());
    	jsonData = getDatatfile(this.getClass().getSimpleName());
		
	}
	
	

	public void clickAddProperty(String sidebarTabName) throws Exception
	{
		try {
			SwitchtoDefaultFrame();
			SwitchtoFrame("platform-iframe");
		ClickElement(locatorParser(jsonParser(jsonPath, "add_property", sidebarTabName)), "properties_tab"); 							Thread.sleep(2000);																											
		
			ClickElement(locatorParser(jsonParser(jsonPath, "add_property", "addProperty_button")), "addProperty_button");
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			ExtendReportClass.getScreenshot(driver, "addPropertyForm");
			e.printStackTrace();
		}									
   }
	
	public void onMarketAddProperty()
	{
		try {
			ClickElement(locatorParser(jsonParser(jsonPath, "add_property", "marketingStatus")), "marketing Status");												 Thread.sleep(1000);
			addPropertyForm();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void offMarketAddProperty()
	{
		try {
			ClickElement(locatorParser(jsonParser(jsonPath, "add_property", "marketingStatus")), "marketing Status");												 Thread.sleep(1000);
			addPropertyForm();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addPropertyForm() throws Exception 
	{
		try {
		ClickElement(locatorParser(jsonParser(jsonPath, "add_property", "property_type")), "addProperty_button");												 Thread.sleep(1000);
		liSelect(locatorParser(jsonParser(jsonPath, "add_property", "property_type_list")),jsonParser(jsonData, "add_property", "property_type") );								Thread.sleep(1000);
		EnterTextByDownEnter(locatorParser(jsonParser(jsonPath, "add_property", "streetAddress")), randNum(1000));											 Thread.sleep(1000);	
		EnterText(locatorParser(jsonParser(jsonPath, "add_property", "Price")), randNum(1200));											Thread.sleep(1000);
		ClickElement(locatorParser(jsonParser(jsonPath, "add_property", "sameAsPrice")), "sameAsPrice");															 Thread.sleep(1000);
		EnterText(locatorParser(jsonParser(jsonPath, "add_property", "bed")), randNum(10));											Thread.sleep(1000);
		ClickElement(locatorParser(jsonParser(jsonPath, "add_property", "bath")), "Bath click");										Thread.sleep(1000);
		
		liSelect(locatorParser(jsonParser(jsonPath, "add_property", "property_type_list")),jsonParser(jsonData, "add_property", "bath"));														Thread.sleep(2000);
		
		EnterText(locatorParser(jsonParser(jsonPath, "add_property", "sqft")), randNum(2000));										Thread.sleep(1000);
		EnterText(locatorParser(jsonParser(jsonPath, "add_property", "description")), jsonParser(jsonData, "add_property", "description"));										Thread.sleep(1000);
	
		ClickElement(locatorParser(jsonParser(jsonPath, "add_property", "cats_click")), "cats_click");															 Thread.sleep(1000);
		liSelect(locatorParser(jsonParser(jsonPath, "add_property", "cats")),jsonParser(jsonData, "add_property", "cats") );								Thread.sleep(1000);
				
		ClickElement(locatorParser(jsonParser(jsonPath, "add_property", "dogs_click")), "dogs_click");															 Thread.sleep(1000);
		liSelect(locatorParser(jsonParser(jsonPath, "add_property", "dogs")),jsonParser(jsonData, "add_property", "dogs") );								Thread.sleep(2000);
		
		if(!(jsonParser(jsonData, "add_property", "dogs").equals("Is not allowed")))
		{
			ClickElement(locatorParser(jsonParser(jsonPath, "add_property", "breedsize_click")), "breedsize_click");															 Thread.sleep(1000);
			liSelect(locatorParser(jsonParser(jsonPath, "add_property", "breedsize")),jsonParser(jsonData, "add_property", "breedsize") );								Thread.sleep(1000);
		}
		} catch (IOException | ParseException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void click_save() throws Exception 
	{
		
		try {
			if(isBtnEnable(locatorParser(jsonParser(jsonPath, "add_property", "saveBtn")), "saveBtn"))
			{
				ClickElement(locatorParser(jsonParser(jsonPath, "add_property", "saveBtn")), "saveBtn");													Thread.sleep(3000);															
			}
		} catch (IOException | ParseException | InterruptedException e) {
			// TODO Auto-generated catch block
		//	ExtendReportClass.getScreenshot(driver, "clicksave");
			e.printStackTrace();
		}
	}
	
	
	public void onMarketPage() throws InterruptedException
	{
		try {
//			SwitchtoFrame("platform-iframe");
			ClickElement(locatorParser(jsonParser(jsonPath, "add_property", "onMarket_button")), "onMarket_button");                           Thread.sleep(1000);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}																
	}
	
	public void offMarketPage() throws InterruptedException
	{
		try {
			//	SwitchtoFrame("platform-iframe");
			ClickElement(locatorParser(jsonParser(jsonPath, "add_property", "offMarket_button")), "offMarket_button");                           Thread.sleep(1000);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}																
	}
	
	public void selectProperty()
	{
		try {
		//	customSelect(jsonParser(jsonPath, "SelectProperty", "selectByAddress"), jsonParser(jsonData, "SelectProperty", "address"));		
			Thread.sleep(1500);
			if(isPresent(locatorParser(jsonParser(jsonPath, "SelectProperty", "SelectFirstOnProperty")), "SelectFirstOnProperty"))
			{	
				ClickElement(locatorParser(jsonParser(jsonPath, "SelectProperty", "SelectFirstOnProperty")), "SelectFirstOnProperty");                           Thread.sleep(1000);
			}
			else
			{
				ClickElement(locatorParser(jsonParser(jsonPath, "SelectProperty", "selectFirstOFFProperty")), "selectFirstOFFProperty");                           Thread.sleep(1000);
			}
		} catch (IOException | ParseException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}													
	}
	public void editProperty() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		try {
		//	ClickElement(locatorParser(jsonParser(jsonPath, "SelectProperty", "moreIcon")), "moreIcon");                           Thread.sleep(1000);
			ClickElement(locatorParser(jsonParser(jsonPath, "SelectProperty", "editIcon")), "editIcon");                           Thread.sleep(3000);
		
//			liSelect(locatorParser(jsonParser(jsonPath, "add_property", "property_type_list")),jsonParser(jsonData, "edit_property", "property_type") );								Thread.sleep(1000);
//			EnterTextByEntert(locatorParser(jsonParser(jsonPath, "add_property", "streetAddress")), jsonParser(jsonData, "edit_property", "streetAddress"));											 Thread.sleep(1000);	
			EnterTextClear(locatorParser(jsonParser(jsonPath, "add_property", "Price")), jsonParser(jsonData, "edit_property", "price"));											Thread.sleep(1000);
			ClickElement(locatorParser(jsonParser(jsonPath, "add_property", "sameAsPrice")), "sameAsPrice");															 Thread.sleep(1000);
			EnterTextClear(locatorParser(jsonParser(jsonPath, "add_property", "bed")), jsonParser(jsonData, "edit_property", "bed"));											Thread.sleep(1000);
			EnterTextClear(locatorParser(jsonParser(jsonPath, "add_property", "bath")), jsonParser(jsonData, "edit_property", "bath"));										Thread.sleep(1000);
			EnterTextClear(locatorParser(jsonParser(jsonPath, "add_property", "sqft")), jsonParser(jsonData, "edit_property", "sqft"));										Thread.sleep(1000);
//			EnterTextClear(locatorParser(jsonParser(jsonPath, "add_property", "description")), jsonParser(jsonData, "edit_property", "description"));										Thread.sleep(1000);
//		
//			ClickElement(locatorParser(jsonParser(jsonPath, "add_property", "cats_click")), "cats_click");															 Thread.sleep(1000);
//			liSelect(locatorParser(jsonParser(jsonPath, "add_property", "cats")),jsonParser(jsonData, "edit_property", "cats") );								Thread.sleep(1000);
//					
//			ClickElement(locatorParser(jsonParser(jsonPath, "add_property", "dogs_click")), "dogs_click");															 Thread.sleep(1000);
//			liSelect(locatorParser(jsonParser(jsonPath, "add_property", "dogs")),jsonParser(jsonData, "edit_property", "dogs") );								Thread.sleep(2000);
//			
//			if(!(jsonParser(jsonData, "add_property", "dogs").equals("Is not allowed")))
//			{
//				ClickElement(locatorParser(jsonParser(jsonPath, "add_property", "breedsize_click")), "breedsize_click");															 Thread.sleep(1000);
//				liSelect(locatorParser(jsonParser(jsonPath, "add_property", "breedsize")),jsonParser(jsonData, "edit_property", "breedsize") );								Thread.sleep(1000);
//			}
		
		} catch (IOException | ParseException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	
	
}
