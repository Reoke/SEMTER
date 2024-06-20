import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import runner.Executor;

import static org.junit.Assert.assertEquals;

public class PHPFusion_SearchUser {
	private WebDriver driver;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void runTest() throws InterruptedException{
		// 登录
		driver.get("http://localhost/phpFusion/phpFusion-8.00.19/news.php");
		driver.findElement(By.cssSelector(".textbox:nth-child(2)")).sendKeys("root");
		driver.findElement(By.cssSelector(".textbox:nth-child(5)")).sendKeys("12345678");// 903定位不到，修复成功
		driver.findElement(By.cssSelector(".button")).click();// 903定位错误，修复成功
		Thread.sleep(1000);
		// 进入管理员面板
		driver.findElement(By.linkText("Admin Panel")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("admin_password")).sendKeys("123456789");
		driver.findElement(By.name("admin_login")).click();
		Thread.sleep(1000);
		// 点击Unactivated的view more
		driver.findElement(By.cssSelector(".col-xs-12:nth-child(3) .panel-footer .text-smaller")).click();// 903定位不到，修复成功
		Thread.sleep(1000);
		assertEquals("smith", driver.findElement(By.cssSelector(".tbl1:nth-child(1) > a")).getText());// 903定位不到，修复成功
		Thread.sleep(2000);
	}

	public WebDriver getDriver() {
		return driver;
	}

}
