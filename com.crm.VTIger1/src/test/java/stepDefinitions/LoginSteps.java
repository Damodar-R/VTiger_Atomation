package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import genericUtility.propertiesUtility;
import genericUtility.SeleniumUtility;
import io.cucumber.java.en.*;
import objectRepo.LoginPage;
import hooks.Hooks;

public class LoginSteps {

    LoginPage lp;
    propertiesUtility putil = new propertiesUtility();
    SeleniumUtility sutil = new SeleniumUtility();

    @Given("user is on login page")
    public void openLoginPage() throws IOException {

        String URL = putil.getDataFromProperties("url");
        sutil.implicitwait(Hooks.driver, 15);
        sutil.accessApplication(Hooks.driver, URL);

        System.out.println("Browser launched successfully");
    }

    @When("user enters credentials from Excel")
    public void enterCredentials() throws IOException {

        String UN = putil.getDataFromProperties("username");
        String PS = putil.getDataFromProperties("password");

        lp = new LoginPage(Hooks.driver);
        lp.login(UN, PS);
    }

    @And("clicks on login button")
    public void clickLogin() {
        lp.clickLogin();
    }

    @Then("user should navigate to home page")
    public void verifyHomePage() {
        Assert.assertTrue(Hooks.driver.getTitle().contains("Home"));
    }
}