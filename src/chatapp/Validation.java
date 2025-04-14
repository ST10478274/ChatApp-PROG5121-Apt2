package chatapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static boolean validateUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public static boolean validatePassword(String password) {
        
        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
 /**
     * Checks if given phone number is valid South African phone number.
     * A valid South African phone number starts with '+27' followed by 9 digits.
     *
     * @param phoneNumber The phone number to validate.
     * @return `true` if the phone number is valid, `false` otherwise.
     */
    public static boolean isValidSAPhoneNumber(String phoneNumber) {
        String regex = "^\\+27\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }    
}
