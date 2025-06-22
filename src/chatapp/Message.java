package chatapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Message {
    private static int totalMessages = 0;
    private static final List<Message> sentMessages = new ArrayList<>();

    private final String messageId;
    private final String messageHash;
    private final String recipient;
    private final String content;
    private boolean isSent;
    private boolean isStored;

    public Message(String recipient, String content) {
        this.messageId = generateMessageId();
        this.recipient = recipient;
        this.content = content;
        this.isSent = false;
        this.isStored = false;
        this.messageHash = generateMessageHash();
        totalMessages++;
    }

    Message(String string, String developer, String string0, String did_you_get_the_cake, String stored) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean checkMessageId() {
        return this.messageId.length() <= 10;
    }

    public int checkRecipientCell() {
        if (recipient.startsWith("+27") && recipient.length() == 12) {
            return 1; 
        } else if (recipient.length() == 10 && recipient.startsWith("0")) {
            return 2; 
        }
        return 0; 
    }

    
    public String createMessageHash() {
        String[] words = this.content.split(" ");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 1 ? words[words.length - 1] : firstWord;

        return (messageId.substring(0, 2) + ":" + totalMessages + ":" +
               firstWord.toUpperCase() + lastWord.toUpperCase());
    }

    public String sendMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Send Message");
        System.out.println("2. Disregard Message");
        System.out.println("3. Store Message to send later");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                this.isSent = true;
                totalMessages++;
                sentMessages.add(this);
                return "Message successfully sent.";
            }
            case 2 -> {
                return "Press 0 to delete message.";
            }
            case 3 -> {
                this.isStored = true;
                storeMessage();
                return "Message successfully stored.";
            }
            default -> {
                return "Invalid option selected.";
            }
        }
    }

    public void storeMessage() {
        JSONObject jsonMessage = new JSONObject();
        jsonMessage.put("messageId", this.messageId);
        jsonMessage.put("recipient", this.recipient);
        jsonMessage.put("content", this.content);
        jsonMessage.put("hash", this.messageHash);

        System.out.println("Message stored in JSON format: " + jsonMessage.toString());
    }


    private String generateMessageId() {
        return String.format("%010d", (int)(Math.random() * 10000000000L));
    }

    public static String printMessages() {
        StringBuilder sb = new StringBuilder();
        for (Message msg : sentMessages) {
            sb.append("ID: ").append(msg.messageId)
              .append(", Hash: ").append(msg.messageHash)
              .append(", Recipient: ").append(msg.recipient)
              .append(", Content: ").append(msg.content)
              .append("\n");
        }
        return sb.toString();
    }

    public static int returnTotalMessages() {
        return totalMessages;
    }

    public String getMessageId() { return messageId; }
    public String getMessageHash() { return messageHash; }
    public String getRecipient() { return recipient; }
    public String getContent() { return content; }
    public boolean isSent() { return isSent; }
    public boolean isStored() { return isStored; }

    private String generateMessageHash() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    String getHash() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getSender() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getFlag() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
