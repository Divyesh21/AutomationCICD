package DivyeshGavadepractice.AbstractComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends AbstractComponent {
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement>productnames;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
public Boolean verifyOrderDisplay(String productname) {
		
		Boolean match=productnames.stream().anyMatch(product->product.getText().equalsIgnoreCase(productname));

		return match;
	

}
}
