package chatapp;

public class Messages {
    private final String id;
    private final String hash;
    private final String sender;
    private final String recipient;
    private final String message;
    private final String flag;

    public Messages(String id, String sender, String recipient, String message, String flag) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
        this.flag = flag;
        this.hash = Integer.toHexString(message.hashCode());
    }

    public String getId() { return id; }
    public String getHash() { return hash; }
    public String getSender() { return sender; }
    public String getRecipient() { return recipient; }
    public String getMessage() { return message; }
    public String getFlag() { return flag; }

    @Override
    public String toString() {
        return "ID: " + id + ", Sender: " + sender + ", Recipient: " + recipient + ", Message: \"" + message + "\", Flag: " + flag + ", Hash: " + hash;
    }
}

