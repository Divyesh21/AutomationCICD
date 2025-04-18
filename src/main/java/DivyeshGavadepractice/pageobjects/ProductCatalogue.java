package DivyeshGavadepractice.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DivyeshGavadepractice.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{

	
	

		private WebDriver driver;


		// TODO Auto-generated method stub

		public ProductCatalogue(WebDriver driver) {
			
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver,this);
			
			
		}
		
		
		@FindBy(css = ".mb-3")
		List<WebElement> products;
		
		@FindBy(css = ".ng-animating")
		WebElement spinner;

		By productsBy = By.cssSelector(".mb-3");
		By addToCart = By.cssSelector(".card-body button:last-of-type");
		By toastMessage = By.cssSelector("#toast-container");

	
	
	public List<WebElement> getProductList() {	
		waitforElementToAppear(productsBy);
		return products;
		
	}
	
	public WebElement getProductByName(String productname) {
		
		WebElement prod=products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductoCart(String productname)throws InterruptedException {
		
	
		WebElement prod=getProductByName( productname);
		prod.findElement(addToCart).click();
		waitforElementToAppear(toastMessage);
		waitforelementtoDisappear(spinner);
		
		
	}
	
	
	
}