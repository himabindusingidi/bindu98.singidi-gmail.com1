package com.pages;
import java.io.File;
import java.sql.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class addtocart_page //adding the item in cart
{
	WebDriver driver; //creating webdriver as local variable
	
	By search = By.xpath("//*[@id=\"SearchContent\"]/form/input[1]");
	By searchbutton = By.xpath("//*[@id=\"SearchContent\"]/form/input[2]");
	By productID = By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[2]/b/a/font");
	By ItemID = By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[3]/td[1]/a");
	By addtocart = By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[7]/td/a");

	public void url() // opening the url in chrome browser
	{
			System.setProperty("webdriver.chrome.driver","D:\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.get("https://petstore.octoperf.com/actions/Catalog.action");
		}
		
		
	public void search() //method for search
	{
		driver.findElement(search).sendKeys("fish");
	}

	public void searchbutton() //method for button
	{
		driver.findElement(searchbutton).click();
	}

	public void productID() //method for product ID
	{
		driver.findElement(productID).click();
	}

	public void ItemID() //method for Item ID
	{
		driver.findElement(ItemID).click();
	}

	public void addtocart() // method for adding the item in the cart
	{
		driver.findElement(addtocart).click();
		
		//To take the Screenshot
		
		Date date = new Date(0);
		String datestr = date.toString().replace(":", "-");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		screenshot.renameTo(new File("src/test/resources/screenshot/image2"+datestr+".png"));
		
		driver.close();
	}

}