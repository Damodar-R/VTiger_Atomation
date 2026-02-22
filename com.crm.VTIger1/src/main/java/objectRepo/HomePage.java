package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

public class HomePage {
	SeleniumUtility sutil=new SeleniumUtility();

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy (xpath="(//a[text()='Leads']) [1]")
	private WebElement Lead;
	@FindBy (xpath= "(//a[text()='Contacts']) [1]")
	private WebElement Contact;
       @FindBy (xpath="//td[@class='small']//img")
       private WebElement Logouticon;
       
       @FindBy (xpath="//a[text()='Sign Out']")
       private WebElement Signup;


	public WebElement getLead() {
		return Lead;
	}
	public WebElement getContact() {
		return Contact;
	}
	public WebElement getLogouticon() {
		return Logouticon;
	}
	public WebElement getSignup() {
		return Signup;
	}
	
	public void clickOnLeadsMenu() {
		Lead.click();
		
	}
	public void clickOnContactsMenu() {
		Contact.click();
	}
public void logoutOperation(WebDriver driver) {
		
		sutil.mouseHoveringAction(driver, Logouticon);
		Signup.click();
}
}
