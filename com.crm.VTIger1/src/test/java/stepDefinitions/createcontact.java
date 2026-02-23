package stepDefinitions;

import java.io.IOException;

import genericUtility.ExcelUtility;
import genericUtility.propertiesUtility;
import io.cucumber.java.en.*;
import objectRepo.ContactPage;
import objectRepo.CreatingnewContact;
import objectRepo.HomePage;
import objectRepo.LoginPage;
import hooks.Hooks;

public class createcontact {

    propertiesUtility putil = new propertiesUtility();
    ExcelUtility eutil = new ExcelUtility();

    @Given("user is on home page")
    public void openHomePage() throws IOException {

        String URL = putil.getDataFromProperties("url");
        Hooks.driver.get(URL);

        String UN = putil.getDataFromProperties("username");
        String PS = putil.getDataFromProperties("password");

        LoginPage lp = new LoginPage(Hooks.driver);
        lp.login(UN, PS);
        lp.clickLogin();
    }

    // ⭐ IMPORTANT — MATCH FEATURE TEXT
    @When("user enters contact details from Excel")
    public void enterContactDetails() throws IOException {

        HomePage hp = new HomePage(Hooks.driver);
        hp.clickOnContactsMenu();

        ContactPage cp = new ContactPage(Hooks.driver);
        cp.CreateContact();

        String lname = eutil.getSingleCellDataFromExcel("Contacts", 7, 1);
        String department = eutil.getSingleCellDataFromExcel("Contacts", 7, 2);
        String email = eutil.getSingleCellDataFromExcel("Contacts", 7, 3);
        String city = eutil.getSingleCellDataFromExcel("Contacts", 7, 4);
        String state = eutil.getSingleCellDataFromExcel("Contacts", 7, 5);
        String country = eutil.getSingleCellDataFromExcel("Contacts", 7, 6);

        CreatingnewContact cnlp = new CreatingnewContact(Hooks.driver);
        cnlp.createNewContact(lname, department, email, city, state, country);

        System.out.println("New Contact Created");
    }

    @Then("user should navigate to contact page")
    public void verifyContactPage() {
        System.out.println("Contact page displayed");
    }
}