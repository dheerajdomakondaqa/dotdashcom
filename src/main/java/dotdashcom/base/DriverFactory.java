package dotdashcom.base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dotdashcom.util.PropertiesUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private static WebDriver driver = null;
	
	public static WebDriver getDriver() {
		
		if(driver != null) {
			return driver;
		}
		
		String browser = PropertiesUtils.getConfigProperties("browser");
		switch(browser) {
		case "chrome":
		case "Chrome":
		case "CHROME":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(PropertiesUtils.getConfigProperties("implicitwait"))));
		
		return driver;
	}
	
	
	public static void closeDriver() {
		try {
			driver.close();
			driver.quit();
		}catch(Exception e) {
			
		}
		driver = null;
	}
	
}
