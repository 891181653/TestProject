package seleniumPage;
//登录页面 获取界面元素

import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends BasePage {
	//public WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO 自动生成的构造函数存根
	}

	public WebElement geElementUserName() {
		
		return getElement("userName");
	}
	public WebElement geElementPass() {
		return getElement("passWord");
	}
	
	public WebElement geElementLoginButton() {
		return getElement("loginButton");
	}
	public WebElement geElementUserImg() {
		return getElement("userimg");
	}
	public void moveToElement(WebElement element) {
		Actions actions =new Actions(driver);
	    actions.moveToElement(element).perform();
	}
	public WebElement geElementUserLName() {
		return getElement("userLName");
	}
}
