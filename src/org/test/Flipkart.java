package org.test;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\eclipse-workspace\\WindowsHandling\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		WebElement btnc = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
		btnc.click();
		
		WebElement txtInput = driver.findElement(By.xpath("//input[@type='text']"));
		txtInput.sendKeys("iphone 7");
		
		WebElement btnS = driver.findElement(By.xpath("//button[@type='submit']"));
		btnS.click();
		
		Thread.sleep(3000);
		
		WebElement down = driver.findElement(By.xpath("(//span[contains(text(),'Add')])[23]"));
		down.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
         js.executeScript("arguments[0].scrollIntoView(true)", down);
         
		Thread.sleep(2000);
		WebElement firstLink = driver.findElement(By.xpath("(//div[contains(text(),'Apple iPhone 7')])[22]"));
		firstLink.click();
		
	    String parent = driver.getWindowHandle();
	    System.out.println(parent);
	    
	    Set<String> child = driver.getWindowHandles();
	    System.out.println(child);
	    
	    Thread.sleep(2000);
	    
	    for(String x :child)
	    {
	    	if(!parent.equals(x))
	    	{
	    		driver.switchTo().window(x);
	    	}
	    }
	    //WebElement addCart = driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']"));
		//addCart.click();
	}

}
