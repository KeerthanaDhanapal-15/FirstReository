package org.test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\eclipse-workspace\\WindowsHandling\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		WebElement txtInput = driver.findElement(By.xpath("//input[@type='text']"));
		txtInput.sendKeys("moto g6");
		
		WebElement btnSearch = driver.findElement(By.xpath("(//input[@class='nav-input'])[1]"));
		btnSearch.click();
		
	    WebElement btnC = driver.findElement(By.xpath("//span[contains(text(),'Venito Siena ')]"));
		btnC.click();
		
		String p = driver.getWindowHandle();
		System.out.println(p);
		
		Set<String> c = driver.getWindowHandles();
		System.out.println(c);
		
	    for (String x : c) 
	    {
			if(!p.equals(c))
			{
				driver.switchTo().window(x);
			}
		}
	    WebElement addCart = driver.findElement(By.id("add-to-cart-button"));
		addCart.click();
	}

}
