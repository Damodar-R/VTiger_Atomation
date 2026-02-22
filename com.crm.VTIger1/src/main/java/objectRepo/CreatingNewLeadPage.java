package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

public class CreatingNewLeadPage {
	
	public CreatingNewLeadPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
		this.driver=driver;
	}
	SeleniumUtility sutil=new SeleniumUtility();
	WebDriver driver;

	@FindBy(xpath="//input[@name='firstname']")
	private WebElement FirstName;
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement LastName;
	@FindBy(xpath="//input[@name='email']")
	private WebElement Email;
	@FindBy(xpath="//input[@name='company']")
	private WebElement Company;
	@FindBy(xpath="//input[@name='phone']")
	private WebElement Phone;
	@FindBy(xpath="//input[@name='country']")
	private WebElement Country;
	@FindBy(xpath="//input[@name='state']")
	private WebElement State;
	@FindBy(xpath="//input[@name='designation']")
	private WebElement Title;
	@FindBy(xpath="//select[@name='leadsource']")
	private WebElement LeadSource;
	@FindBy(xpath="//input[@name='noofemployees']")
	private WebElement NoOfEmployees;
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
	public WebElement getCompany() {
		return Company;
	}
	public WebElement getPhone() {
		return Phone;
	}
	public WebElement getCountry() {
		return Country;
	}
	public WebElement getState() {
		return State;
	}
	public WebElement getTitle() {
		return Title;
	}
	public WebElement getLeadSource() {
		return LeadSource;
	}
	public WebElement getNoOfEmployess() {
		return NoOfEmployees;
	}
	public WebElement getSavebtn() {
		return Savebtn;
	}
	
	public void createNewLead(String fname, String lname, String company) {
		FirstName.sendKeys(fname);
		LastName.sendKeys(lname);
		Company.sendKeys(company);
		Savebtn.click();
	}
	
	public void createNewLead(String lname, String company, String title,String leadsource,String noofemployees) {
		LastName.sendKeys(lname);
		Company.sendKeys(company);
		Title.sendKeys(title);
		sutil.selectOptionByvalue(driver, LeadSource,leadsource);
		NoOfEmployees.sendKeys(noofemployees);
		Savebtn.click();
	}
	public void createNewLead(String lname, String company, String noofemployees,String phone,String email,String state,String country) {
		LastName.sendKeys(lname);
		Company.sendKeys(company);
		NoOfEmployees.sendKeys(noofemployees);
		Phone.sendKeys(phone);
		Email.sendKeys(email);
		State.sendKeys(state);
		Country.sendKeys(country);
		Savebtn.click();
	}
}
