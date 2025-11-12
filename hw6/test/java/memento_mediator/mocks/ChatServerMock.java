package memento_mediator.mocks;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

// the mediator class
public class ChatServerMock {

    private final HashMap<UUID, UserMock> users;
    private final HashMap<UUID, List<UserMock>> blockLists;

    public ChatServerMock() {
        this.users = new HashMap<>();
        this.blockLists = new HashMap<>();
    }

    public HashMap<UUID, UserMock> getUsers() {
        return this.users;
    }

    public HashMap<UUID, List<UserMock>> getBlockLists() {
        return this.blockLists;
    }

    public void registerUser(UserMock user) {
        if (this.userIsRegistered(user)) {
            throw new IllegalArgumentException("User is already registered.");
        }
        this.users.put(user.getId(), user);
        user.register(this);
    }

    public void unregisterUser(UserMock user) {
        if (!this.userIsRegistered(user)) {
            throw new IllegalArgumentException("User is already registered.");
        }
        this.users.remove(user.getId());
        user.unregister();
    }

    public boolean userIsRegistered(UserMock user) {
        return this.getUsers().containsKey(user.getId()) && this.getUsers().containsValue(user);
    }

    public void sendMessage(Instant instant, String messageContent, UserMock sender,
                            UserMock... recipients) {
        MessageMock message = new MessageMock(instant, messageContent, sender, recipients);
        for (UserMock recipient : recipients) {
            if (!this.userIsRegistered(recipient) || this.checkIfBlocked(recipient,
                    sender)) {
                continue;
            }
            recipient.receiveMessage(message);
        }
    }

    public void sendMessage(MessageMock message) {
        for (UserMock recipient : message.getRecipients()) {
            if (!this.userIsRegistered(recipient) || this.checkIfBlocked(recipient,
                    message.getSender())) {
                continue;
            }
            recipient.receiveMessage(message);
        }
        message.getSender().receiveMessage(message);
    }

    public void blockMessages(UserMock blocker, UserMock blockee) {
        this.getBlockLists().computeIfAbsent(blocker.getId(), _ -> new ArrayList<>());
        this.getBlockLists().get(blocker.getId()).add(blockee);
    }

    public boolean checkIfBlocked(UserMock blocker, UserMock blockee) {
        if (this.getBlockLists().get(blocker.getId()) != null) {
            return this.getBlockLists().get(blocker.getId()).contains(blockee);
        }
        return false;
    }

    public ChatHistoryMock getHistory(UserMock toCheck) {
        return toCheck.getChatHistory();
    }

    public void undoLastMessage(UserMock user) {
        MessageMock lastMessage = user.getChatHistory().getLastMessage();
        for (UserMock recipient : lastMessage.getRecipients()) {
            recipient.getChatHistory().removeMessage(lastMessage);
        }
    }

}
