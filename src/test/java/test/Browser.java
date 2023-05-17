package test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	
	public static void main(String[] args) throws IOException {
WebDriverManager.chromedriver().setup(); // Can use specific versions by adding ".chromedriver().driverVersion("92.0").setup()"
		
		
		WebDriver driver = new ChromeDriver();
		
		
		// Timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		// Two ways to "move around". driver.get() and driver.navigate().to()
		driver.get("https://google.com");
		//String originalWindow = driver.getWindowHandle(); // Var for switching windows.
		//driver.navigate().to("https://bradbomkamp.com");
		
		
		// BROWSER ACTIONS
		
		// Get current URL
		System.out.println(driver.getCurrentUrl());
		
		// Get title
		System.out.println(driver.getTitle());
		
		// Forward | Back | Refresh
		
		// driver.navigate().forward();
		// driver.navigate().back();
		// driver.navigate().refresh();
		
		// Switching Windows
		//driver.switchTo().window(originalWindow);
		
		// Open new window and switch to the window
		//driver.switchTo().newWindow(WindowType.WINDOW);
		
		// Switch tab
		//driver.switchTo().newWindow(WindowType.TAB);
		
		// WINDOW MANAGEMENT - Size
		
		// Get width & height individually
		//int width = driver.manage().window().getSize().getWidth();
		//int height = driver.manage().window().getSize().getHeight();
		//System.out.println("The width of the window is: " + width);
		//System.out.println("The height of the window is: " + height);
		
		// Store dimensions & query later
		Dimension size = driver.manage().window().getSize();
		System.out.println("The width of the window is: " + size.getWidth());
		System.out.println("The height of the window is: " + size.getHeight());
		
		// Set window size
		driver.manage().window().setSize(new Dimension(800,600));
		
		// WINDOW MANAGEMENT - Position
		
		// Get x and y dimensions individually
		//int x = driver.manage().window().getPosition().getX();
		//int y = driver.manage().window().getPosition().getY();
		//System.out.println("The x position of the window is: " + x);
		//System.out.println("The y position of the window is: " + y);
		
		// Store x and y coordinates & query later
		Point position = driver.manage().window().getPosition();
		System.out.println("The x position is: " + position.getX());
		System.out.println("The y position is: " + position.getY());
		
		// Set position
		//driver.manage().window().setPosition(new Point(500,100));
		
		// Maximize window
		//driver.manage().window().maximize();
		// Minimize window
		//driver.manage().window().minimize();
		// Full Screen
		//driver.manage().window().fullscreen();
		
		// SCREENSHOTS
		
		// Take Screenshot
		//File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(srcFile, new File("./image1.png"));
		
		// Take Screenshot of an element
		//WebElement element = driver.findElement(By.cssSelector(".lnXdpd"));
		//File srcFile1 = ((TakesScreenshot)element).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(srcFile1, new File("./image2.png"));
		
		// JAVASCRIPT
		
		// Create the JavascriptExecutor interface object by Type casting,
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Get return value from script
		WebElement button = driver.findElement(By.name("btnI"));
		String text = (String)js.executeScript("return arguments[0].innerText", button);
		System.out.println("The text is: " + text);
		 
		// JavaScript to click element
		js.executeScript("arguments[0].click();", button);
		
		// Execute JS directly
		js.executeScript("console.log('Running JS, Hello World!')");
		
		
		
		
		
		
		// Close does active window?
		driver.close();
		// Quit ends entire session?
		driver.quit();
	}

}
