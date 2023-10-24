package project2;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class class1 {	
	
	WebDriver driver ; 
	 

	@BeforeTest
	public void login() {
		// Initialize the WebDriver (open Chrome)
    	driver = new ChromeDriver();

        // Navigate to the website
        driver.get("http://www.saucedemo.com");
        
        // Maximize the browser window
        driver.manage().window().maximize();
	}
   
	
	@Test(priority = 1)
	public void mytest() {

    	// UserName Field Element
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        
        // Password Field Element
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        
        // Login Button Element
        driver.findElement(By.id("login-button")).click();
        
        // Items Element
        List <WebElement> itemList = driver.findElements(By.xpath("//div[@class='inventory_item_name ']")) ;
        
        List <WebElement> itemPriceList = driver.findElements(By.xpath("//div[@class='inventory_item_price']")) ;
        
        // For Loop to Print the Item Name
        for(int count = 0 ; count < itemList.size() ; count++) {
        	System.out.println("The Item Name is " + itemList.get(count).getText() + " & " + "The Item Price is " + itemPriceList.get(count).getText()) ;
        	}
        }
	
	@Test(priority = 2)
	public void addItemToCard() throws InterruptedException {
		
		List <WebElement> itemList = driver.findElements(By.xpath("//button[text() = 'Add to cart']")) ; 
		
		// For Loop to Print the Item Name & Item Price
        for(int count = 0 ; count < itemList.size() ; count=count+2) {
        	itemList.get(count).click() ; 
        	Thread.sleep(2000) ;
        	}
	}
	
	
	@AfterTest
	public void mypost() {
		driver.quit();
	}
	
}
