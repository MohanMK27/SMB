package browserFactory;


import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;
//import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.base.Function;

import browserFactory.*;
import executionEngine.DriverScript;
import config.ActionKeywords;



public  class ReusableLibrary extends DriverManager{
	//static ExtentTest test;
	//String SCpath=System.getProperty(("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png");
	    protected WebDriver driver;
	    String value;
	  //  static ExtentTest test;
	    public ReusableLibrary(WebDriver driver)
	    {
	    	this.driver = driver;
    	
	    }
	
	public ReusableLibrary() {

		}

	public void getApplication(String appUrl) {
				
		try {
			driver.get(appUrl);
			driver.manage().window().maximize();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
	
     }
	
	public void EnterText(By strobj, String text) throws IOException
	{
		System.out.println();
		try {
			WebElement element = driver.findElement(strobj);
			element.sendKeys(text);
			System.out.printf("EnterText", text + " is entered ");
			DriverScript.test.addScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver),("Enter text:"+text));
		
		} catch (Exception e) {
			System.out.printf("EnterText", text + " is not entered");
			e.printStackTrace();
			DriverScript.test.fail(e,MediaEntityBuilder.createScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver)).build());
			
		
		}
		
	}
	
	
	public void EnterTextTabClear(By strobj, String text) throws IOException
	{
		System.out.println();
		try {
			WebElement element = driver.findElement(strobj);
			element.clear();
			element.sendKeys(text);
			element.sendKeys(Keys.TAB);
			System.out.printf("EnterText", text + " is entered ");
			DriverScript.test.addScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver),("Enter text:"+text));
		
		} catch (Exception e) {
			System.out.printf("EnterText", text + " is not entered");
			e.printStackTrace();
			DriverScript.test.fail(e,MediaEntityBuilder.createScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver)).build());
			
		
		}
		
	}
	
	public void clearText(By strobj,By strobj1) throws IOException
	{
		try {
			WebElement element = driver.findElement(strobj);
			 Actions actions = new Actions(driver);
			actions.click(element).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
			//actions.sendKeys(Keys.DELETE).perform();
			Thread.sleep(1500);
			WebElement element1 = driver.findElement(strobj1);
			element1.click();
			System.out.printf("Cleared text");
			DriverScript.test.addScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver),("Cleared text"));
		
		} catch (Exception e) {
			System.out.printf("Clear text");
			e.printStackTrace();
			DriverScript.test.fail(e,MediaEntityBuilder.createScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver)).build());
			
		
		}
	}
	
	public void EnterTextClear(By strobj, String text) throws IOException
	{
		System.out.println();
		try {
			WebElement element = driver.findElement(strobj);
			element.clear();
			element.sendKeys(text);
			System.out.printf("EnterText", text + " is entered ");
			DriverScript.test.addScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver),("Enter text:"+text));
		
		} catch (Exception e) {
			System.out.printf("EnterText", text + " is not entered");
			e.printStackTrace();
			DriverScript.test.fail(e,MediaEntityBuilder.createScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver)).build());
			
		
		}
		
	}
	
	public void EnterTextByEntert(By strobj, String text) throws IOException
	{
		System.out.println();
		try {
			
			WebElement element = driver.findElement(strobj);
			element.sendKeys(text);
			ImplicitWaitSwitch(5000);
			element.sendKeys(Keys.ENTER);
			System.out.printf("EnterText", text + " is entered ");
			DriverScript.test.addScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver),("Enter text:"+text));
		
		} catch (Exception e) {
			System.out.printf("EnterText", text + " is not entered");
			e.printStackTrace();
			DriverScript.test.fail(e,MediaEntityBuilder.createScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver)).build());
			
		}
		
	}
	public void EnterTextByDownEnter(By strobj, String text) throws IOException
	{
		System.out.println();
		try {
			
			WebElement element = driver.findElement(strobj);
			element.sendKeys(text);
			ImplicitWaitSwitch(5000);
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.ENTER);
			System.out.printf("EnterText", text + " is entered ");
			DriverScript.test.addScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver),("Enter text:"+text));
		
		} catch (Exception e) {
			System.out.printf("EnterText", text + " is not entered");
			e.printStackTrace();
			DriverScript.test.fail(e,MediaEntityBuilder.createScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver)).build());
			
		}
		
	}
	public void EnterBtn()
	{
		System.out.println();
		try {
			//WebElement element = driver.findElement(strobj);
			//element.sendKeys(text);
			//ImplicitWaitSwitch(3000);
			//element.sendKeys(Keys.ENTER);
			System.out.printf("entered ");
			
		} catch (Exception e) {
			System.out.printf(" not entered");
		
		}
		
	}
	public void ClickElement(By strobj, String strButtonName) throws IOException {

		try {
//			WebDriverWait wait = new WebDriverWait(driver,10);
//			WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(strobj));
			WebElement element = driver.findElement(strobj);
			element.click();
			DriverScript.test.addScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver),strButtonName);
			System.out.printf("Click Button", strButtonName + " clicked");
			

		} catch (Exception e) {
			e.printStackTrace();
			DriverScript.test.fail(e,MediaEntityBuilder.createScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver)).build());
			System.out.printf("Click Button", strButtonName + " not clicked");
			DriverScript.bResult=false;
		}
	}
	
	public void customSelect(String xpath,String input) throws InterruptedException, IOException
	{
		try
		{
		StringBuilder xpathAppend = new StringBuilder(100);
		String[] xpathSplit = xpath.split("zzz");
		xpathAppend.append(xpathSplit[0]).append(input).append(xpathSplit[1]);
		String locater = xpathAppend.toString();
		ClickElement(locatorParser(locater), "SelectBy Address");
		Thread.sleep(2000);
	} catch (Exception e) {
		e.printStackTrace();
		DriverScript.test.fail(e,MediaEntityBuilder.createScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver)).build());
		System.out.printf("SelectByaddress");
		DriverScript.bResult=false;
	}
	}
	
	public void ClickJSElement(By strobj, String strButtonName) {
		
		try {
			WebElement element = driver.findElement(strobj);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			System.out.printf("Click Button", strButtonName + " clicked");
			
			} catch (Exception e) {
			DriverScript.bResult = false;
			System.out.printf("Click Button", strButtonName + " not clicked. </ br> " + e);
		}
		
	}
	
	public void EnterTextWithJS(By strobj, String text) {
		try {
		System.out.println(strobj);
			WebElement element = driver.findElement(strobj);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].value='" + text + "'", element);
			System.out.printf("EnterText", text + " is entered in " );
			
			

		} catch (Exception e) {
			System.out.println(e);
			System.out.printf("EnterText", text + " is not entered in " );
			
		}
	}
	
	public void EnterTextWithJSEnter(By strobj, String text) {
		try {
		System.out.println(strobj);
			WebElement element = driver.findElement(strobj);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].value='" + text + "'", element);
			Thread.sleep(1000);
			element.sendKeys(Keys.ENTER);
			System.out.printf("EnterText", text + " is entered in " );
			
			

		} catch (Exception e) {
			System.out.println(e);
			System.out.printf("EnterText", text + " is not entered in " );
			
		}
	}
	
		public boolean isDisplayed(By obj, String objdesc) throws IOException {
		Boolean displayed = false;
	
		try {
			ImplicitWaitSwitch(30);
			//System.out.println("check point");
			WebDriverWait wait = new WebDriverWait(driver,10);
			WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(obj));
			//wait.until(ExpectedConditions.visibilityOf(element));
			displayed = element.isDisplayed();
			System.out.println("check point"+displayed);
			if (displayed) {
				System.out.println("Element Verification"+ objdesc + " is Displayed");
				
				ImplicitWaitSwitch(30);
			} else {
				System.out.println("Element Verification"+ objdesc + " is not Displayed");
				DriverScript.bResult = false;
				
				ImplicitWaitSwitch(30);
			}
			return displayed;
		} catch (Exception e) {
			System.out.printf("Element Verification"+ objdesc + " is not Displayed");
			ImplicitWaitSwitch(30);
			DriverScript.test.fail(e,MediaEntityBuilder.createScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver)).build());
			return displayed;
		}
	}
		
	public void SwitchtoFrame(String frameId)
	{
		driver.switchTo().frame(frameId);
	}
	
	public void SwitchtoDefaultFrame()
	{
		driver.switchTo().defaultContent();
		}
	
	public void SwitchtoActive()
	{
		driver.switchTo().activeElement();
	}
	List<WebElement> allOptions;
	public List<WebElement> returnWebElements(By ObjName)
	{
		allOptions = driver.findElements(ObjName);
		return allOptions;
	}
	
	public String getText(By Objname) throws IOException
	{
		System.out.println(driver.findElement(Objname).getText());
		DriverScript.test.addScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver),"get text");
		return driver.findElement(Objname).getText();
	}
	public void ImplicitWaitSwitch(int time) {
		try {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			
			
		}
	}
	public void SelectText(By objName, String strValue) {
		
		try {
			
			//driver.findElement(objName).click();
			Select select = new Select(driver.findElement(objName));
			if (strValue != null && strValue != "") {
				ImplicitWaitSwitch(30);
				select.selectByVisibleText(strValue);
				System.out.printf("Select Value", strValue + " is selected ");
				ImplicitWaitSwitch(30);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			//DriverScript.bResult = false;
		}
	}
	public void SelectAction(By objName) throws InterruptedException
	{
		WebElement select = driver.findElement(objName);
		Actions builders = new Actions(driver);
		Action seriesOfAction = builders
			.moveToElement(select)
			.click()
			.sendKeys(Keys.DOWN)
			.click()
			.build();
		
		seriesOfAction.perform() ;
		Thread.sleep(1000);
	}
	public void selectOption(String option) {
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		String script =
	            "function selectOption(s) {\r\n" +
	                    "   var sel = document.querySelector('.custom-select-options');\r\n" +
	                    "   for (var i = 0; i < sel.options.length; i++)\r\n" +
	                    "   {\r\n" +
	                    "       if (sel.options[i].text.indexOf(s) > -1)\r\n" +
	                    "       {\r\n" +
	                    "           sel.options[i].selected = true;\r\n" +
	                    "           break;\r\n" +
	                    "       }\r\n" +
	                    "   }\r\n" +
	                    "}\r\n" +
	                    "return selectOption('" + option + "');";

	 
		executor.executeScript(script);
	}
	public void getJSDropdown(By dropDown, String elementID)throws Exception{

		 JavascriptExecutor executor = (JavascriptExecutor)driver;
	     String dropdownScript = "var select = document.getElementByName('" + 
	    		 dropDown +
	             "'); for(var i = 0; i < select.options.length; i++){if(select.options[i].text == '" +
	             elementID +
	             "'){ select.options[i].selected = true; } }";

	     Thread.sleep(2000);
	     executor.executeScript(dropdownScript);
	 }
	public String readPropertyFile(String name) throws IOException
	{
		FileReader reader=new FileReader(System.getProperty("user.dir")+"/src/main/resources/framework.properties");  
        Properties p=new Properties();  
        p.load(reader);
        return p.getProperty(name);
        
	}
	public String jsonParser(String filename, String Object, String variable) throws FileNotFoundException, IOException, ParseException 
	{
		
		JSONParser jsonParserObject = new JSONParser();
		
		

        try (FileReader reader = new FileReader(filename))
        {
            Object obj = jsonParserObject.parse(reader);
            JSONArray userlist = (JSONArray) obj;
          userlist.forEach( emp -> {
				try {
					parselogin( (JSONObject) emp ,Object,variable);} 
				catch (IOException e) {
					e.printStackTrace();
				}
			} );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		return value; 
		
	}
	
	
	public void waitClick(By obj, int i) 
	{
		
		WebDriverWait wait = new WebDriverWait(driver, i);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(obj));
		element.click();
		System.out.println("Clicked!!!");
		 
	}
	public void waitClickableCheck(By obj, int i) 
	{
		
		WebDriverWait wait = new WebDriverWait(driver, i);
		WebElement element = wait.until(ExpectedConditions.	elementToBeClickable(obj));
		element.click();
		System.out.println("Clicked!!!");
		 
	}

	private String parselogin(JSONObject employee, String Object,String variable) throws IOException
    {
		 
		JSONObject employeeObject = (JSONObject) employee.get(Object);
        value= (String)employeeObject.get(variable)	;
        return value;
        
    }
	public String jsonPut(String filename, String Object, String variable,String value) throws FileNotFoundException, IOException, ParseException 
	{
		
		JSONParser jsonParserObject = new JSONParser();
		
		

        try (FileReader reader = new FileReader(filename))
        {
            JSONObject obj = (JSONObject) jsonParserObject.parse(reader);
            JSONObject obj1=(JSONObject) obj.get(Object);
            obj1.put(variable,value);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		return value; 
		
	}
	
	
public static By locatorParser(String locator) {
		
		By loc = By.id(locator.replaceAll("'","").trim());
		
		 String[] arrSplit = locator.split("By.");
		    for (int i=0; i < arrSplit.length; i++)
		    {
		    //  System.out.println(arrSplit[i]);
		    }
		    char identifier = arrSplit[1].charAt(0);
		   String message = arrSplit[1].substring(0, 1);
	
		if (message.contains("i"))
			{
				String  loc1 = locator.substring(locator.indexOf("(") + 1,
		        locator.length() -1);
				loc=By.id(loc1.replaceAll("'","").trim());
			}
				
		else if (message.contains("n"))
			{
				String  loc2  = locator.substring(locator.indexOf("(") + 1,
		        locator.length() - 1);
				loc=By.name(loc2.replaceAll("'","").trim());
			}
		
			
		else if (message.contains("x"))
		{
		  String loc3 = locator.substring(locator.indexOf("(") + 1,
		        locator.length() - 1);
		String result=  loc3.substring(1, loc3.length()-1);
		loc=By.xpath(result);
		}
		else if (message.contains("l"))
		{
			String  loc2  = locator.substring(locator.indexOf("(") + 1,
	        locator.length() - 1);
			loc=By.linkText(loc2.replaceAll("'","").trim());
		}
	
		
		return loc;
		
	}
	public Boolean fluentWait(By obj)
	{
		try
		{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
			    .pollingEvery(Duration.ofSeconds(2))
			    .ignoring(NoSuchElementException.class);

			WebElement element = wait.until(new Function<WebDriver, WebElement>() 
			{
			  public WebElement apply(WebDriver driver) {
			 WebElement ele=driver.findElement(obj);
				  return ele;
			}
			});
			System.out.println(element);
			Boolean result=element.isDisplayed();
			return result;
		}catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
		}
	}

	public String getObjectfile(String classname)
	{
		String path;
		path = System.getProperty("user.dir")+"/src/main/java/objects/"+classname+".json";
		return path;
	}
	public String getDatatfile(String classname)
	{
		String path;
		path = System.getProperty("user.dir")+"//src/main/resources/testData/"+classname+"Data"+".json";
		return path;
	}
	
	public void closedriver()
	{
		driver.close();
	}
	
	public void sendKeysByAction(By obj,String key) throws IOException
	{
		WebElement element = driver.findElement(obj);
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(element)
			.click()
			.sendKeys(element,key)
			.build();
			
		seriesOfActions.perform() ;
		
	}
	public void SendHover(By obj,String key)
	{
		WebElement element = driver.findElement(obj);
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(element)
			
			.build();
			
		seriesOfActions.perform() ;
		
	}
	public void sendKeysByActionForSearch(By obj,String key)
	{
		WebElement element = driver.findElement(obj);
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(element)
			.click()
			.sendKeys(element,key)
			.sendKeys(Keys.ENTER)
			.build();
			
		seriesOfActions.perform() ;
	}
	
	public void sendNumberByAction(By obj,String key)
	{
		WebElement zipcode = driver.findElement(obj);
		
		Actions builders4 = new Actions(driver);
		Action seriesOfAction4 = builders4
			.moveToElement(zipcode)
			.click()
			.sendKeys(zipcode,key)
			.build();
		
		seriesOfAction4.perform() ;
	}
	public void clickByAction(By obj)
	{
		WebElement next = driver.findElement(obj);
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(next)
			.click()
			.build();
		seriesOfActions.perform() ;
	}
	public void switchToAlert() {
		
		   try{
			    Alert alert = driver.switchTo().alert();
			    System.out.println(alert.getText()+" Alert is Displayed"); 
			    }
			    catch(NoAlertPresentException ex){
			    System.out.println("Alert is NOT Displayed");
			    DriverScript.bResult = false;
			    }
			    
	}
	//button is enbale or not
	public Boolean isBtnEnable(By obj,String text)
	{
		Boolean result=false;
		WebElement element=driver.findElement(obj);
		result=element.isEnabled();
		if(result)
			System.out.println("Enabled Button");
		else
			System.out.println("Disabled Button");
		return result;	
	}
	
	//Check page url and close the tab
	public Boolean checkURL(String text) throws IOException
	{
		try {
			
		
		String url = driver.getCurrentUrl();
		if(url.contentEquals(text))
			return true;
		else
		{
			DriverScript.test.fail("URL not correct",MediaEntityBuilder.createScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver)).build());
			return false;
		}
		}catch(Exception e) {
			
			e.printStackTrace();
			DriverScript.test.fail(e,MediaEntityBuilder.createScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver)).build());
			return false;
		}
		
	}
	
	
	
	//dropdown select using list
	public void liSelect(By obj,String text) throws IOException
	{
	try {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.presenceOfElementLocated(obj));
		List<WebElement> liElement=driver.findElements(obj);
		
		for (WebElement element: liElement) {
			System.out.println(element.getText());
		if (element.getText().equals(text)) {
		     element.click();
		     System.out.println("li selected");
		     break;
		   }
		}
		DriverScript.test.addScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver),("Dropdown select:"+text));
	}
	catch(Exception e) {
		System.out.println("Failed"+text);
		e.printStackTrace();
		DriverScript.test.fail(e,MediaEntityBuilder.createScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver)).build());
	}
	}
	
	
	public boolean isPresent(By obj,String value) throws IOException
	{
	 try{
         driver.findElement(obj);
//         WebDriverWait wait = new WebDriverWait(driver,10);
//			WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(obj));
         System.out.println("Element present: "+value);
			DriverScript.test.addScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver),("Is present"));
         return true;
         
     }
     catch(NoSuchElementException e){
         
         //e.printStackTrace();
//			DriverScript.test.fail(e,MediaEntityBuilder.createScreenCaptureFromPath(DriverScript.capture(DriverScript.actionKeywords.driver)).build());
			return false;	
     }
	}
	
	//To generate random number for address
	public String randNum(int input)
	{
		Random rand = new Random(); 
		  
        // Generate random integers in range 0 to 999 
        int rand_int1 = rand.nextInt(input);
        String value=Integer.toString(rand_int1);
        return value;
	}
	
	//To find Check box is selected or not
		public boolean isSelected(By obj,String objdesc)
		{
			Boolean result=false;
			try
			{
			WebDriverWait wait = new WebDriverWait(driver,10);
			WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(obj));
			result=element.isSelected();
			if (result) {
				System.out.println("Element Verification"+ objdesc + " is Selected");
				
				ImplicitWaitSwitch(30);
			} else {
				System.out.println("Element Verification"+ objdesc + " is not Selected");
			}
			return result;
			}
			catch (Exception e) {
				System.out.printf("Element Verification"+ objdesc + " is not Selected");
				ImplicitWaitSwitch(30);
				return result;
			}
			
		}
		
		//Alert is displayed or not 
		public boolean isAlertDisplyed(){
		    boolean foundAlert = false;
		    WebDriverWait wait = new WebDriverWait(driver,10);
		    try {
		        wait.until(ExpectedConditions.alertIsPresent());
		        foundAlert = true;
		    } catch (TimeoutException eTO) {
		        foundAlert = false;
		    }
		    return foundAlert;
		}

		
		 public void dragAndDrop(By obj,int value1,int value2) {         
			    WebElement slider = driver.findElement(obj);
			    Actions move = new Actions(driver);
			    Action action = (Action) move.dragAndDropBy(slider, value1, value2).build();
			    action.perform();

			}
		
		
		
		//To quit the driver
		public void quitDriver()
		{
			driver.quit();
		}
	@Override
	protected void startService() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void stopService() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createDriver() {
		// TODO Auto-generated method stub
		
	}

	
}