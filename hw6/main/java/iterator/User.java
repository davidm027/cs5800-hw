package iterator;

import java.util.Iterator;
import java.util.UUID;

public class User implements IterableByUser {

    private final UUID id;
    private final String username;
    private ChatServer server;
    private final ChatHistory chatHistory;

    public User(String username) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.server = null;
        this.chatHistory = new ChatHistory();
    }

    public String getUsername() {
        return this.username;
    }

    public UUID getId() {
        return this.id;
    }

    public ChatServer getServer() {
        return this.server;
    }

    public ChatHistory getChatHistory() {
        return this.chatHistory;
    }

    public void register(ChatServer chatServer) {
        this.server = chatServer;
    }

    public void unregister() {
        this.server = null;
    }

    public void sendMessageTo(String messageContents, User... recipients) {
        Message message = new Message(messageContents, this, recipients);
        this.getServer().sendMessage(message);
    }

    public void receiveMessage(Message message) {
        this.getChatHistory().addMessageToHistory(message);
    }

    public void undoLastMessage() {
        this.getServer().undoLastMessage(this);
        this.getChatHistory().removeLastMessage();
    }

    public void blockMessageFrom(User user) {
        this.getServer().blockMessages(this, user);
    }

    public ChatHistory getChatHistoryOf(User user) {
        return this.server.getHistory(user);
    }

    @Override
    public Iterator iterator(User userToSearchWith) {
        return this.getChatHistory().iterator(userToSearchWith);
    }

}
