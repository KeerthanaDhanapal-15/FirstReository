package org.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Snapdeal {
	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\eclipse-workspace\\WindowsHandling\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement w1 = driver.findElement(By.id("inputValEnter"));
		w1.sendKeys("redmi note 7 pro mobile");
		Robot r=new Robot();
		for(int i=0;i<=8;i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);

		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
WebElement w2 = driver.findElement(By.name("keyword"));
w2.clear();
w2.sendKeys("iphone 6");
WebElement w3 = driver.findElement(By.className("searchTextSpan"));
w3.click();
Thread.sleep(2000);
WebElement w5 = driver.findElement(By.xpath("//p[contains(text(),'Apple iphone 6s')]"));
w5.click();
String par = driver.getWindowHandle();
System.out.println(par);
Set<String> chi = driver.getWindowHandles();
System.out.println(chi);
for(String x:chi) {
	if(!par.equals(chi)) {
		driver.switchTo().window(x);
	}
}
Set<String> chi1=driver.getWindowHandles();
List<String> emp=new ArrayList<>();
emp.addAll(chi1);
WebElement w6 = driver.findElement(By.id("add-cart-button-id"));
w6.click();

	}
	

}

