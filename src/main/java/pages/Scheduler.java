package pages;

import browserFactory.ReusableLibrary;
import executionEngine.DriverScript;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Scheduler extends ReusableLibrary {

	protected WebDriver driver;
	String jsonPath, jsonData;

	// JSON object and Data location
	// Constructor for scheduler
	public Scheduler(WebDriver driver) {

		super(driver);
		this.driver = driver;
		jsonPath = getObjectfile(this.getClass().getSimpleName());
		jsonData = getDatatfile(this.getClass().getSimpleName());

	}

	// To open Appointment section in scheduler(Scheduler->Appointment)
	public void appointment() throws FileNotFoundException, IOException, ParseException {
		driver.switchTo().defaultContent();
		if (isDisplayed(locatorParser(jsonParser(jsonPath, "NavBar", "appointment")), "appointment"))
			ClickElement(locatorParser(jsonParser(jsonPath, "NavBar", "appointment")), "appointment Selected");
		else {
			ClickElement(locatorParser(jsonParser(jsonPath, "NavBar", "scheduler")), "scheduler");
			ClickElement(locatorParser(jsonParser(jsonPath, "NavBar", "appointment")), "appointment Selected");
		}

		SwitchtoFrame("iFrameSizer0");
	}

	// To open Availability section in scheduler(Scheduler->Availability)
	public void availability() throws FileNotFoundException, IOException, ParseException {
		driver.switchTo().defaultContent();
		if (isDisplayed(locatorParser(jsonParser(jsonPath, "NavBar", "availability")), "availability"))
			ClickElement(locatorParser(jsonParser(jsonPath, "NavBar", "availability")), "availability Selected");
		else {
			ClickElement(locatorParser(jsonParser(jsonPath, "NavBar", "scheduler")), "scheduler");
			ClickElement(locatorParser(jsonParser(jsonPath, "NavBar", "availability")), "availability Selected");
		}

		SwitchtoFrame("iFrameSizer0");
	}

	// To open Setting section in scheduler(Scheduler->Setting)
	public void settings() throws FileNotFoundException, IOException, ParseException, InterruptedException {
		try {
			driver.switchTo().defaultContent();
			if (isDisplayed(locatorParser(jsonParser(jsonPath, "NavBar", "settings")), "settings"))
				ClickElement(locatorParser(jsonParser(jsonPath, "NavBar", "settings")), "settings Selected");
			else {
				ClickElement(locatorParser(jsonParser(jsonPath, "NavBar", "scheduler")), "scheduler");
				// if(isDisplayed(locatorParser(jsonParser(jsonPath,"NavBar","settings")),"settings"))
				Thread.sleep(2000);
				ClickElement(locatorParser(jsonParser(jsonPath, "NavBar", "settings")), "settings Selected");
			}
			SwitchtoFrame("iFrameSizer0");

			if (isDisplayed(locatorParser(jsonParser(jsonPath, "NavBar", "settingsCheck")), "settings Checking")) {
				System.out.println("Settings displayed!!!");
			}
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Claim appointment from pending tab
	// Set "Lead" and "Address" in SchedulerData.json file to claim appointment
	// lead and address is inserted into xpath by split function in java
	public void claim() throws InterruptedException {

		String claimXpath;

		StringBuilder xpathAppend = new StringBuilder(100);
		try {
			ImplicitWaitSwitch(3000);

			if (isDisplayed(locatorParser(jsonParser(jsonPath, "pending", "compatibleCheck")), "Compatible")) {
				claimXpath = jsonParser(jsonPath, "pending", "PdClaim");
				String[] xpathSplit = claimXpath.split("zzz");
				xpathAppend.append(xpathSplit[0]).append(jsonParser(jsonData, "propertyDetail", "lead"))
						.append(xpathSplit[1]).append(jsonParser(jsonData, "propertyDetail", "address"))
						.append(xpathSplit[2]).append(jsonParser(jsonData, "propertyDetail", "time"))
						.append(xpathSplit[3]).append(jsonParser(jsonData, "propertyDetail", "date"))
						.append(xpathSplit[4]);
				// System.out.println(sb.toString());
				String locater = xpathAppend.toString();
				waitClick(locatorParser(locater), 10);
				Thread.sleep(2000);
			}

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Reschedule appointment in upcoming tab
	// Selecting specific appointment reschedule
	// Fill details in 'schedulerData.json' under 'propertyDetail' object to pass as
	// parameter
	public void clickReschedule() {
		String rescheduleXpath;

		StringBuilder xpathAppend = new StringBuilder(100);
		try {
			ImplicitWaitSwitch(3000);

			if (isDisplayed(locatorParser(jsonParser(jsonPath, "appointment", "upcomingCheck")), "Upcoming tab")) {
				rescheduleXpath = jsonParser(jsonPath, "upcoming", "rescheduleClick");
				String[] xpathSplit = rescheduleXpath.split("zzz");
				xpathAppend.append(xpathSplit[0]).append(jsonParser(jsonData, "propertyDetail", "lead"))
						.append(xpathSplit[1]).append(jsonParser(jsonData, "propertyDetail", "address"))
						.append(xpathSplit[2]).append(jsonParser(jsonData, "propertyDetail", "time"))
						.append(xpathSplit[3]).append(jsonParser(jsonData, "propertyDetail", "date"))
						.append(xpathSplit[4]);
				System.out.println(xpathAppend.toString());
				String locate = xpathAppend.toString();
				waitClick(locatorParser(locate), 5);
			}

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Reschedule appointment by prompt renter in upcoming tab
	// Selecting specific appointment clickReschedule() is called
	// Fill details in 'schedulerData.json' under 'propertyDetail' object to pass as
	// parameter
	public void renterReschedule() throws FileNotFoundException, IOException, ParseException {
		appointment();
		switchTab("upcoming");
		clickReschedule();
		try {
			if (isDisplayed(locatorParser(jsonParser(jsonPath, "reschedule", "promptRenter")), "prompt renter")) {
				if (!(isSelected(locatorParser(jsonParser(jsonPath, "reschedule", "promptRenterCheck")),
						"prompt renter check"))) {
					ClickElement(locatorParser(jsonParser(jsonPath, "reschedule", "promptRenter")), "scheduler");
				}
				if (isSelected(locatorParser(jsonParser(jsonPath, "reschedule", "textmessageCheck")),
						"text message check")
						|| isSelected(locatorParser(jsonParser(jsonPath, "reschedule", "mailCheck")), "mail check")) {
					ClickElement(locatorParser(jsonParser(jsonPath, "reschedule", "rescheduleBtn")), "rescheduleBtn");
				} else {
					String msg = getText(locatorParser(jsonParser(jsonPath, "reschedule", "errorMsg")));
					System.out.println(msg);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Agent reschedule time and date need to mention in schedulerData.json
	public void agentReschedule() throws Exception {
		appointment();
		clickReschedule();
		try {
			if (isDisplayed(locatorParser(jsonParser(jsonPath, "reschedule", "manualReschedule")),
					"manualReschedule ")) {
				if (!(isSelected(locatorParser(jsonParser(jsonPath, "reschedule", "manualReschedule")),
						"manualReschedule check"))) {
					clickByAction(locatorParser(jsonParser(jsonPath, "reschedule", "manualReschedule")));
				}
				if (isDisplayed(locatorParser(jsonParser(jsonPath, "reschedule", "date")), "date Check ")) {
					clickByAction(locatorParser(jsonParser(jsonPath, "reschedule", "date")));
					if (isDisplayed(locatorParser(jsonParser(jsonPath, "reschedule", "ulList")), "ul list Check "))
						liSelect(locatorParser(jsonParser(jsonPath, "reschedule", "liList")),
								jsonParser(jsonData, "rescheduleProperty", "date"));
					System.out.println("Date selected");
					Thread.sleep(2000);
					if (isDisplayed(locatorParser(jsonParser(jsonPath, "reschedule", "time")), "time Check ")) {
						clickByAction(locatorParser(jsonParser(jsonPath, "reschedule", "time")));

						if (isDisplayed(locatorParser(jsonParser(jsonPath, "reschedule", "ulList")), "ul list Check "))
							liSelect(locatorParser(jsonParser(jsonPath, "reschedule", "liList")),
									jsonParser(jsonData, "rescheduleProperty", "time"));

					} // inner if
				} // outer if
				Thread.sleep(2000);
				if (isBtnEnable(locatorParser(jsonParser(jsonPath, "reschedule", "rescheduleBtn")), "rescheduleBtn"))
					clickByAction(locatorParser(jsonParser(jsonPath, "reschedule", "rescheduleBtn")));

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Cancel appointment in upcoming tab through agent
	public void agentCanel() throws FileNotFoundException, IOException, ParseException, InterruptedException {
		appointment();

		try {
			String claimXpath;
			StringBuilder xpathAppend = new StringBuilder(100);

			ImplicitWaitSwitch(3000);

			if (isDisplayed(locatorParser(jsonParser(jsonPath, "upcoming", "checkUpcoming")), "checkUpcoming")) {
				claimXpath = jsonParser(jsonPath, "upcoming", "cancelApmt");
				String[] xpathSplit = claimXpath.split("zzz");
				xpathAppend.append(xpathSplit[0]).append(jsonParser(jsonData, "propertyDetail", "lead"))
						.append(xpathSplit[1]).append(jsonParser(jsonData, "propertyDetail", "address"))
						.append(xpathSplit[2]).append(jsonParser(jsonData, "propertyDetail", "time"))
						.append(xpathSplit[3]).append(jsonParser(jsonData, "propertyDetail", "date"))
						.append(xpathSplit[4]);
				// System.out.println(sb.toString());
				String locater = xpathAppend.toString();
				waitClick(locatorParser(locater), 10);
				Thread.sleep(2000);
			}

			// ClickElement(locatorParser(jsonParser(jsonPath,"upcoming","cancelApmt")),"Appointment
			// cancel upcoming tab");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Mention tab name on main function to switch
	public void switchTab(String value) throws FileNotFoundException, IOException, ParseException {

		switch (value) {
		case "pending": {
			if (isDisplayed(locatorParser(jsonParser(jsonPath, "appointment", "pending")), "Pending tab"))
				ClickElement(locatorParser(jsonParser(jsonPath, "appointment", "pending")), "Pending tab");
		}
			break;
		case "upcoming": {
			if (isDisplayed(locatorParser(jsonParser(jsonPath, "appointment", "upcoming")), "Upcoming tab"))
				ClickElement(locatorParser(jsonParser(jsonPath, "appointment", "upcoming")), "upcoming");

		}
			break;
		case "history": {
			if (isDisplayed(locatorParser(jsonParser(jsonPath, "appointment", "history")), "History tab"))
				ClickElement(locatorParser(jsonParser(jsonPath, "appointment", "history")), "history");
		}
			break;

		}
	}

	//
	public boolean checkGreater1(String value1, String value2)
			throws FileNotFoundException, IOException, ParseException {
		int num1, num2;
		String var1 = value1;
		String var2 = value2;
		if (!(var2.contentEquals("Off"))) {
			var1 = var1.substring(0, 2);
			var2 = var2.substring(0, 2);

			num1 = Integer.parseInt(var1);
			num2 = Integer.parseInt(var2);
			System.out.println(num1 + " and " + num2);
			if (num1 <= num2)
				return false;
			else
				return true;
		} else
			return true;

	}

	//
	public boolean checkGreater2(String value1, String value2)
			throws FileNotFoundException, IOException, ParseException {
		int num1, num2;
		String var1 = value1;
		String var2 = value2;
		if (!(var1.contentEquals("Off"))) {
			if (!(var2.contentEquals("Off"))) {
				var1 = var1.substring(0, 2);
				var2 = var2.substring(0, 2);

				num1 = Integer.parseInt(var1);
				num2 = Integer.parseInt(var2);
				System.out.println(num1 + " and " + num2);
				if (num1 < num2)
					return true;
				else

					return false;
			} else
				return false;
		} else
			return true;
	}

	// Setting page value can be changed according to json value present in
	// schedulerData.json
	// Same value will not change in setting page.
	public void SettingChange() throws InterruptedException {

		try {
			// settings();

			if (isDisplayed(locatorParser(jsonParser(jsonPath, "settings", "settingPage")), "settingPage")) {

				// confirmationTime
				if (!(getText(locatorParser(jsonParser(jsonPath, "settings", "confirmationTime")))
						.contentEquals(jsonParser(jsonData, "settings", "confirmationTime")))
						&& isDisplayed(locatorParser(jsonParser(jsonPath, "settings", "confirmationTime")),
								"confirmationTime")) {
					if (checkGreater1(jsonParser(jsonData, "settings", "confirmationTime"),
							getText(locatorParser(jsonParser(jsonPath, "settings", "cancelDuration"))))) {
						ClickElement(locatorParser(jsonParser(jsonPath, "settings", "confirmationTime")),
								"confirmationTime");
						liSelect(locatorParser(jsonParser(jsonPath, "settings", "liConfirmationTime")),
								jsonParser(jsonData, "settings", "confirmationTime"));
						System.out.println("ConfirmationDuration");
					} else {
						ClickElement(locatorParser(jsonParser(jsonPath, "settings", "confirmationTime")),
								"confirmationTime");
						liSelect(locatorParser(jsonParser(jsonPath, "settings", "liConfirmationTime")),
								jsonParser(jsonData, "settings", "confirmationTime"));
						Thread.sleep(1000);
						driver.switchTo().alert().accept();
						System.out.println("ConfirmationDuration");
					}
				}
				Thread.sleep(1000);
				// CancelDuration
				if (!(getText(locatorParser(jsonParser(jsonPath, "settings", "cancelDuration")))
						.contentEquals(jsonParser(jsonData, "settings", "cancelDuration")))
						&& isDisplayed(locatorParser(jsonParser(jsonPath, "settings", "cancelDuration")),
								"cancelDuration")) {
					if (checkGreater2(jsonParser(jsonData, "settings", "cancelDuration"),
							getText(locatorParser(jsonParser(jsonPath, "settings", "confirmationTime"))))) {
						ClickElement(locatorParser(jsonParser(jsonPath, "settings", "cancelDuration")),
								"cancelDuration");
						liSelect(locatorParser(jsonParser(jsonPath, "settings", "liCancelDuration")),
								jsonParser(jsonData, "settings", "cancelDuration"));
						System.out.println("CancelDuration");
					}
				}
				Thread.sleep(1000);
				// maxDays
				if (!(getText(locatorParser(jsonParser(jsonPath, "settings", "maxDays")))
						.contentEquals(jsonParser(jsonData, "settings", "maxDays")))
						&& isDisplayed(locatorParser(jsonParser(jsonPath, "settings", "maxDays")), "maxDays")) {

					ImplicitWaitSwitch(3000);
					clickByAction(locatorParser(jsonParser(jsonPath, "settings", "maxDays")));
					liSelect(locatorParser(jsonParser(jsonPath, "settings", "liMaxDays")),
							jsonParser(jsonData, "settings", "maxDays"));
					System.out.println("maxDays");

				}
				Thread.sleep(1000);
				Thread.sleep(1000);
				// showingDuration
				if (!(getText(locatorParser(jsonParser(jsonPath, "settings", "showingDuration")))
						.contentEquals(jsonParser(jsonData, "settings", "showingDuration")))
						&& isDisplayed(locatorParser(jsonParser(jsonPath, "settings", "showingDuration")),
								"showingDuration")) {
					clickByAction(locatorParser(jsonParser(jsonPath, "settings", "showingDuration")));
					liSelect(locatorParser(jsonParser(jsonPath, "settings", "liShowingDuration")),
							jsonParser(jsonData, "settings", "showingDuration"));
					System.out.println("showingDuration");
					ImplicitWaitSwitch(3000);

				}
				Thread.sleep(1000);
				Thread.sleep(1000);
				// bufferTime
				if (!(getText(locatorParser(jsonParser(jsonPath, "settings", "bufferTime")))
						.contentEquals(jsonParser(jsonData, "settings", "bufferTime")))
						&& isDisplayed(locatorParser(jsonParser(jsonPath, "settings", "bufferTime")), "bufferTime")) {
					clickByAction(locatorParser(jsonParser(jsonPath, "settings", "bufferTime")));
					liSelect(locatorParser(jsonParser(jsonPath, "settings", "liBufferTime")),
							jsonParser(jsonData, "settings", "bufferTime"));
					System.out.println("bufferTime");
					ImplicitWaitSwitch(3000);
				}
				Thread.sleep(1000);
				if (isDisplayed(locatorParser(jsonParser(jsonPath, "settings", "saveBtn")), "Save Button check"))
					clickByAction(locatorParser(jsonParser(jsonPath, "settings", "saveBtn")));

				// Checking settings saved or not
				if (isDisplayed(locatorParser(jsonParser(jsonPath, "settings", "savedPopup")), "Saved popup check"))
					System.out.println("Changes Saved!!!");

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	public void renterlogin() throws InterruptedException, FileNotFoundException, IOException, ParseException {
		driver.manage().window().maximize();
		driver.navigate().to(jsonParser(jsonData, "renter", "url"));
		ClickElement(locatorParser(jsonParser(jsonPath, "renter", "signin")), "Sign in/up");
		EnterText(locatorParser(jsonParser(jsonPath, "renter", "phoneno")), jsonParser(jsonData, "renter", "phoneno"));
		if (isDisplayed(locatorParser(jsonParser(jsonPath, "renter", "submit")), "submit") && isAlertPresent())
			ClickElement(locatorParser(jsonParser(jsonPath, "renter", "submit")), "submitBtn");
		if (isDisplayed(locatorParser(jsonParser(jsonPath, "renter", "password")), "password"))
			EnterText(locatorParser(jsonParser(jsonPath, "renter", "password")),
					jsonParser(jsonData, "renter", "password"));
		ClickElement(locatorParser(jsonParser(jsonPath, "renter", "signinBtn")), "signinBtn");
		if (isDisplayed(locatorParser(jsonParser(jsonPath, "renter", "renterSignInCheck")), "renterSignInCheck")) {
			System.out.println("Renter SignIn Success!!!");
		} else
			System.out.println("Renter SignIn Failed!!!");
	}

	// checking alert is present on the page or not
	public boolean isAlertPresent() {
		boolean result = true;
		try {

			WebDriverWait wait = new WebDriverWait(driver, 3);
			wait.until(ExpectedConditions.alertIsPresent());
			result = false;
		} catch (TimeoutException eTO) {
			result = true;
		}
		return result;
	}

	// Homes rently properties scheduling for appointment
	public void renterSchedule() throws FileNotFoundException, IOException, ParseException, InterruptedException {
		StringBuilder xpathAppend = new StringBuilder(100);
		String url = jsonParser(jsonData, "renter", "homeurl");
		String[] xpathSplit = url.split("zzz");
		xpathAppend.append(xpathSplit[0]).append(jsonParser(jsonData, "renter", "homeID")).append(xpathSplit[1]);
		String locater = xpathAppend.toString();
		driver.navigate().to(locater);
		Thread.sleep(2000);

		if (isDisplayed(locatorParser(jsonParser(jsonPath, "renter", "checkHomeID")), "checkHomeID")) {
			String HomeIDTemp = getText(locatorParser(jsonParser(jsonPath, "renter", "checkHomeID")));
			HomeIDTemp = HomeIDTemp.substring(1, HomeIDTemp.length());
			if (HomeIDTemp.contentEquals(jsonParser(jsonData, "renter", "homeID"))) {
				if (isDisplayed(locatorParser(jsonParser(jsonPath, "renter", "scheduleShowing")),
						"scheduleShowing Check")) {
					ClickElement(locatorParser(jsonParser(jsonPath, "renter", "scheduleShowing")), "scheduleShowing");
					if (isDisplayed(locatorParser(jsonParser(jsonPath, "renter", "schedulePopupCheck")),
							"schedulePopupCheck")) {
						if (isDisplayed(locatorParser(jsonParser(jsonPath, "renter", "checkScheduleAvail")),
								"checkScheduleAvail")) {

							System.out.println("No time are currently available for this property!");
							DriverScript.bResult = false;
						} else {
							driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
							ClickElement(locatorParser(jsonParser(jsonPath, "renter", "selectDate")), "selectDate");
							waitClick(locatorParser(jsonParser(jsonPath, "renter", "DateTimeSelect")), 3);
								 																																							Thread.sleep(5000);
							ClickElement(locatorParser(jsonParser(jsonPath, "renter", "selectTime")),"Select time");
																																											Thread.sleep(5000);
							ClickElement(locatorParser(jsonParser(jsonPath, "renter", "DateTimeSelect")),"DateTimeSelect");
//								 EnterTextWithJS(locatorParser(jsonParser(jsonPath,"renter","selectDate")),jsonParser(jsonData,"renter","date"));
//								 EnterTextWithJS(locatorParser(jsonParser(jsonPath,"renter","selectTime")),jsonParser(jsonData,"renter","time"));
							waitClick(locatorParser(jsonParser(jsonPath, "renter", "scheduleBtn")),30);
							if (isAlertDisplyed())
								System.out.println(driver.switchTo().alert().getText());
							else
								DriverScript.bResult = false;
						}
					}
				}

			}
		}
	}

}
