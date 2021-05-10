package com.app.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.app.qa.base.TestBase;
import com.app.qa.pages.HomePage;
import com.app.qa.pages.LoginPage;
import com.app.qa.util.CustomListener;

@Listeners(CustomListener.class)
public class HomePageTest extends TestBase {
	LoginPage loginpg;
	HomePage homepg;
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		homepg= new HomePage();
		loginpg = new LoginPage();
		homepg = loginpg.loginValidation(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test
	public void validationOfHomePageTest(){
		String title=loginpg.validateLoginPageTitle();
		Assert.assertEquals(title, "Demo Web Shop");
	
	}
	@Test
	public void LogoDemositeImageTest(){
		boolean img=homepg.validateDemoSiteImage();
		Assert.assertTrue(img);
	
	}
	@Test
	public void ValidateTabs() {
	
		homepg.topRibboneForTabs("Books");
		homepg.topRibboneAlltabs();
	}
	
	@AfterMethod
	public void tearDown() {
		/*
		 * if(ITestResult.FAILURE==result.getStatus()) { TestUtils.screenShot(); }
		 */
		driver.quit();
	}

}
