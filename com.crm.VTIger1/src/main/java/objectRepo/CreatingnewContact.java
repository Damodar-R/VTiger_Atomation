package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

public class CreatingnewContact {
	public CreatingnewContact(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement FirstName;
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement LastName;
	@FindBy(xpath="//input[@name='email']")
	private WebElement Email;
	@FindBy(xpath="//input[@name='department']")
	private WebElement Department;
	@FindBy(xpath="//input[@name='mobile']")
	private WebElement Mobile;
	@FindBy(xpath="//input[@name='mailingcountry']")
	private WebElement MaillingCountry;
	@FindBy(xpath="//input[@name='mailingstate']")
	private WebElement MaillingState;
	@FindBy(xpath="//input[@name='title']")
	private WebElement Title;
	@FindBy(xpath="//select[@name='leadsource']")
	private WebElement LeadSource;
	@FindBy(xpath="//input[@name='mailingcity']")
	private WebElement MaillingCity;
	@FindBy (xpath="//input[@type='submit']")
	private WebElement Savebtn;
	
	public WebElement getFirstName() {
		return FirstName;
	}
	public WebElement getLastName() {
		return LastName;
	}
	public WebElement getEmail() {
		return Email;
	}
	public WebElement getDepartment() {
		return Department;
	}
	public WebElement getMobile() {
		return Mobile;
	}
	public WebElement getMaillingCountry() {
		return MaillingCountry;
	}
	public WebElement getMaillingState() {
		return MaillingState;
	}
	public WebElement getTitle() {
		return Title;
	}
	public WebElement getLeadSource() {
		return LeadSource;
	}
	public WebElement getMaillingCity() {
		return MaillingCity;
	}
	public WebElement getSavebtn() {
		return Savebtn;
	}
	public void createNewContact(String fname, String lname, String title) {
		FirstName.sendKeys(fname);
		LastName.sendKeys(lname);
	    Title.sendKeys(title);
		Savebtn.click();
	}
	public void createNewContact(String lname, String department, String email,String mobile) {
		LastName.sendKeys(lname);
	    Department.sendKeys(department);
		Email.sendKeys(email);
	    Mobile.sendKeys(mobile);
		Savebtn.click();
	}
	public void createNewContact(String lname, String department, String email,String maillingcity,String maillingstate,String maillingcountry) {
		LastName.sendKeys(lname);
		Department.sendKeys(department);
		Email.sendKeys(email);
	    MaillingCity.sendKeys(maillingcity);
	    MaillingState.sendKeys(maillingstate);
	    MaillingCountry.sendKeys(maillingcountry);
		Savebtn.click();
	}
}
