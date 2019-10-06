package seleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverA {
	public static WebDriver driver;
public static void  setWebDriver() {
	// TODO 自动生成的构造函数存根
	System.setProperty("webdriver.chrome.driver",
			"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	driver = new ChromeDriver();
}
}
