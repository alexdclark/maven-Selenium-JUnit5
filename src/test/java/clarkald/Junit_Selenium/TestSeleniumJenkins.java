package clarkald.Junit_Selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class TestSeleniumJenkins {

	static ChromeOptions chromeOptions = new ChromeOptions();
	String chromeDriverPath ="C:\\Users\\clarkald\\Documents\\Development\\chromedriver.exe";
	
	// Headless Toggle
		static boolean headlessToggle = true;

		
		//Function that returns the correct Chrome Argument depending on headlessToggle
		public static String getArgs(boolean headlessOption) {
			if (headlessOption) {
				return "--headless";
			}

			else {
				return "--start-maximized";
			}
		}
	
		
		@Test
		public void hideColumn() {
			// Determining arguments for Chrome Driver
			chromeOptions.addArguments(getArgs(headlessToggle));

			//Setting Chrome Driver Path
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);

			// WebDriver Headless/Non-Headless
			WebDriver driver = new ChromeDriver(chromeOptions);

			// Navigating to Jay and Jonathans Angular Demo
			driver.get("https://jwatsondev.github.io/ng-prime-testing/");
			
			//Select the ID Column then clicking ID Column Button to hide column
			driver.findElement(By.xpath("/html/body/app-root/app-prime/p-table[1]/div/div[1]/div/p-multiselect/div/div[3]/span")).click();
			driver.findElement(By.xpath("/html/body/app-root/app-prime/p-table[1]/div/div[1]/div/p-multiselect/div/div[4]/div[2]/ul/li[1]")).click();
			
			//Attempting to target the ID Column which throws an exception as expected. If not exception is thrown test fails. 
			try
			{
				driver.findElement(By.id("id")).isDisplayed();
			     //statements that may cause an exception
			}
			catch(Exception e) {
				
				//System.out.println("Exception was thrown as expected since column was not visable");
				driver.close();
				return;
			}
			
			//Closing the Web Driver
			driver.close();
			
			//Failing the test if no exception was thrown.
			fail("The column was still visable");
			
			
		}
	
		@Test
		public void showColumn() {
			// Determining arguments for Chrome Driver
			chromeOptions.addArguments(getArgs(headlessToggle));
			
			//Creating variable to hold the result
			boolean result = false;

			//Setting Chrome Driver Path
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);

			// WebDriver Headless/Non-Headless
			WebDriver driver = new ChromeDriver(chromeOptions);

			// Navigating to Jay and Jonathans Angular Demo
			driver.get("https://jwatsondev.github.io/ng-prime-testing/");
			
			
			//Select the ID Column then clicking ID Column Button to hide column then clicking it again to show the column
			driver.findElement(By.xpath("/html/body/app-root/app-prime/p-table[1]/div/div[1]/div/p-multiselect/div/div[3]/span")).click();
			driver.findElement(By.xpath("/html/body/app-root/app-prime/p-table[1]/div/div[1]/div/p-multiselect/div/div[4]/div[2]/ul/li[1]")).click();
			driver.findElement(By.xpath("/html/body/app-root/app-prime/p-table[1]/div/div[1]/div/p-multiselect/div/div[4]/div[2]/ul/li[1]")).click();
			
			//Checking whether ID Column is displayed if it isn't on the page an exception is thrown and I fail the test. 
			try
			{
				result = driver.findElement(By.id("id")).isDisplayed();
			    
			}
			catch(Exception e) {
				
				System.out.println("Exception was thrown as expected since column was not visable");
				fail("The column was not visable");
				
			}
			
			//Checking the result on whether ID Column is displayed. 
			if (result) {
				System.out.println("The column was visable on the UI.");
			}
			
			//Closing the Chrome Driver
			driver.close();
				
		}
	
		@Test
		public void searchColumn() {
			
			// Determining arguments for Chrome Driver
			chromeOptions.addArguments(getArgs(headlessToggle));
			boolean result = false;

			System.setProperty("webdriver.chrome.driver", chromeDriverPath);

			// WebDriver Headless/Non-Headless
			WebDriver driver = new ChromeDriver(chromeOptions);

			// Navigating to Google and searching for weather for city entered by user
			driver.get("https://jwatsondev.github.io/ng-prime-testing/");
			
			//Hiding the ID Column by clicking the column dropdown then clicking ID
			driver.findElement(By.xpath("/html/body/app-root/app-prime/p-table[1]/div/div[1]/div/p-multiselect/div/div[3]/span")).click();
			driver.findElement(By.xpath("/html/body/app-root/app-prime/p-table[1]/div/div[1]/div/p-multiselect/div/div[4]/div[2]/ul/li[1]")).click();
			
			//Using the search box to search for columns with "id" in name
			driver.findElement(By.xpath("/html/body/app-root/app-prime/p-table[1]/div/div[1]/div/p-multiselect/div/div[4]/div[1]/div[2]/input")).sendKeys("id");
			
			//Selecting ID Column result
			driver.findElement(By.xpath("/html/body/app-root/app-prime/p-table[1]/div/div[1]/div/p-multiselect/div/div[4]/div[2]/ul/li[1]")).click();
			
			//Verifying that ID Column is displayed if it isn't an exception is thrown 
			try
			{
				result = driver.findElement(By.id("id")).isDisplayed();
			    
			}
			
			catch(Exception e) {
				
				System.out.println("Exception was thrown as expected since column was not visable");
				fail("The column was not visable");
				
			}
			
			if (result) {
				System.out.println("The column was visable on the UI.");
			}
			
			driver.close();
				
		}
	

}
