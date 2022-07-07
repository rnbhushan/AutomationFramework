package com.smoketest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiTest {

	WebDriver driver;

	@BeforeClass
	public void Initalization() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\ADMIN\\OneDrive\\SeleniumJars\\chromedriver.exe");

		driver = new ChromeDriver();// run time polymorphism

		driver.get("http://www.amazon.com");

		driver.manage().window().maximize();// maximize the browser

		System.out.println(driver.getTitle());
	}

	@Test
	public void SelectDropDown() throws InterruptedException {

		WebElement dropdownbox = driver.findElement(By.id("searchDropdownBox"));

		Select sel = new Select(dropdownbox);

		sel.selectByIndex(5);

		Thread.sleep(3000);

		//sel.selectByValue("search-alias=deals-intl-ship");

		sel.selectByVisibleText("Luggage");

	}

	@Test()
	public void AdvanceDropDown() {

		WebElement dropdownbox = driver.findElement(By.id("searchDropdownBox"));

		Select sel = new Select(dropdownbox);

		List<WebElement> li = sel.getOptions();

		System.out.println(li.size());

		for (int i = 0; i < li.size(); i++) {

			li.get(i).click();
			System.out.println(li.get(i).getText());
		}

		// reverse dropdown list

		for (int i = li.size() - 1; i >= 0; i--) {

			li.get(i).click();
			System.out.println(li.get(i).getText());
		}

	}

	@AfterClass
	public void Cleanup() {
		driver.close();
	}

}
