package com.mydoctor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyDoctor {
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
	
@Test()
public void verify_user_able_to_click_creatDoctor_Link(){
	driver.findElement(By.xpath("//*[@id='leftcolumn']/div/li[3]/a")).click();
	System.out.println("clicking on login button");
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys("10000");
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
	driver.findElement(By.xpath("//input[@id='login']")).click();
	System.out.println("enter user name and password and click on ok button");
	driver.findElement(By.xpath("//*[@id='navlist']/li[2]/a")).click();
	System.out.println("click on create doctor link");
	String s1=driver.findElement(By.xpath("//div[@id='contentcolumn']/h2")).getText();
	Assert.assertEquals(s1, "Create Doctor");
	System.out.println("after clicking on create doctor link verify text Create Doctor");
	/*System.out.println("verify create doctor link");*/
	
	
	
}

@AfterTest
public void logout(){
	driver.findElement(By.xpath("//*[@id='navlist']/li[1]/a")).click();
	System.out.println("click on Home button");
	driver.findElement(By.xpath("//*[@id='navlist']/li[7]/a")).click();
	System.out.println("Click on logout Button");
	driver.findElement(By.xpath("//*[@id='login']")).click();
	driver.quit();
}
}
