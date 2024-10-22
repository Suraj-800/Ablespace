package pageobjectpage;

import java.util.Random;

public class RandomStringGenerator {

    // Method to generate random email
    public static String generateRandomEmail() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder email = new StringBuilder();
        Random random = new Random();
        
        for (int i = 0; i < 10; i++) { // Generate a 10-character random string
            email.append(characters.charAt(random.nextInt(characters.length())));
        }
        
        return email.toString() + "@gmail.com"; // Append email domain
    }

    // Method to generate random name
    public static String generateRandomName() {
        String[] names = {"John", "Jane", "Alex", "Chris", "Taylor", "Jordan", "Casey", "Drew"};
        Random random = new Random();
        return names[random.nextInt(names.length)] + " User";
    }

    // Method to generate random password
    public static String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        
        for (int i = 0; i < 8; i++) { // Generate an 8-character random string
            password.append(characters.charAt(random.nextInt(characters.length())));
        }
        
        return password.toString();
    }
}
