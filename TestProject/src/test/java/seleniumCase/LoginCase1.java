package seleniumCase;

import org.testng.annotations.Test;

import Help.HaveOrNo;
import seleniumHandle.LoginHandle;
import seleniumTest.WebDriverA;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class LoginCase1 extends BaseCase{
	static Logger logger = Logger.getLogger(LoginCase1.class);

	WebDriver driver;
	WebDriverWait wait;
	HaveOrNo checkElement = new HaveOrNo();
	LoginHandle loginHandle;
	
	@Parameters({"userName","passWord","url"})
	@Test
	public void login(String userName,String passWord,String url) {
		driver.get(url);
		logger.debug("浏览器打开成功");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		driver.findElement(By.linkText("登录")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		loginHandle.sendKeyUserName(userName);
		loginHandle.sendKeyPassWord(passWord);
		loginHandle.clickButton();
		logger.debug("用户登录成功");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("-----------------------f");
		String userName1=loginHandle.checkElement();
		AssertJUnit.assertEquals(userName1, "慕侠1185987");
		logger.debug("用户登录后信息匹配成功");
		logger.error("-tetste--------");
	}


	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}
@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browser) {
		PropertyConfigurator.configure("log4j.properties");
		BaseCase baseCase=new BaseCase();
		driver =baseCase.getDriver(browser);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 3000);
		loginHandle = new LoginHandle(driver);
		logger.debug("浏览器driver初始化成功");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		System.out.println("afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}


}
