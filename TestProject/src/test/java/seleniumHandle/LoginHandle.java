package seleniumHandle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seleniumPage.LoginPage;

public class LoginHandle {
   LoginPage loginPage;
	
	public LoginHandle(WebDriver driver) {
		loginPage=new LoginPage(driver);
	}
	public void sendKeyUserName(String userName) {
		loginPage.geElementUserName().sendKeys(userName);;
	}
	public void  sendKeyPassWord(String password) {
		loginPage.geElementPass().sendKeys(password);
	}
	public void  clickButton() {
		loginPage.geElementLoginButton().click();
	}
     public String checkElement() {
    	 WebElement img=loginPage.geElementUserImg();
    	 loginPage.moveToElement(img);
    	 return loginPage.geElementUserLName().getText();
     }
}
