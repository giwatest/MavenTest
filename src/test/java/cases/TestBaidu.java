package cases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dataread.RangeDatabyPOI;

public class TestBaidu {
	WebDriver dr;
	
	@DataProvider(name="muke")
	public Object[][] getData() throws IOException{
		String filepath="d:/nana/test/testdata.xlsx";
		Object[][] array = RangeDatabyPOI.poiRangeData(filepath);
		return array;
	}
	
	@Parameters({"browser","url"})
	@BeforeTest
	public void beforetest(String browser, String url) throws InterruptedException {
		System.out.println("I'm am BeforeTest");
		//打开浏览器
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:/nana/tools/selenium/driver/chromedriver_win32/chromedriver.exe");
			dr = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			
		}
		else if(browser.equals("edge")) {
			
		}else if(browser.equals("ie")) {
			
		}else {
			
		}
		dr.get(url);
		Thread.sleep(1000);
	}

	
	@Test(dataProvider = "muke")
	public void browser(String s1, String s2) throws InterruptedException {
		dr.findElement(By.id("kw")).clear();
		dr.findElement(By.id("kw")).sendKeys(s1);
		Thread.sleep(1000);
		dr.findElement(By.id("su")).click();
		Thread.sleep(1000);
		dr.findElement(By.id("kw")).clear();
		dr.findElement(By.id("kw")).sendKeys(s2);
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
