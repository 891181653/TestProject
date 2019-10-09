package seleniumCase;

import org.apache.log4j.Logger;
import org.apache.log4j.jmx.LoggerDynamicMBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseCase {
	private static Logger logger=Logger.getLogger(BaseCase.class);
   public WebDriver getDriver(String driverType) {
	   
	   WebDriver driver;
	   if(driverType.equalsIgnoreCase("chrome")) {
		   logger.debug("将要进行谷歌浏览器初始化");
		   System.setProperty("webdriver.chrome.driver",
					"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		   driver=new ChromeDriver();
		   return driver;
	   }else if(driverType.equalsIgnoreCase("firefox")){
		   logger.debug("将要进行火狐浏览器初始化");
		   System.setProperty("webdriver.gecko.driver","D:\\webdriver\\geckodriver\\geckodriver.exe");
		   driver=new FirefoxDriver();
		   
		   return driver;
	   }
	   else {
		   logger.error("失败：没有找到相关类型的浏览器驱动");
		   return null;
		   
	   }
   }
}
