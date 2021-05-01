package com.app.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.qa.base.TestBase;
import com.app.qa.pages.HomePage;
import com.app.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage login;
	HomePage homepg;
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		homepg= new HomePage();
	}
	@Test
	public void validationOfLoginPageTest(){
		String title=login.validateLoginPageTitle();
		Assert.assertEquals(title, "Demo Web Shop. Login");
	
	}
	@Test
	public void LogoDemositeImageTest(){
		boolean img=login.validateDemoSiteImage();
		Assert.assertTrue(img);
	
	}
	@Test
	public void ValidateTabs() {
		homepg.topRibboneForTabs(null,"ON");
	}

}
