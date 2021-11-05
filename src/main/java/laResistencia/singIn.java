package laResistencia;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class singIn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String os = getOperatingSystem();
		if(os == "Windows 10") {
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "./chromedriver");
		}
		
		
		ChromeOptions options = new ChromeOptions();

		options.addArguments("start-maximized");

		options.addArguments("disable-infobars");

		options.addArguments("--disable-extensions");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebDriverWait more_wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			
			driver.get("https://publico.elterrat.com/programa/la-resistencia/formulario/");
			
			
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
			WebElement chaptcha = more_wait.until(ExpectedConditions.elementToBeClickable(By.className("recaptcha-checkbox-border")));
			chaptcha.click();
			//driver.switchTo().defaultContent();
			driver.findElement(By.className("gform_button")).click();

		} finally {
			System.out.println("Bot finished");
			//driver.quit();
		}
		  

	}
	
	private static void If(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public static String getOperatingSystem() {
	    String os = System.getProperty("os.name");
	    // System.out.println("Using System Property: " + os);
	    return os;
	}

}
