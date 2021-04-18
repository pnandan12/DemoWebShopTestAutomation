package com.app.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.qa.base.TestBase;
import com.app.qa.pages.LoginPage;
import com.app.qa.pages.HomePage;
public class LoginPageTest extends TestBase {
	LoginPage login;
	HomePage homepg;
	
	
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		login= new LoginPage();
	}
	@Test(priority=0)
	public void validationOfLoginPageTest(){
		String title=login.validateLoginPageTitle();
		Assert.assertEquals(title, "Demo Web Shop. Login");
	
	}
	@Test(priority=1)
	public void LogoDemositeImageTest(){
		boolean img=login.validateDemoSiteImage();
		Assert.assertTrue(img);
	
	}
	@Test(priority=2)
	public void loginTest(){
	homepg=login.loginValidation(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
