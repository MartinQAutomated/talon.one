package talon.one;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class Imdb {

	public static void main(String[] args) throws InterruptedException  {

		System.setProperty("webdriver.chrome.driver", "C://Users//Martin//Desktop//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String URL = "https://www.imdb.com/";
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='suggestion-search']"));
		
		// 1. Making sure the search box is interactive
		
		searchbox.click();
		searchbox.sendKeys("Batman");
		
		Thread.sleep(3000);
  
		// 2. Listing the titles of the suggestions from the search
		
		List<WebElement> allSearchResults=driver.findElements(By.className("7s1aS0NikSNpkLVY3A1sk"));
	
		for(WebElement eachResult : allSearchResults) {
	    System.out.println("Title : "+eachResult.getText()+", Link : "+eachResult.getAttribute("href"));
	    
	    Thread.sleep(1000);
	
	   
	    // 3. Verifying that the link to a movie redirects us to that movie successfully
	    
	    Actions actions = new Actions(driver);
	    WebElement target = driver.findElement(By.xpath("//li[@id='react-autowhatever-1--item-0']"));
	    
	    actions.moveToElement(target);
	    actions.click().build().perform();
	    
	    
	    Thread.sleep(2000);
	    
	    driver.close();
		
		 
		 
		 
		 
			
	       }
	   }
		
			
		
		
	}


