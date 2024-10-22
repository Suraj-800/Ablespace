package pageobjectpage;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignUpPage extends BasePage  {
	
	WebDriver  driver;
	
    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this); // Initialize web elements
    }
	
	
	// Web elements on the sign-up page
    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    WebElement signUpButton;

    @FindBy(xpath = "//input[contains(@placeholder,'user@example.com')]")
    WebElement email1;
    
    @FindBy(xpath ="//input[contains(@placeholder,'name@gmail.com')]")
    WebElement email2;

    @FindBy(xpath = "//button[contains(@data-sentry-component,'HttpButton')]")
    WebElement signUpWithEmailButton;

    @FindBy(xpath = "//input[@placeholder='James Musk' and @aria-label='Full Name']")
    WebElement fullNameField;  

    @FindBy(xpath = "//span[contains(text(),'Select your role')]")
    WebElement roleField;
    
    @FindBy(xpath = "//div[@role='listbox']//div[normalize-space(text())='Physical Therapist']")
    WebElement roleFieldOptions ;
    
    @FindBy(xpath = "//input[contains(@type,'password')]")
    WebElement passwordField;

    @FindBy(xpath = "//div[normalize-space()='Start for FREE']")
    WebElement startForFreeButton;

    

    public void signUpWithEmail(String email) {
    	// Click the 'Sign Up' button to open the sign-up form
        signUpButton.click();

        // Enter the email in the email field
        email1.clear();  // Clear any pre-populated value
        email1.sendKeys(email);

        // Click the 'Sign Up with Email' button to proceed
        signUpWithEmailButton.click();
	}

    

    public void enterSignUpDetails(String fullName, String role, String password) {

    	// Enter Fullname isnide Fullname field
    	fullNameField.sendKeys(fullName);
    	
    	//Click on rolefield dropdown
        roleField.click();
        
        //Select the option from dropdown 
        roleFieldOptions.click();
        
        // Enter password (ensure 8 characters)
        passwordField.sendKeys(password);

        // Click the "Start for Free" button
        startForFreeButton.click();
    }




	



}