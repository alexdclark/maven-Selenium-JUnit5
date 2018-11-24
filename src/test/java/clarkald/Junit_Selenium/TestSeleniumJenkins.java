package clarkald.Junit_Selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class TestSeleniumJenkins {

	static ChromeOptions chromeOptions = new ChromeOptions();
	
	// Headless Toggle
		static boolean headlessToggle = false;

		public static String getArgs(boolean headlessOption) {
			if (headlessOption) {
				return "--headless";
			}

			else {
				return "--start-maximized";
			}
		}
	
		
		@Test
		public void noSnowCheck() {
			// Determining arguments for Chrome Driver
			chromeOptions.addArguments(getArgs(headlessToggle));

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\alexd\\Documents\\Development\\chromedriver.exe");

			// WebDriver Headless/Non-Headless
			WebDriver driver = new ChromeDriver(chromeOptions);

			// Navigating to Google and searching for weather for city entered by user
			driver.get("http://www.google.com");
			driver.findElement(By.name("q")).sendKeys("Cookeville Weather", Keys.RETURN);

			// Storing weather attributes (Temp and Wind)
			String currentTemp = driver.findElement(By.id("wob_tm")).getText().toString();
			String currentWind = driver.findElement(By.id("wob_ws")).getText().toString();
			String currentCity = driver.findElement(By.id("wob_loc")).getText().toString();
			String currentCondition = driver.findElement(By.id("wob_dc")).getText().toString();
			
			boolean isItSnowing = currentCondition.contains("Snow");

			// Closing the Web Driver
			driver.close();
			
			
			if (isItSnowing) {
				fail("It is snowing outside");
			
			}

			// System.out.println("The current Temperature in " + userInputTemp + " is: " +
			// currentTemp + " and the current wind speed is: " + currentWind);
			System.out.println("*** " + currentCity + " Weather Report ***");
			System.out.println("Weather Conditions " + currentCondition);
			System.out.println("Temp: " + currentTemp);
			System.out.println("Wind Spped: " + currentWind);
		}
	

}
