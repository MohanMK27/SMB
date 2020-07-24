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

	import browserFactory.ReusableLibrary;
import pages.Scheduler;
	public class schedulerMain extends ReusableLibrary {

		protected  WebDriver driver;
		String jsonPath,jsonData;
		public schedulerMain(WebDriver driver) {
			
			super(driver);
	    	this.driver = driver;
	    	jsonPath = getObjectfile(this.getClass().getSimpleName());
	    	jsonData = getDatatfile(this.getClass().getSimpleName());
			
		}
		
		//Scheduler functionality are called from main class to scheduler
		//Place method as per test case flow
		public void schedulerStart() throws Exception
		{
			Scheduler s=new Scheduler(driver);
			//s.appointment();
			//s.switchTab("pending");
			//s.claim();
			//s.switchTab("upcoming");
			//s.agentReschedule();
			s.settings();
			s.SettingChange();
			System.out.println("completed");
		}



}
