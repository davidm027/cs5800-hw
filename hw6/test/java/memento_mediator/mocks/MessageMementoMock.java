package memento_mediator.mocks;

import java.time.Instant;
import java.util.Objects;

public class MessageMementoMock {

    private Instant timestamp;
    private String messageContents;
    private UserMock sender;
    private UserMock[] recipients;

    public MessageMementoMock(MessageMock message) {
        this.timestamp = message.getTimestamp();
        this.messageContents = message.getMessageContents();
        this.sender = message.getSender();
        this.recipients = message.getRecipients();
    }

    public void setState(MessageMock message) {
        this.timestamp = message.getTimestamp();
        this.messageContents = message.getMessageContents();
        this.sender = message.getSender();
        this.recipients = message.getRecipients();
    }

    public MessageMock getAsMessage() {
        return new MessageMock(this.timestamp,
                this.messageContents, this.sender,
                this.recipients);
    }

}
