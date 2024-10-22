package testpack; // Ensure this matches your directory structure

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjectpage.BasePage;
import pageobjectpage.RandomStringGenerator;
import pageobjectpage.SignUpPage;

public class Signupwithcaseload {

    BasePage basePage;
    WebDriver driver;
    SignUpPage sp;

    // Default constructor is implicitly present

    @BeforeClass
    public void setUp() {
        basePage = new BasePage("chrome");  // Pass the browser type to BasePage constructor
        driver = basePage.getDriver(); // Get the initialized driver
        driver.manage().window().maximize(); // Maximize the window
        basePage.navigateToUrl("https://www.ablespace.io"); // Navigate to the URL
     // Set implicit wait for 5 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        sp = new SignUpPage(driver); // Initialize SignUpPage with the driver
    }

    @Test(priority = 1)
    public void testSignUpFlow() {
        // Perform the sign-up process
        try {
        	// Generating random email, name, and password
            String randomEmail = RandomStringGenerator.generateRandomEmail();
            String randomName = RandomStringGenerator.generateRandomName();
            String randomPassword = RandomStringGenerator.generateRandomPassword();
            
            // Print out generated values (for debugging purposes)
            System.out.println("Generated Email: " + randomEmail);
            System.out.println("Generated Name: " + randomName);
            System.out.println("Generated Password: " + randomPassword);

            System.out.println("Signing up with email...");
            sp.signUpWithEmail(randomEmail); // Using generated random email
            System.out.println("Signed In...");
            
            // Enter the random name and password into the signup form
            sp.enterSignUpDetails(randomName, "Occupational Therapist", randomPassword);
            System.out.println("Details Done...");
            

        } catch (Exception e) {
            System.err.println("Error during sign-up: " + e.getMessage());
            e.printStackTrace();
        }
    }

   @AfterClass
   public void tearDown() {
       basePage.closeBrowser(); // Close the browser after tests   }
   }
}
