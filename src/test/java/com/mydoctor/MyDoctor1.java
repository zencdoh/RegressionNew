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

public class MyDoctor1 {
	public WebDriver driver = null;
	
	@BeforeTest
	public void OpenBrowser(){
		driver= new FirefoxDriver();
		System.out.println("opening browser");
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://doctor.imsrndlabs.com");
		System.out.println("opening url https://doctor-aws.THEVINCI.CO.IN ");
	}
	
@Test(priority=1)
public void verify_user_able_to_click_creatDoctor_Link() throws InterruptedException{
	
	driver.findElement(By.xpath("//*[@id='leftcolumn']/div/li[3]/a")).click();
	System.out.println("clicking on Admin login button");
	Thread.sleep(1500);
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys("10000");
	Thread.sleep(1500);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
	Thread.sleep(1500);
	driver.findElement(By.xpath("//input[@id='login']")).click();
	System.out.println("enter user name and password and click on ok button");
	Thread.sleep(1500);
	//Thread.sleep(30000);
	 //driver.findElement(By.xpath("//body")).sendKeys(Keys.F5);
	driver.findElement(By.xpath("//*[@id='navlist']/li[2]/a")).click();
	System.out.println("click on create doctor link");
	Thread.sleep(1500);
	String s1=driver.findElement(By.xpath("//div[@id='contentcolumn']/h2")).getText();
	Assert.assertEquals(s1, "Create Doctor");
	Thread.sleep(1500);
	System.out.println("after clicking on create doctor link verify text Create Doctor");
	
	
	
}



@AfterTest
public void logout() throws InterruptedException{
	driver.findElement(By.xpath("//*[@id='navlist']/li[1]/a")).click();
	System.out.println("click on Home button");
	Thread.sleep(1500);
	driver.findElement(By.xpath("//*[@id='navlist']/li[7]/a")).click();
	System.out.println("Click on logout Button");
	Thread.sleep(1500);
	driver.findElement(By.xpath("//*[@id='login']")).click();
	Thread.sleep(1500);
	System.out.println("*********************************************************");
	System.out.println();
	driver.close();
}
}
