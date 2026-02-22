package objectRepo;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public WebElement getUsernameTF() {
	
		return usernameTF;
	}
	
	
	public WebElement getPasswordTF() {
		return passwordTF;
	}
	
	public WebElement getButton() {
		return button;
	}
	
	
	@FindBy(name="user_name") WebElement usernameTF;
	@FindBy(name="user_password") WebElement passwordTF;
	@FindBy(id="submitButton") WebElement button;
	 public void login(String user, String pass) {
	        usernameTF.sendKeys(user);
	        passwordTF.sendKeys(pass);
	        
	    }
	 public void clickLogin() {
		    button.click();
		}
		
	}

