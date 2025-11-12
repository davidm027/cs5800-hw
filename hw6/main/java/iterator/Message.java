package iterator;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Message {

    private final User sender;
    private final User[] recipients;
    private final Instant timestamp;
    private final String messageContents;

    public Message(String messageContents, User sender, User... recipients) {
        this.messageContents = messageContents;
        this.sender = sender;
        this.recipients = recipients;
        this.timestamp = Instant.now();
    }

    public Message(Instant timestamp, String messageContents, User sender,
                       User... recipients) {
        this.timestamp = timestamp;
        this.messageContents = messageContents;
        this.sender = sender;
        this.recipients = recipients;
    }

    public User getSender() {
        return this.sender;
    }

    public User[] getRecipients() {
        return this.recipients;
    }

    public Instant getTimestamp() {
        return this.timestamp;
    }

    public String getMessageContents() {
        return this.messageContents;
    }

    private String printRecipients() {
        StringBuilder sb = new StringBuilder();
        User lastUser = this.getRecipients()[this.getRecipients().length - 1];
        for (User user : this.getRecipients()) {
            sb.append(user.getUsername());
            if (user != lastUser) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private String printTimestamp() {
        String format = "EEEE, MMMM d, u 'at' h:mma";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format).withZone(ZoneId.systemDefault());
        return formatter.format(this.getTimestamp());
    }

    @Override
    public String toString() {
        return "FROM: " + this.getSender().getUsername() + '\n' +
                "TO: " + this.printRecipients() + '\n' +
                "DATE: " + this.printTimestamp() + '\n' +
                "CONTENT: '" + this.getMessageContents() + '\'';
    }
}
