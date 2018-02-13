package FinalTest;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import pageObjects.Browser;

public class FinalTest {


	@Before
	public void setUp() throws Throwable {
		Browser.start();
		Browser.goTo();
		Browser.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		Browser.stop();
	}

	@Test
	public void testElements() {
		WebElement ContactUs = Browser.driver.findElement(By.linkText("Contact Us"));
		assertEquals("Contact Us", ContactUs.getText());

		WebElement Returns = Browser.driver.findElement(By.linkText("Returns"));
		assertEquals("Returns", Returns.getText());

		WebElement SiteMap = Browser.driver.findElement(By.linkText("Site Map"));
		assertEquals("Site Map", SiteMap.getText());

		ContactUs.click();

		WebElement Name = Browser.driver.findElement(By.id("input-name"));
		Name.sendKeys("Silviya");
		WebElement Email = Browser.driver.findElement(By.id("input-email"));
		Email.sendKeys("silviya.ivanova89@gmail.com");
		WebElement Enquiry = Browser.driver.findElement(By.id("input-enquiry"));
		Enquiry.sendKeys("Hello, how are you?");
		WebElement Submit = Browser.driver.findElement(By.xpath("//input[@ type='submit']"));
		Submit.click();
	}
}
