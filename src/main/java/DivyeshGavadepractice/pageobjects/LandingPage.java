package DivyeshGavadepractice.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DivyeshGavadepractice.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	
	

		private WebDriver driver;


		// TODO Auto-generated method stub

		public LandingPage(WebDriver driver) {
			
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver,this);
			
			
		}
		
		
		@FindBy(id="userEmail")
		WebElement username;
		
		@FindBy(id="userPassword")
		WebElement userpassword;
		
		@FindBy(id="login")
		WebElement submit;
		
		@FindBy(css="[class*='flyinOut']")
		WebElement errormessage;
		
		
		public ProductCatalogue loginapplication(String email,String password) 
		{
			username.sendKeys(email);
			userpassword.sendKeys(password);
			submit.click();
			ProductCatalogue productCatalogue=new ProductCatalogue(driver);
			return productCatalogue;
			
		}
		
		public String getErrorMessage() {
			waitforWebElementToAppeear(errormessage);
			return errormessage.getText();
			
		}
		public void GoTo() {
			driver.get("https://rahulshettyacademy.com/client");
		}
	}


