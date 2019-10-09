package seleniumTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Help.HaveOrNo;
import Help.yanzheng.Captcha;
import Help.yanzheng.DamaUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterTest;

@Listeners({ listener.class })
public class TestNgLogin  {
	private static Logger logger = Logger.getLogger(TestNgLogin.class);

	WebDriver driver;
	WebDriverWait wait;
	HaveOrNo checkElement = new HaveOrNo();

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("this is beforeMethod");
	}

	@BeforeClass
	public void beforeClass() {
		PropertyConfigurator.configure("log4j.properties");
		WebDriverA.setWebDriver();
		driver=WebDriverA.driver;
		driver.get("https://www.imooc.com");
		driver.manage().window().maximize();
		System.out.println("this is beforeClass");
		wait = new WebDriverWait(driver, 3000);
	}

	@Test
	public void loginAndEdiPosition() throws InterruptedException {
		logger.debug("开始修改地址");
		driver.findElement(By.linkText("登录")).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("js-loginWrap")));
		driver.findElement(By.name("email")).sendKeys("13437868119");
		driver.findElement(By.name("password")).sendKeys("zxcfghuiop321");
		driver.findElement(By.className("xa-login")).click();
		String newPosition = "方子燕姑";
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"header-avator\"]/img")));
		driver.findElement(By.xpath("//*[@id=\"header-avator\"]/img")).click();
		driver.findElement(By.className("set-btn")).click();
		driver.findElement(By.linkText("收件地址")).click();
		Thread.sleep(3000);
		By sele = new By.ByXPath("//*[@id=\"main\"]/div/div[2]/div/div/div[3]/div/ul/li[1]/div/p[1]");

		if (!(checkElement.check(driver, sele))) {
			System.out.println("地址已满，不允许添加了");
		} else {

			driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div[3]/div/ul/li[1]/div/p[1]")).click();

			Thread.sleep(1000);
			WebElement contentBox = driver.findElement(By.className("contentBox"));
			WebElement listul = contentBox.findElement(By.className("list-box"));
			List<WebElement> targetF = listul.findElements(By.tagName("li"));
			String allName = newPosition.toString() + targetF.size();
			driver.findElement(By.id("name")).sendKeys(allName);
			driver.findElement(By.id("phone")).sendKeys("13452654556");
			WebElement prov = driver.findElement(By.id("province-select"));
			prov.click();
			Thread.sleep(1000);
			Select pro1 = new Select(prov);
			pro1.selectByVisibleText("广东");
			prov.click();

			Thread.sleep(1000);
			WebElement city = driver.findElement(By.id("city-select"));
			city.click();
			Thread.sleep(1000);
			Select city1 = new Select(city);
			city1.selectByVisibleText("湛江市");
			city.click();

			Thread.sleep(1000);
			WebElement area = driver.findElement(By.id("area-select"));
			area.click();
			Thread.sleep(1000);
			Select area1 = new Select(area);
			area1.selectByVisibleText("雷州市");
			area.click();

			driver.findElement(By.id("addrdetail"))
					.sendKeys("哈哈村那里d80a294506b4c9d18015e755cee48f953ddc3f2f-refs/branch-heads/380f非要20个字");
			driver.findElement(By.id("zipcode")).sendKeys("510000");

			driver.findElement(By.id("submit")).click();
			Thread.sleep(4000);
			// 验证是否提交成功
			contentBox = driver.findElement(By.className("contentBox"));
			listul = contentBox.findElement(By.className("list-box"));
			By sele1 = new By.ByXPath("//*[@id=\"main\"]/div/div[2]/div/div/div[3]/div/ul/li[1]/div/p[1]");
			List<WebElement> target = listul.findElements(By.tagName("li"));
			System.out.println();
			WebElement newOne;
			if (checkElement.check(driver, sele1)) {
				System.out.println(target.size() + "--------------------");
				newOne = target.get(1);

			} else {
				System.out.println(target.size() + "--------------------");
				newOne = target.get(0);
			}

			WebElement nameIn = newOne.findElement(By.className("name"));
			if (nameIn.getText().equals(allName)) {
				System.out.println("录入成功");
				// 修改默认
				Actions actions = new Actions(driver);
				actions.moveToElement(newOne).perform();
				Thread.sleep(2000);

				if (target.size() == 2) {
					System.out.println("不需要修改默认的地址");
				} else {
					newOne.findElement(By.className("js-normal-btn")).click();
					Thread.sleep(2000);

					String statues = newOne.findElement(By.className("normal-icon")).getAttribute("style");
					System.out.println(statues + "----------------------");
					if (statues.equals("display: block;")) {
						System.out.println("SUCCESS");
					} else {
						System.out.println("ERROR");
						

					}
				}
				// end修改默认
			} else {
				System.out.println("录入失败");
			}
		}
		Assert.fail("假装失败了");
		

	}

public void sendEmail() {
	SimpleEmail email=new SimpleEmail();
	
	//制定用哪个邮箱
	email.setHostName("smtp.163.com");
	//制定账号和客户端授权密码
	email.setAuthentication("a891181653@163.com", "zaqxsw123");
	try {
		//设置发送邮箱
		email.setFrom("a891181653@163.com");
		//添加要放送的邮箱
		email.addTo("891181653@qq.com");
		//添加标题
		email.setSubject("selenium immooc editPosition");
		//添加内容
		email.setMsg("testcase :TestNgLogin is finish");
		//发送邮件
		email.send();
		logger.debug("邮件已发送");
	} catch (EmailException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
}
	@AfterMethod
	public void afterMethod() {
		System.out.println("this is afterMethod");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("this is afterClass");
		sendEmail();
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("this is beforeTest");

	}

	@AfterTest
	public void afterTest() {
		System.out.println("this is afterTest");
		// driver.close();
	}

}
