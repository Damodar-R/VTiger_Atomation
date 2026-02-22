package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import genericUtility.ExcelUtility;
import genericUtility.SeleniumUtility;
import genericUtility.propertiesUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepo.LoginPage;
import objectRepo.LoginPage;

public class LoginSteps {

   
    LoginPage lp;
    public WebDriver driver;
	public propertiesUtility putil=new propertiesUtility();
	public SeleniumUtility sutil=new SeleniumUtility();
	public ExcelUtility eutil=new ExcelUtility();

    @Given("user is on login page")
    public void openLoginPage() throws IOException {
    	 driver=new ChromeDriver();
		 String URL=putil.getDataFromProperties("url");
		 sutil.maximizewindow(driver);
		 sutil.implicitwait(driver, 15);
		 sutil.accessApplication(driver,URL);
		 System.out.println("Brower launched Successfully");
    }

    @When("user enters credentials from Excel")
    public void enterCredentials() throws IOException {
    	String UN=putil.getDataFromProperties("username");
		String PS=putil.getDataFromProperties("password");
		 lp=new LoginPage(driver);
		lp.login(UN, PS);
		System.out.println("Login done Successfully");
    }
    @And("clicks on login button")
    public void clickLogin() {
        lp.clickLogin();
    }

    @Then("user should navigate to home page")
    public void verifyHomePage() {
        Assert.assertTrue(driver.getTitle().contains("Home"));
        driver.quit();
    }
}