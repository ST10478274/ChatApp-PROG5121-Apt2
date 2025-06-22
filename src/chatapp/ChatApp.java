package chatapp;

import java.util.*;

public class ChatApp {
    static ArrayList<Message> sentMessages = new ArrayList<>();
    static ArrayList<Message> disregardedMessages = new ArrayList<>();
    static ArrayList<Message> storedMessages = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Username
        System.out.println("Enter Username:");
        String username = scanner.nextLine();

        if (!Validation.validateUsername(username)) {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return;
        }
        System.out.println("Username successfully captured.");

        // Password
        System.out.println("Enter Password:");
        String password = scanner.nextLine();

        if (!Validation.validatePassword(password)) {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            return;
        }
        System.out.println("Password captured successfully.");

        // Phone
        System.out.println("Enter South African Phone Number (e.g., +27XXXXXXXXX):");
        String phoneNumber = scanner.nextLine();

        if (!Validation.isValidSAPhoneNumber(phoneNumber)) {
            System.out.println("Cellphone number incorrectly formatted or does not contain international code.");
            return;
        }
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
            return;
        }

        addTestMessages();

        // Call functions required by POE
        displayAllMessages();
        displayLongestMessage();
        searchByMessageID("4");  // Changed from "0838884567" to match test message ID
        searchByRecipient("+27838484567");
        if (!sentMessages.isEmpty()) {
            deleteMessageByHash(sentMessages.get(0).getHash());
        }
        displayFullReport();
    }

    public static void addTestMessages() {
        storedMessages.add(new Message("1", "Developer", "+27838484567", "Did you get the cake?", "Stored"));
        storedMessages.add(new Message("2", "Developer", "+27838484567", "Where are you? You are late! I have asked you to be on time.", "Stored"));
        disregardedMessages.add(new Message("3", "Developer", "+27838484567", "Yhoooo, I am at your gate.", "Disregard"));
        sentMessages.add(new Message("4", "Developer", "0838884567", "It is dinner time !", "Sent"));
        storedMessages.add(new Message("5", "Developer", "+27838484567", "Ok, I am leaving without you.", "Stored"));
    }

    public static void displayAllMessages() {
        System.out.println("\n--- All Sent Messages ---");
        for (Message msg : sentMessages) {
            System.out.println("Sender: " + msg.getSender() + ", Recipient: " + msg.getRecipient() + ", Message: " + msg.getMessage());
        }
    }

    public static void displayLongestMessage() {
        Message longest = null;
        for (Message msg : sentMessages) {
            if (longest == null || msg.getMessage().length() > longest.getMessage().length()) {
                longest = msg;
            }
        }
        if (longest != null) {
            System.out.println("\nLongest Sent Message:\n" + longest.getMessage());
        }
    }

    public static void searchByMessageID(String id) {
        System.out.println("\nSearching for Message ID: " + id);
        for (Message msg : sentMessages) {
            if (msg.getId().equals(id)) {
                System.out.println("Found: " + msg);
                return;
            }
        }
        System.out.println("Message ID not found.");
    }

    public static void searchByRecipient(String recipient) {
        System.out.println("\nMessages for Recipient: " + recipient);
        boolean found = false;
        for (Message msg : sentMessages) {
            if (msg.getRecipient().equals(recipient)) {
                System.out.println(msg.getMessage());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No messages found for this recipient.");
        }
    }

    public static void deleteMessageByHash(String hash) {
        Iterator<Message> iterator = sentMessages.iterator();
        while (iterator.hasNext()) {
            Message msg = iterator.next();
            if (msg.getHash().equals(hash)) {
                iterator.remove();
                System.out.println("\nMessage \"" + msg.getMessage() + "\" successfully deleted.");
                return;
            }
        }
        System.out.println("\nMessage with hash " + hash + " not found.");
    }

    public static void displayFullReport() {
        System.out.println("\n--- Full Sent Message Report ---");
        if (sentMessages.isEmpty()) {
            System.out.println("No sent messages to display.");
            return;
        }
        for (Message msg : sentMessages) {
            System.out.println("Message ID: " + msg.getId());
            System.out.println("Hash: " + msg.getHash());
            System.out.println("Sender: " + msg.getSender());
            System.out.println("Recipient: " + msg.getRecipient());
            System.out.println("Message: " + msg.getMessage());
            System.out.println("Flag: " + msg.getFlag());
            System.out.println("------------------------");
        }
    }
}