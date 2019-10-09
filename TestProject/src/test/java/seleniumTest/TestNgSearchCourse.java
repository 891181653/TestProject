package seleniumTest;

import Help.HaveOrNo;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
@Listeners({listener.class})
public class TestNgSearchCourse  {
	private static Logger logger = Logger.getLogger(TestNgSearchCourse.class);
	WebDriver driver;
	WebDriverWait wait;
	HaveOrNo checkElement = new HaveOrNo();

  @Test
  public void f() throws InterruptedException {
	  courseSelected("Android与WebView的js交互");
	  
  }
  @Test
  public void testFail() {
	  driver.get("https://www.imooc.com/course/list?c=be");
	  //logger.error("测试查找课程失败");
	 // Assert.fail();
  }
  public void courseSelected(String className) throws InterruptedException {
		driver.get("https://www.imooc.com/course/list");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return arguments[0].scrollIntoView();";
		int coursePage = 1;
		WebElement nextPage = driver.findElement(By.linkText("下一页"));
		boolean nextOrNo = true;
		boolean findAnser = false;
		while (nextOrNo && (!findAnser)) {

			System.out.println("----------------------" + coursePage);
			// 还有下一页的情况执行
			List<WebElement> courseCard = driver.findElements(By.className("course-card-name"));
			Iterator<WebElement> listIt = courseCard.iterator();
			while (listIt.hasNext()) {

				WebElement elements = listIt.next();
				System.out.println("+++++++++++++" + elements.getText().toString());
				String courseName = elements.getText();
				if (className.equals(courseName)) {
					js.executeScript(script, elements);
					elements.click();
					findAnser = true;
					System.out.println("已经找到" + className);
					 logger.debug("查找课程成功");
					Thread.sleep(3000);
				}
			}
			HaveOrNo haveElement = new HaveOrNo();
			By seletor = By.linkText("下一页");
			// 检查是否可以定位到下一页
			if (haveElement.check(driver, seletor)) {
				nextPage = driver.findElement(By.linkText("下一页"));
				js.executeScript(script, nextPage);

				if (!nextPage.isEnabled()) {
					// 没有下一页了
					nextOrNo = false;
				} else {
					// 还有下一页
					coursePage++;
					nextPage.click();

				}
			}
		}
		if(findAnser==false) {
			 logger.error("查找课程失败");
		}

	}
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
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

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
