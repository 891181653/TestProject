package seleniumTest;

import java.io.IOException;


import java.sql.Time;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Project {

	public static  void main(String[] args) throws InterruptedException, IOException {
		/*
		 * String firefoxdriver = "c:\\webdriver\\geckodriver.exe";
		 * System.setProperty("webdriver.gecko.driver",firefoxdriver); WebDriver driver
		 * = new FirefoxDriver(); driver.get("https://www.baidu.com");
		 * driver.findElement(By.id("")).sendKeys(""); // 获取 网页的 title
		 * System.out.println("The testing page title is: " + driver.getTitle();
		 */
		// 设置 chrome 的路径
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	/*	job job1=new job();
		job1.login(driver);*/
	/*	Baidu imweb=new Baidu();
		imweb.login(driver);
		imweb.register(driver);*/
		Imooc imooc=new Imooc();
		imooc.initDriver(driver);
		imooc.login();
	imooc.editImformation();
//		imooc.uploadPicture();
		for(int i=1;i<10;i++) {
		imooc.editPosition();}
		
	} 

}