package com.orangeHRM.cucumber.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {
	public ChromeDriver cd;
	@Given ("Open the browser and launch OrangeHRM application using {string}")
	
	public void launchApp(String url) {
		cd = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
		cd.get(url);
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	@Given("Enter username as {string}")
	public void enterUsername(String username) {
		cd.findElement(By.name("username")).sendKeys(username);
	}
	@And("Enter password as {string}")
	public void enterPassword(String password) {
		cd.findElement(By.name("password")).sendKeys(password);
	}
	@When("Click on Submit button")
	public void clickSubmitButton() {
		cd.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Then("Verify the Dashboard page is Loaded.")////h6[text()='Dashboard']
	public void verifySuccessMessage() {
		  String actualText = cd.findElement(By.tagName("h6")).getText();
		    Assert.assertEquals(actualText, "Dashboard",
		            "Dashboard page was not loaded");
		
		if(cd.findElement(By.tagName("h6")).getText().contains("Dashboard")) {
			System.out.println("Dashboard page is Loaded.");
		}else {
			System.out.println("Dashboard page is not Loaded.");
		}
	}
	@But("Verify the \"required\" message in the login page.")
	public void passwordError() {
		String text = cd.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'])[1]")).getText();
		if(text.equalsIgnoreCase("Required")){
			System.out.println("Required message is Displaed");
		}else {
			System.out.println("Required message is not Displaed");
		}
	}
		
		@But("Verify the error message in the login page.")
		public void invalidCredentials() {
			String text = cd.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
			if(text.equalsIgnoreCase("Invalid credentials")){
				System.out.println("Error message is Displaed");
			}else {
				System.out.println("Error message is not Displaed");
			}
	}
		@After
		public void closeBrowser() {
		    if (cd != null) {
		        cd.quit();
		    }
		}

}
