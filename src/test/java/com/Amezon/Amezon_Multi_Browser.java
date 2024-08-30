package com.Amezon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Amezon_Multi_Browser {
	WebDriver driver;
	String bName;


	@Test
	public void chrome() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/ref=nav_logo");
		
	     bName = "Chrome";


	}

	@Test
	public void edge() {

		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/ref=nav_logo");
		
		bName = "Edge";


	}

	@Test
	public void FirFox() {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/ref=nav_logo");
		
		bName = "FireFox";


	}


	@AfterMethod
	public void AfterMethod() throws IOException {

		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		org.openqa.selenium.io.FileHandler.copy(file, new File(bName + "_ScreenShot" + ".jpeg"));

		driver.close();	

	}


	@AfterTest
	public void afterTest() {

		System.out.println("All Test are Completed........");

	}

}
