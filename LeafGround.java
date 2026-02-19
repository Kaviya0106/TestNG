package leafgroundtask;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LeafGround {
	WebDriver driver;

	@BeforeMethod
	public void setup() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/input.xhtml");
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

	// Test Case 1- Verify user can enter name
	@Test
	public void EnterName() {
		WebElement nameBox = driver.findElement(By.id("j_idt88:name"));
		nameBox.sendKeys("TestLeaf");

		System.out.println("Entered name: " + nameBox.getAttribute("value"));// the namebox text "TestLeaf" should be
																				// print
	}

	// Test Case 2- Append Country textbox
	@Test
	public void AppendCountry() {
		WebElement countrybox = driver.findElement(By.id("Append Country” textbox"));
		countrybox.sendKeys("India");
		System.out.println("Append Country Name: " + countrybox.getAttribute("value"));

	}

	// Test Case 3: Disabled Textbox
	@Test
	public void testDisabledTextbox() {
		WebElement disabledBox = driver.findElement(By.id("j_idt88:j_idt93"));
		System.out.println("Is disabled: " + !disabledBox.isEnabled());
	}

	// Test Case 4: Clear Textbox
	@Test
	public void testClearTextbox() {
		WebElement clearBox = driver.findElement(By.id("j_idt88:j_idt95"));
		clearBox.sendKeys("Some text"); // Add initial text
		clearBox.clear();
		System.out.println("After clear, value: " + clearBox.getAttribute("value"));
	}

	// Test Case 6: TAB Functionality
	@Test
	public void testTabFunction() {
		WebElement emailBox = driver.findElement(By.id("j_idt88:j_idt99"));
		emailBox.sendKeys("test@mail.com");
		emailBox.sendKeys(Keys.TAB);
		WebElement nextField = driver.switchTo().activeElement();
		System.out.println("Active element after TAB: " + nextField.getTagName());
	}

	// Test Case 9: Mandatory Age Validation
	@Test
	public void testAgeValidation() {
		WebElement ageBox = driver.findElement(By.id("j_idt106:thisform:age"));
		ageBox.sendKeys(Keys.ENTER);
		WebElement errorMsg = driver.findElement(By.className("ui-message-error-detail"));
		System.out.println("Error displayed: " + errorMsg.isDisplayed());
	}

}
