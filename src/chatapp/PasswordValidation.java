package chatapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidation {
    // Method to validate password complexity
    public static boolean isPasswordValid(String password) {
        // Expression to check password complexity
        String regex = "^\\+27\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Example password
        String password = "Password123!";

        // Validate the password and print the result
        if (isPasswordValid(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
    }
}

