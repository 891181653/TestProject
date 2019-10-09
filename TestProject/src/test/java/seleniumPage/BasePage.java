package seleniumPage;

import org.openqa.selenium.By;

import org.openqa.selenium.By.ByPartialLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.ProcessUtils;

import seleniumUtil.ProUtil;

public class BasePage {
	public WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(String key) {
		WebElement element1 = driver.findElement(getByLocal(key));
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
