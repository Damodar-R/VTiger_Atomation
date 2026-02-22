package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class SeleniumUtility {
	/**
	 * this is  a generic method to launch a web application
	 * @author DDR
	 * @param driver
	 * @param url
	 */
	public static void accessApplication(WebDriver driver,String url){
		driver.get(url);
	}
	/**
	 * this is  a generic method to apply implicit wait
	 * @author DDR
	 * @param driver
	 * @param time
	 */
	public static void implicitwait(WebDriver driver,int time){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	public static void forword(WebDriver Driver){
		
	
	}
	/**
	 * this is a generic method to perform window maximize
	 * @author DDR
	 * @param driver
	 */
	
	public static void maximizewindow(WebDriver driver) {
		driver.manage().window().maximize();

	}
	/**
	 * this is a generic method to perform mouse hovering action
	 * @author DDR
	 * @param driver
	 * @param element
	 */
	public static void mouseHoveringAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * this is a generic method to perform right click operation
	 * @author DDR
	 * @param driver
	 * @param element
	 */
	public static void rightClickAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * this is a generic method to perform double click operation
	 * @author DDR
	 * @param driver
	 * @param element
	 */
	public static void doubleClickAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * this is a generic method to select an option from drop down by using its index
	 * @author DDR
	 * @param driver
	 * @param element
	 * @param index
	 */
    public static void selectOptionByIndex(WebDriver driver, WebElement element,int index) {
    	Select s=new Select(element);
    	s.selectByIndex(index);
    }
    /**
	 * this is a generic method to select an option from drop down by using its value
	 * @author DDR
	 * @param driver
	 * @param element
	 * @param index
	 */
    public static void selectOptionByvalue(WebDriver driver, WebElement element,String value) {
    	Select s=new Select(element);
    	s.selectByValue(value);
    }
    /**
	 * this is a generic method to select an option from drop down by using its visible text
	 * @author DDR
	 * @param driver
	 * @param element
	 * @param index
	 */
    public static void selectOptionByVisibleText(WebDriver driver, WebElement element,String visibletext) {
    	Select s=new Select(element);
    	s.selectByVisibleText(visibletext);
    }
    /**
     * this is a generic method to accept an Alert
     * @author DDR
     * @param driver
     */
    public static void acceptAlert(WebDriver driver) {
    	driver.switchTo().alert().accept();
    }
    /**
     * this is a generic method to cancel an Alert
     * @author DDR
     * @param driver
     */
    public static void cancelAlert(WebDriver driver) {
    	driver.switchTo().alert().dismiss();;
    }
    /**
     * this is a generic method to get text of  an Alert
     * @author DDR
     * @param driver
     */
    public static void getTextAlert(WebDriver driver) {
    	driver.switchTo().alert().getText();
    }
    /**
     * this is a generic method to take screenshot of a web page
     * @param driver
     * @param screenhotName
     * @return
     * @throws IOException 
     */
    public static String getScreenShot(WebDriver driver,String screenshotName) throws IOException {
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File src=ts.getScreenshotAs(OutputType.FILE);
    	File dts=new File(".\\screenshot\\"+screenshotName+".png");
    	Files.copy(src, dts);
		return dts.getAbsolutePath();  //used in listeners
    }
    /**
     * this is a generic method to take screenshot of a web element
     * @param driver
     * @param screenhotName
     * @return
     * @throws IOException 
     */
    public static String getScreenShotOfElement(WebElement element,String screenshotName) throws IOException {
    	
    	File src=element.getScreenshotAs(OutputType.FILE);
    	File dts=new File(".\\screenshot\\"+screenshotName+".png");
    	Files.copy(src, dts);
		return dts.getAbsolutePath();  //used in listeners
    }
   
}
