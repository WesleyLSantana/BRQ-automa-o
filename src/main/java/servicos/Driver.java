package servicos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
	
	protected  static WebDriver driver;
	protected static WebDriverWait wait;
	
	public static WebDriver getInstance() {
		if (driver == null) {
			//configurações google chrome
			String caminhoDriverChrome = System.getProperty("user.dir") + "\\src\\main\\recursos\\chromedriver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", caminhoDriverChrome);
			driver = new ChromeDriver();
			wait = new WebDriverWait(Driver.getInstance(), 15);
			driver.manage().window().maximize();
		}
		return driver;
	}
		

	public static void encerraDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
