	package trash;

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

	import browserFactory.ReusableLibrary;

	public class Navigation extends ReusableLibrary {

		protected WebDriver driver;
		String jsonPath,jsonData;
		public Navigation(WebDriver driver) {
			
			super(driver);
	    	this.driver = driver;
	    	jsonPath = getObjectfile(this.getClass().getSimpleName());
	    	jsonData = getDatatfile(this.getClass().getSimpleName());
			
		}
		public void companySettings() throws FileNotFoundException, IOException, ParseException
		{
			if(isDisplayed(locatorParser(jsonParser(jsonPath,"navigation","userinfo")),"UserInfo"))
	        {
				SendHover(locatorParser(jsonParser(jsonPath,"navigation","userinfo")),"UserInfo");
	        }
		 ImplicitWaitSwitch(30);
		 
		 
		 
		 if(isDisplayed(locatorParser(jsonParser(jsonPath,"navigation","billing")),"billing"))
	        {
			 ClickElement(locatorParser(jsonParser(jsonPath,"navigation","billing")),"billing");
	        }
		 ImplicitWaitSwitch(30);
		 
		 
		 
		 if(isDisplayed(locatorParser(jsonParser(jsonPath,"navigation","companysetting")),"companysetting"))
	        {
			 ClickJSElement(locatorParser(jsonParser(jsonPath,"navigation","companysetting")),"companysetting");
	        }
		 ImplicitWaitSwitch(30);
		 
		 
		 if(isDisplayed(locatorParser(jsonParser(jsonPath,"navigation","searchcompany")),"searchcompany"))
	        {
			 
			 EnterTextByEntert(locatorParser(jsonParser(jsonPath,"navigation","searchcompany")),jsonParser(jsonData,"navigationData","searchcompany"));
	        }
		 ImplicitWaitSwitch(30);
		 
		 

		 if(isDisplayed(locatorParser(jsonParser(jsonPath,"navigation","viewdetails")),"viewdetails"))
	        {
			 ClickElement(locatorParser(jsonParser(jsonPath,"navigation","viewdetails")),"viewdetails");
	        }
		 ImplicitWaitSwitch(30);
		 
		 
		 if(isDisplayed(locatorParser(jsonParser(jsonPath,"navigation","lbprice")),"lbprice"))
	        {
			 sendKeysByAction(locatorParser(jsonParser(jsonData,"navigationData","lbprice")),"lbprice");
	        }
		 ImplicitWaitSwitch(30);
		 
		 
		 
		}



}
