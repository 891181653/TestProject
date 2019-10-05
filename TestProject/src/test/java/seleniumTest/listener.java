package seleniumTest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.google.common.io.Files;

public class listener extends TestListenerAdapter {
	WebDriver driver;
	
	  @Override
	  public void onTestFailure(ITestResult tr) {
		  TestNgLogin tl= (TestNgLogin)tr;
		  driver=tl.driver;
		  System.out.println("失败了,要截图");
		  takeScreenShot();
	    super.onTestFailure(tr);
	  }
	  public void takeScreenShot() {
		  
		  File scr=((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
		  try {
			Files.copy(scr, new File("C:\\Users\\Candy\\git\\repository\\TestProject\\editPosition.png"));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  
}
