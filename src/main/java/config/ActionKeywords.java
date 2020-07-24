package config;

import java.io.FileNotFoundException;
import pages.FreemiumSignin;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import executionEngine.DriverScript;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import browserFactory.DriverManager;
import browserFactory.DriverManagerFactory;
import browserFactory.DriverType;
import browserFactory.ReusableLibrary;
import pages.CompanyProfile;
import pages.Freemium;
import pages.Properties;
import pages.schedulerMain;
import pages.Scheduler;
import pages.Signout;
import pages.agents;
import pages.featureFake;
import pages.FreemiumSignup;
import pages.ForgotPassword;
import pages.iqualCollection;


public class ActionKeywords extends ReusableLibrary{
	DriverManager driverManager;
    public WebDriver driver;
    static ExtentReports report;
    static ExtentTest test;
    static ExtentTest logger;
	public ActionKeywords() throws IOException {
		String data = "value";
		beforeTest(data);
		beforeMethod(data) ;
	}
	
    public void beforeTest(String Data) throws IOException {
    	String BrowserName =readPropertyFile("BROWSER");
    	if(BrowserName.equalsIgnoreCase("Chrome"))
    	{
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    	}
    	else if(BrowserName.equalsIgnoreCase("Firefox"))
    	{
        driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
    	}
    }

   
    public void beforeMethod(String Data) {
        driver = driverManager.getDriver();
        
    }
    
    public void afterMethod() {
        driverManager.quitDriver();
    }
   


	 public void scheduler(String Data) throws Exception
	 {
		 	schedulerMain page = new schedulerMain(driver);
		 	page.schedulerStart();
	        //driver.quit();
	 }
	 
    public void marketStatusCheck(String data) throws FileNotFoundException, IOException, ParseException, InterruptedException {
    	Properties page = new Properties(driver);
    	page.selectProperty();
    }
     
    
    public void appointment(String data) throws FileNotFoundException, IOException, ParseException
    {
    	Scheduler page=new Scheduler(driver);
    	page.appointment();
    }
    
    public void availability(String data) throws FileNotFoundException, IOException, ParseException
    {
    	Scheduler page=new Scheduler(driver);
    	page.availability();
    }
    
    public void settings(String data) throws FileNotFoundException, IOException, ParseException, InterruptedException
    {
    	Scheduler page=new Scheduler(driver);
    	page.settings();
    }
    
    public void settingChange(String data) throws FileNotFoundException, IOException, ParseException, InterruptedException
    {
    	Scheduler page=new Scheduler(driver);
    	page.SettingChange();
    }
    
    public void renterlogin(String data) throws FileNotFoundException, IOException, ParseException, InterruptedException
    {
    	Scheduler page=new Scheduler(driver);
    	page.renterlogin();
    }
    
    public void upcomingApmnt(String data) throws FileNotFoundException, IOException, ParseException, InterruptedException
    {
    	Scheduler page=new Scheduler(driver);
    	page.switchTab("upcoming");
    }
    public void pendingApmnt(String data) throws FileNotFoundException, IOException, ParseException, InterruptedException
    {
    	Scheduler page=new Scheduler(driver);
    	page.switchTab("pending");
    }
    public void historyApmnt(String data) throws FileNotFoundException, IOException, ParseException, InterruptedException
    {
    	Scheduler page=new Scheduler(driver);
    	page.switchTab("history");
    }
    
    public void renterSchedule(String data) throws FileNotFoundException, IOException, ParseException, InterruptedException
    {
    	Scheduler page=new Scheduler(driver);
    	page.renterSchedule();
    }
    
   
    public void quitedriver(String data)
    {
    	driver.quit();
  
    }
    public void addProperties(String data) throws FileNotFoundException, IOException, ParseException, InterruptedException
    {
    	Freemium page=new Freemium(driver);
    	page.addProperties();
    }
    
    public void addAgents(String data) throws FileNotFoundException, IOException, ParseException, InterruptedException
    {
    	Freemium page=new Freemium(driver);
    	page.addAgents();
    }
    
    
    
    
    
    
    
    //Freemium smoke test automation function call
    
    
    //Sign in without password
    public void InvalidSignin(String data) throws FileNotFoundException, IOException, ParseException, InterruptedException
    {
    	FreemiumSignin page=new FreemiumSignin(driver);
    	page.Signin("signin1");
    }
    
    //Sign in with wrong credentials
    public void WrongSignin(String data) throws FileNotFoundException, IOException, ParseException, InterruptedException
    {
    	FreemiumSignin page=new FreemiumSignin(driver);
    	page.Signin("signin2");
    }
    
    //Sign in as freemium user 
    public void signin(String data) throws FileNotFoundException, IOException, ParseException, InterruptedException
    {
    	FreemiumSignin page=new FreemiumSignin(driver);
    	System.out.println(data);
    	
    	page.Signin("signin3");
    	
    }
    
    //Freemium Signup page ---------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------------------------------
    
    public void signup(String data) throws FileNotFoundException, IOException, ParseException, InterruptedException
    {
    	FreemiumSignup page=new FreemiumSignup(driver);
    	System.out.println(data);
    	
    	page.Signup("signup");
    	
    }
    
    
    public void FreemiumSignup(String data) throws FileNotFoundException, IOException, ParseException, InterruptedException
    {
    	Freemium page=new Freemium(driver);
    	page.signup();
    }
    
    //------------------------------------------------------------------------------------------------------------------------------
    //Properties page action keywords between Excel sheet and pages
    
