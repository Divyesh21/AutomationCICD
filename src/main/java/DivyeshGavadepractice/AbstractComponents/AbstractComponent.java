package DivyeshGavadepractice.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import DivyeshGavadepractice.pageobjects.CartPage;

public class AbstractComponent {

	WebDriver driver;
	
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartheader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderheader;
 
	public void waitforElementToAppear(By findBy) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
public void waitforWebElementToAppeear(WebElement findBy) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public CartPage GoToCartPage() {
		
		WebElement element = driver.findElement(By.cssSelector("[routerlink*='cart']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		cartheader.click();
		CartPage cartPage=new  CartPage(driver);
		return cartPage;
		

	}
	public OrderPage goToOrdersPage() {
		
		orderheader.click();
		OrderPage oerderPage= new OrderPage(driver);
		
		return oerderPage;
	}

		
	public void waitforelementtoDisappear(WebElement ele) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.invisibilityOf(ele)) ;
		driver.findElement(By.cssSelector("[routerlink=\"/dashboard/cart\"]")).click();
		
	}
	
	
}
