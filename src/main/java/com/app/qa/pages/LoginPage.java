package com.app.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory or Obejct repo
	@FindBy(id="Email")
	WebElement username;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Log in']")
	WebElement btnLogin;
	@FindBy(xpath="//img[contains(@alt,'Tricentis Demo Web Shop')]")
	WebElement imgDemoWebShopLOGO;
	
	//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
	
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateDemoSiteImage(){
			return imgDemoWebShopLOGO.isDisplayed();
		}
		
		public HomePage loginValidation(String un, String pwd){
			username.sendKeys(un);
			password.sendKeys(pwd);
			btnLogin.click();
			    	//JavascriptExecutor js = (JavascriptExecutor)driver;
			    	//js.executeScript("arguments[0].click();", btnLogin);
			    	
			return new HomePage();
		}

}
