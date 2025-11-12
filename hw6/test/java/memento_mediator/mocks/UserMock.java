package memento_mediator.mocks;

import java.time.Instant;
import java.util.UUID;

public class UserMock {

    private final UUID id;
    private final String username;
    private ChatServerMock server;
    private final ChatHistoryMock chatHistory;

    public UserMock(String username) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.server = null;
        this.chatHistory = new ChatHistoryMock();
    }

    public String getUsername() {
        return this.username;
    }

    public UUID getId() {
        return this.id;
    }

    public ChatServerMock getServer() {
        return this.server;
    }

    public ChatHistoryMock getChatHistory() {
        return this.chatHistory;
    }

    public void register(ChatServerMock chatServer) {
        this.server = chatServer;
    }

    public void unregister() {
        this.server = null;
    }

    public void sendMessageTo(Instant instant, String messageContents, UserMock... recipients) {
        MessageMock message = new MessageMock(instant, messageContents, this, recipients);
//        this.getServer().sendMessage(instant, message, this, recipients);
        this.getServer().sendMessage(message);
//        this.getChatHistory().addMessageToHistory(message);
    }

    public void receiveMessage(MessageMock message) {
        this.getChatHistory().addMessageToHistory(message);
    }

    public void undoLastMessage() {
        this.getServer().undoLastMessage(this);
        this.getChatHistory().removeLastMessage();
    }

    public void blockMessagesFrom(UserMock user) {
        this.getServer().blockMessages(this, user);
    }

    public ChatHistoryMock getChatHistoryOf(UserMock user) {
        return this.server.getHistory(user);
    }

}
