package com.smoketest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragDrop {

	@Test
	public void Test1() {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\ADMIN\\OneDrive\\SeleniumJars\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();//run time polymorphism
		
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		
		driver.manage().window().maximize();//maximize the browser
		
		System.out.println(driver.getTitle());
		
		WebElement startingposition = driver.findElement(By.xpath("//a[text()=' BANK ']"));
		
		WebElement lastposition = driver.findElement(By.id("bank"));
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(startingposition, lastposition).perform();
		
		
		

	}

}
