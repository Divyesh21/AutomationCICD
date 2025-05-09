package DivyeshGavadepractice.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DivyeshGavadepractice.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;

	@FindBy(css="div[class='cartSection'] h3")
	List<WebElement>cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyProductDisplay(String productname) {
		
		Boolean match=cartProducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));

		return match;
		
	}
	
	public CheckoutPage goToCheckout() {
		
		checkoutEle.click();
		return new CheckoutPage(driver);
	}
	

}
 