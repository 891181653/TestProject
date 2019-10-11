package seleniumPage;

import org.apache.bcel.verifier.exc.StaticCodeConstraintException;
import org.apache.log4j.Logger;
import org.eclipse.jetty.util.statistic.SampleStatistic;
import org.openqa.selenium.By;

import org.openqa.selenium.By.ByPartialLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.ProcessUtils;

import seleniumUtil.ProUtil;

public class BasePage {
	public WebDriver driver;
	private static Logger logger = Logger.getLogger(BasePage.class);

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(String key) {
		boolean flag = true;
		WebElement element1 = null;
		int i = 1;
		while (flag) {
			try {
				element1 = driver.findElement(getByLocal(key));
                flag=false;
			} catch (Exception e) {
				// TODO: handle exception
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				if (i == 10) {
					flag = false;
					logger.error("查找元素失败，找不到元素 ： " + key);
					System.out.println("查找元素失败，找不到元素 ： " + key);
				} else {
					i++;
				}
			}

		}
		return element1;
	}

	public By getByLocal(String key) {
		ProUtil proUtil1 = new ProUtil("elements.properties");
		String locator = proUtil1.getPro(key);
		String locatorBy = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		if (locatorBy.equals("id")) {
			return By.id(locatorValue);
		} else if (locatorBy.equals("name")) {
			return By.name(locatorValue);
		} else if (locatorBy.equals("className")) {
			return By.className(locatorValue);
		} else if (locatorBy.equals("xpath")) {
			return By.xpath(locatorValue);
		} else if (locatorBy.equals("linkText")) {
			return By.linkText(locatorValue);
		} else if (locatorBy.equals("tagName")) {
			return By.tagName(locatorValue);
		} else if (locatorBy.equals("cssSelector")) {
			return By.cssSelector(locatorValue);
		} else if (locatorBy.equals("partialLinkText")) {
			return By.partialLinkText(locatorValue);
		} else {
			return null;
		}
	}

}
