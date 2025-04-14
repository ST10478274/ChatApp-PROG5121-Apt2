package chatapp;

import java.util.Scanner;

public class ChatApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Username
        System.out.println("Enter Username:");
        String username = scanner.nextLine();

        if (!Validation.validateUsername(username)) {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return;
        }
        System.out.println("Username successfully captured.");

        //Password
        System.out.println("Enter Password:");
        String password = scanner.nextLine();

        if (!Validation.validatePassword(password)) {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            return;
        }
        System.out.println("Password captured successfully.");

        //Phone
        System.out.println("Enter South African Phone Number (e.g., +27XXXXXXXXX):");
        String phoneNumber = scanner.nextLine();

        if (!Validation.isValidSAPhoneNumber(phoneNumber)) {
            System.out.println("Cellphone number incorrectly formatted or does not contain international code.");
        } else {
        System.out.println("Cell phone number successfully added.");

        // Step 4: Account creation
        Account account = new Account(username, password, phoneNumber);
        System.out.println("Account created successfully!");

        // Step 5: Authentication
        System.out.println("Enter Username for Login:");
        String enteredUsername = scanner.nextLine();

        System.out.println("Enter Password for Login:");
        String enteredPassword = scanner.nextLine();

    if (account.getUsername().equals(enteredUsername) && account.getPassword().equals(enteredPassword)) {
        System.out.println("Welcome " + enteredUsername + ", it is great to see you again.");
            } else {
        System.out.println("Username or password incorrect, please try again.");
        }
      }
    }
}
