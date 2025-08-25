package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	WebDriver driver;

@Given("user is on the login page")
public void user_is_on_the_login_page() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.saucedemo.com/");
	String expResult="https://www.saucedemo.com/";
	String actResult=driver.getCurrentUrl();
	Assert.assertEquals(actResult, expResult);
    
}
@When("user enters username and password and click login button")
public void user_enters_username_and_password_and_click_login_button() throws InterruptedException {
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	Thread.sleep(1000);
	driver.findElement(By.name("password")).sendKeys("secret_sauce");
	Thread.sleep(1000);
	driver.findElement(By.id("login-button")).click();
	Thread.sleep(2000);
	Assert.assertTrue(true);
	

}

@Then("user validate the home page")
public void user_validate_the_home_page() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Products']")));
		Assert.assertTrue(true);
	} catch (TimeoutException te) {
		Assert.assertTrue(false);
	}
}

}
