package com.app.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath = "//a[contains(text(),'praveenkumar51357@gmail.com')]")
	WebElement accountName;
	@FindBy(xpath = "//a[contains(@class,'ico-logout')]")
	WebElement linkLogout;
	@FindBy(xpath = "//ul[@class='mob-top-menu']/li/a[contains(text(),'Computers')]")
	WebElement tabComputers;
	@FindBy(xpath = "//ul/li/a[@href='/desktops' and @class='hover']")
	WebElement linkDesktop;
	@FindBy(xpath = "//ul[@class='mob-top-menu']/li/a[contains(text(),'Books')]")
	WebElement linkBooks;
	@FindBy(xpath = "//ul[@class='mob-top-menu']/li/a[contains(text(),'Electronics')]")
	WebElement linkElectronics;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnTabComputersLink() {
		Actions action = new Actions(driver);
		action.moveToElement(tabComputers).build().perform();
		linkDesktop.click();

	}

	public void topRibboneForTabs(String tabName, String CheckoptionAll) {
		
		if (CheckoptionAll == "OFF" && tabName != null && tabName.length() < 5) 
				driver.findElement(By.xpath("//ul[@class='mob-top-menu']/li/a[contains(text(),'" + "tabName" + "')]"));	
		else
			System.out.println("Invalid Entry");
		
		if (CheckoptionAll == "ON" && tabName == null) {
			List<WebElement> tbOptions=driver.findElements(By.xpath("//ul[@class='mob-top-menu']/li/a"));
			for(WebElement ele:tbOptions) 
				System.out.print("/t"+ele.getText());	
		}else
			System.out.println("Invalid Entry");
	}

}
