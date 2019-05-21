package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBaidu2 {
	WebDriver dr;
	
	@BeforeTest
	public void beforetest() throws InterruptedException {
		System.out.println("I'm am BeforeTest");
		//打开浏览器
		System.setProperty("webdriver.chrome.driver","D:/nana/tools/selenium/driver/chromedriver_win32/chromedriver.exe");
		dr = new ChromeDriver();
		dr.get("https://baidu.com");
		Thread.sleep(1000);
	}

	@Test
	public void browser() throws InterruptedException {
		System.out.println("I'm test");
		dr.findElement(By.id("kw")).sendKeys("abcd");
		Thread.sleep(1000);
		dr.findElement(By.id("su")).click();
		Thread.sleep(1000);
		
	}
	
	@AfterTest
	public void aftertest() {
		System.out.println("I'm aftertest");
		dr.quit();
	}
	
	
}
