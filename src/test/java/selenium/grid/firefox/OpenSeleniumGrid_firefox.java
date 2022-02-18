package selenium.grid.firefox;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenSeleniumGrid_firefox {

	
	public RemoteWebDriver driver;

	public static String appURL = "https://www.swiggy.com/";

	@BeforeClass
	public void setUp() throws MalformedURLException {

		DesiredCapabilities descaps = DesiredCapabilities.firefox();
		driver = new RemoteWebDriver(new URL(" http://192.168.56.1:4444/wd/hub"), descaps);
		driver.manage().window().maximize();

	}

	@Test
	public void clickOnCityName() {

		driver.get(appURL);
		driver.findElementByLinkText("Delhi").click();
	}

	@Test
	public void clickOnSignIn() {

		driver.findElementByXPath("//*[@id=\"root\"]/div[1]/header/div/div/ul/li[2]/div/span[2]").click();

	}

	@Test
	public void enterPhoneNumber() throws InterruptedException {

		driver.findElementByName("mobile").sendKeys("2083105978");
		Thread.sleep(2000);

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
