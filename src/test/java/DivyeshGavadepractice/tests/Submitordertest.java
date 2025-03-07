package DivyeshGavadepractice.tests;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DivyeshGavadepractice.AbstractComponents.OrderPage;
import DivyeshGavadepractice.pageobjects.CartPage;
import DivyeshGavadepractice.pageobjects.CheckoutPage;
import DivyeshGavadepractice.pageobjects.ConfirmationPage;
import DivyeshGavadepractice.pageobjects.ProductCatalogue;
import dgSeleniumFramework.testComponents.BaseTest;



public class Submitordertest extends BaseTest{

	String productname="ZARA COAT 3";

	public void submitorder(HashMap<String, String> input) throws InterruptedException, IOException {
	    ProductCatalogue productCatalogue = landingPage.loginapplication(input.get("email"), input.get("password"));
	    List<WebElement> products = productCatalogue.getProductList();
	    productCatalogue.addProductoCart(input.get("productname"));
	    
	    CartPage cartPage = productCatalogue.GoToCartPage();
	    Boolean match = cartPage.verifyProductDisplay(input.get("productname"));
	    Assert.assertTrue(match);

	    CheckoutPage checkoutPage = cartPage.goToCheckout();
	    checkoutPage.selectCountry("india");
	    ConfirmationPage confirmationPage = (ConfirmationPage) checkoutPage.submitOrder();
	    String confirmmsg = confirmationPage.getConfirmationMessage();

	    Assert.assertTrue(confirmmsg.equalsIgnoreCase("Thank you for the order."));
		
		//div[@class='ng-tns-c4-4 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error']
		
		
	}
	@Test(dependsOnMethods = {"submitorder"} )
	public void orderHistoryTest() {
		ProductCatalogue productCatalogue=landingPage.loginapplication("divyeshdg21@gmail.com","@Lacazette9");
		OrderPage orderPage =productCatalogue.goToOrdersPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productname));
		
	}
	@DataProvider(name="getData")
	public Object[][] getData() {
	    HashMap<String, String> map1 = new HashMap<>();
	    map1.put("email", "divyeshdg21@gmail.com");
	    map1.put("password", "@Lacazette9");
	    map1.put("productname", "ZARA COAT 3");

	    HashMap<String, String> map2 = new HashMap<>();
	    map2.put("email", "divyeshdg@yahoo.com");
	    map2.put("password", "Admin@123");
	    map2.put("productname", "ADIDAS ORIGINAL");

	    return new Object[][] { { map1 }, { map2 } };  // Wrap HashMap inside Object[][]
		
	}
	
	
	
}