package seleniumTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		  driver= WebDriverA.driver;
		  System.out.println("失败了,要截图");
		  takeScreenShot(driver);
	    super.onTestFailure(tr);
	  }
	  public void takeScreenShot(WebDriver driver) {
		  SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		  String curTime=sdf.format(new Date());
		  String curClassName=this.getClass().getName();
		  String pngPath=curClassName+"_"+curTime+".png";
		  
		  String curPath=System.getProperty("user.dir");
		  File scr=((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
		  try {
			Files.copy(scr, new File(curPath+"\\"+pngPath));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  
}
