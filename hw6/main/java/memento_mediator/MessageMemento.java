package memento_mediator;

import java.time.Instant;

public class MessageMemento {

    private Instant timestamp;
    private String messageContents;
    private User sender;
    private User[] recipients;

    public MessageMemento(Message message) {
        this.timestamp = message.getTimestamp();
        this.messageContents = message.getMessageContents();
        this.sender = message.getSender();
        this.recipients = message.getRecipients();
    }

    public void setState(Message message) {
        this.timestamp = message.getTimestamp();
        this.messageContents = message.getMessageContents();
        this.sender = message.getSender();
        this.recipients = message.getRecipients();
    }

    public Message getAsMessage() {
        return new Message(this.messageContents, this.sender,
                this.recipients);
    }

}
