	package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepo.HomePage;
import objectRepo.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public propertiesUtility putil=new propertiesUtility();
	public SeleniumUtility sutil=new SeleniumUtility();
	public ExcelUtility eutil=new ExcelUtility();
	@BeforeSuite
	public void bsConfig() {
		System.out.println(" Create DB connectivity");
		}
	@BeforeClass
	public void bcConfig() throws IOException
	{
		 driver=new ChromeDriver();
		 String URL=putil.getDataFromProperties("url");
		 sutil.maximizewindow(driver);
		 sutil.implicitwait(driver, 15);
		 sutil.accessApplication(driver,URL);
		 System.out.println("Brower launched Successfully");
		
	}
	@BeforeMethod
	public void bmConfig() throws IOException {
		String UN=putil.getDataFromProperties("username");
		String PS=putil.getDataFromProperties("password");
		LoginPage lp=new LoginPage(driver);
		lp.login(UN, PS);
		System.out.println("Login done Successfully");
	}
	@AfterMethod
	public void amConfig()
	{
		HomePage hp=new HomePage(driver);
		hp.logoutOperation(driver);
		System.out.println("Logout done Successfully");
	}
	@AfterClass
	public void acConfig()
	{
		driver.quit();
		 System.out.println("Brower closed Successfully");
	}

	@AfterSuite
	public void asConfig()
	{
		System.out.println("close DB connectivity");
	}
}
