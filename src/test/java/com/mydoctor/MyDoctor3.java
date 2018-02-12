package com.mydoctor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyDoctor3 {
public WebDriver driver = null;
	
	@BeforeTest
	public void OpenBroweser(){
		driver= new FirefoxDriver();
		System.out.println("opening browser");
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://35.225.248.24");
		System.out.println("opening url https://35.225.248.24 ");
	}
	
	@Test(priority=3)
	public void verify_user_able_to_click_deletePatient_Link() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='leftcolumn']/div/li[3]/a")).click();
		System.out.println("clicking on Admin login button");
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys("10000");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		System.out.println("enter user name and password and click on ok button");
		//Thread.sleep(30000);
		// driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
		driver.findElement(By.xpath("//*[@id='navlist']/li[4]/a")).click();
		System.out.println("click on DeletePatient link");
		String s1=driver.findElement(By.xpath("//div[@id='contentcolumn']/h2")).getText();
		Assert.assertEquals(s1, "Admin Home");
		System.out.println("after clicking on Delete patient link verify text Admin Home");
		
	}
	
	@AfterTest
	public void logout() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='navlist']/li[1]/a")).click();
		System.out.println("click on Home button");
		driver.findElement(By.xpath("//*[@id='navlist']/li[7]/a")).click();
		System.out.println("Click on logout Button");
		driver.findElement(By.xpath("//*[@id='login']")).click();
		Thread.sleep(2000);
		System.out.println("*********************************************************");
		System.out.println();
		driver.close();
	}
}