    //Clicking On-market properties in side bar
    public void clickAddPropertyOn(String data) throws Exception
    {
    	Properties page=new Properties(driver);
    	page.clickAddProperty("onMarket_button");
    }
    
    //Clicking off market properties  in side bar
    public void clickAddPropertyOff(String data) throws Exception
    {
    	Properties page=new Properties(driver);
    	page.clickAddProperty("offMarket_button");
    }
    
    //adding property to off-market from on-market
    public void offMarketAddProperty(String data) throws Exception
    {
    	Properties page=new Properties(driver);
    	page.offMarketAddProperty();
    }
    
    //Adding property information
    public void addPropertyForm(String data) throws Exception
    {
    	Properties page=new Properties(driver);
    	page.addPropertyForm();
    } 
    
  //Clicking save button in add property
    public void addPropertySaveBtn(String data) throws Exception
    {
    	Properties page=new Properties(driver);
    	page.click_save();
    } 
    
  //Clicking save button in add property
    public void onMarketPage(String data) throws Exception
    {
    	Properties page=new Properties(driver);
    	page.onMarketPage();
    } 
    
  //Clicking save button in add property
    public void offMarketPage(String data) throws Exception
    {
    	Properties page=new Properties(driver);
    	page.offMarketPage();
    } 
    //Selecting the property on the listing
    public void selectProperty(String data) throws Exception
    {
    	Properties page=new Properties(driver);
    	page.selectProperty();
    }
    
    public void editProperty(String data) throws Exception
    {
    	Properties page=new Properties(driver);
    	page.editProperty();
    }
    //
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Company profile page function call
    
    //companyProfileTab
    public void companyProfileTab(String data) throws Exception
    {
    	CompanyProfile page=new CompanyProfile(driver);
    	page.companyProfileTab();
    }
    
    //editCompanyProfile
    public void editCompanyProfile(String data) throws Exception
    {
    	CompanyProfile page=new CompanyProfile(driver);
	    	page.editCompanyProfile();
    }
    //-------------------------------------------------------------------------------------------------------------------------
    
    
    
    
    //--------------------------------------------------------------------------------------------------------------------------
    //Agent page related function below
    //addAgents
    public void addAgent(String data) throws InterruptedException
    {
    	agents page=new agents(driver);
    	page.addAgents();
    }
    
    //editAgents
    public void editAgents(String data) throws InterruptedException
    {
    	agents page=new agents(driver);
    	page.editAgents();
    }
    
    //deleteAgents
    public void deleteAgents(String data) throws InterruptedException
    {
    	agents page=new agents(driver);
    	page.deleteAgents();
    }
    
    
    public void agentsTab(String data) throws Exception
    {
    	agents page=new agents(driver);
    	page.agentTab();
    }
    
    //filterAgent
    public void filterAgent(String data) throws Exception
    {
    	agents page=new agents(driver);
    	page.filterAgent();
    }
    
    //searchAgentByAgent
    public void searchAgentByName(String data) throws Exception
    {
    	agents page=new agents(driver);
    	page.searchAgentByName();
    }
    
    //searchAgentByMail
    public void searchAgentByMail(String data) throws Exception
    {
    	agents page=new agents(driver);
    	page.searchAgentByMail();
    }
    //----------------------------------------------------------------------------------------------------------------------------------
    
    //----------------------------------------------------------------------------------------------------------------
    //Feature fake pages
    
    public void propertyGroup(String data) throws Exception
    {
    	featureFake page=new featureFake(driver);
    	page.propertyGroup();
    }
    
    
    public void device(String data) throws Exception
    {
    	featureFake page=new featureFake(driver);
    	page.device();
    }
    
    public void selfShowingSettings(String data) throws Exception
    {
    	featureFake page=new featureFake(driver);
    	page.selfShowingSettings();
    }
    
    public void leads(String data) throws Exception
    {
    	featureFake page=new featureFake(driver);
    	page.leads();
    }
    
    public void applicants(String data) throws Exception
    {
    	featureFake page=new featureFake(driver);
    	page.applicants();
    }
    
    
    public void vendors(String data) throws Exception
    {
    	featureFake page=new featureFake(driver);
    	page.vendors();
    }
    //feature fake function call from sheet to action keyword is ended
    //---------------------------------------------------------------------------------------------------------------------------
    
    
    
    //---------------------------------------------------------------------------------------------------------------------------------------
    //Forget password function call
     
    
    public void forgotPassword(String data) throws Exception
    {
    	ForgotPassword page=new ForgotPassword(driver);
    	page.resetPassword();
    }
    
    public void invalidForgot(String data) throws Exception
    {
    	ForgotPassword page=new ForgotPassword(driver);
    	page.invalidPassword();
    }
    
    public void emptyForgot(String data) throws Exception
    {
    	ForgotPassword page=new ForgotPassword(driver);
    	page.EmptyPassword();
    }
    
    
    //End of Forgot password page function
    //----------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    
    //-------------------------------------------------------------------------------------------------------------------------
    //Iqual collection flow function calls
    
    
    public void iqualFlow(String data) throws Exception
    {
    	iqualCollection page=new iqualCollection(driver);
    	page.iqualFlow();
    }
    
    //---------------------------------------------------------------------------------------------------------------------------------------
    
    
    
    
    
    
    
    
    //sign out
    public void signout(String data) throws Exception
    {
    	Signout page=new Signout(driver);
    	page.FreemiumSignout();
    }
    
   public void quitBrowser() {
//		ReusableLibrary page = new ReusableLibrary();
	   driver.quit();
		
	}
   
   

   
}
