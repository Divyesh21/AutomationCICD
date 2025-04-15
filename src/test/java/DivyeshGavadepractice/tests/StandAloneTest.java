package DivyeshGavadepractice.tests;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import DivyeshGavadepractice.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {

		System.out.println("New line of code added");

		WebDriverManager.chromedriver().setup();
		//WebDriver driver =new ChromeDriver();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		String productname="ZARA COAT 3";
		
		LandingPage landingpage=new LandingPage(driver);
		
		
		driver.findElement(By.id("userEmail")).sendKeys("divyeshdg21@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("@Lacazette9");
		driver.findElement(By.id("login")).click();
		
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod=products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating"))) ;
		
		
		driver.findElement(By.cssSelector("[routerlink=\"/dashboard/cart\"]")).click();
		List <WebElement> cartproducts=driver.findElements(By.cssSelector(".cartSection h3"));


		
		Boolean match=cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));
		//Assert.assertTrue(match);
		driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
		
		Actions a=new Actions(driver); 
		
		a.sendKeys(driver.findElement(By.cssSelector("[ placeholder=\"Select Country\"] ")),"india").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String confirmmsg=driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		assertEquals(confirmmsg," Thankyou for the order. ");
		
		
		assertTrue(confirmmsg.equalsIgnoreCase("Thankyou for the order. ")) ;
		
		
		
		
	}

}
