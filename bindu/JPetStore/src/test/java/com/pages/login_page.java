package com.pages;

import java.io.File;
import java.sql.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class login_page // login to the application
{

	WebDriver driver;  //creating webdriver as local variable

	By signin=By.xpath("//*[@id=\"MenuContent\"]/a[2]");
	By username=By.name("username");
	By password=By.name("password");
	By submit=By.xpath("//*[@id=\"Catalog\"]/form/input");


public void url() //opening the chrome browser
{
	System.setProperty("webdriver.chrome.driver","D:\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
public void loginpage() // method to open the url in the browser
{
	driver.get("https://petstore.octoperf.com/actions/Catalog.action");
	System.out.println(driver.getTitle());
}

public void logindetails() // method for the login credentials
{

	WebElement link =driver.findElement(signin); 
	
	Actions action = new Actions(driver);
	action.moveToElement(link);
	action.click().perform();
	driver.findElement(username).sendKeys("315126514138");
	driver.findElement(password).clear(); 
	driver.findElement(password).sendKeys("7702065605"); 
}
public void submit() throws InterruptedException //method to submit the credentials
{
	driver.findElement(submit).click(); 
	Thread.sleep(3000);
	
	//To take the Screenshot
	
	Date date = new Date(0);
	String datestr = date.toString().replace(":", "-");
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	File screenshot = ts.getScreenshotAs(OutputType.FILE);
	screenshot.renameTo(new File("src/test/resources/screenshot/image1"+datestr+".png"));
	driver.close();
}
}
