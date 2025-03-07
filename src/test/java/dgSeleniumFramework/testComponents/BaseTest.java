package dgSeleniumFramework.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import DivyeshGavadepractice.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
		public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initiliazeDriver() throws IOException {
		
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+ 
				"//src//main//java//resources//GlobalData.properties");
		prop.load(fis);
		String browsername=System.getProperty("browser")!=null ? System.getProperty("browser") : System.getProperty("browser");
		
		if (browsername.equalsIgnoreCase("chrome")) {
		ChromeOptions options= new ChromeOptions();
		if(browsername.contains("headless")) {
		WebDriverManager.chromedriver().setup();
		options.addArguments("headless");
		

		driver=new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(1440,900));// fullscreen
		//System.out.println("reached config here");

		}
		else if (browsername.equalsIgnoreCase("firefox"))
		{
			//firefox
		}

		else if (browsername.equalsIgnoreCase("edge")) {
			
			//edge
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		
		return driver;
	}
		return driver;
	}
	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {
		
		driver=initiliazeDriver();
		landingPage=new LandingPage(driver);
		landingPage.GoTo();
		
		return landingPage;
	}
	 public String getScreenshot(String testCaseName,WebDriver driver) throws IOException{
		 
		 TakesScreenshot ts=(TakesScreenshot)driver;
		 File source=ts.getScreenshotAs(OutputType.FILE);
		 File file=new File(System.getProperty("user.dir") + "//reports//"+ testCaseName + ".png");
		 FileUtils.copyFile(source, file);
		 return System.getProperty("user.dir") + "//reports//"+ testCaseName + ".png";
		 
			 
	 }
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();

	}

}
