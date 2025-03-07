package DivyeshGavadepractice.tests;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import DivyeshGavadepractice.AbstractComponents.AbstractComponent;
import DivyeshGavadepractice.pageobjects.CartPage;
import DivyeshGavadepractice.pageobjects.CheckoutPage;
import DivyeshGavadepractice.pageobjects.ConfirmationPage;
import DivyeshGavadepractice.pageobjects.LandingPage;
import DivyeshGavadepractice.pageobjects.ProductCatalogue;
import dgSeleniumFramework.testComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;



public class ErrorValidations extends BaseTest{

	@Test(groups={"Errorhandling"})
	public  void submitorder() throws InterruptedException, IOException {	
		
		String productname="ZARA COAT 3";
		ProductCatalogue productCatalogue=landingPage.loginapplication("divyeshdg21@gmail.com","@Lacazett");
		List<WebElement>products=productCatalogue.getProductList();
		
		landingPage.getErrorMessage();
		System.out.println("reached here");
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
		
		AssertJUnit.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
		
		//div[@aria-label='Incorrect email or password.']
		
		
				
		
				
	}

}
