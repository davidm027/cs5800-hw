package iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

// the mediator class
public class ChatServer {

    private final HashMap<UUID, User> users;
    private final HashMap<UUID, List<User>> blockLists;

    public ChatServer() {
        this.users = new HashMap<>();
        this.blockLists = new HashMap<>();
    }

    public HashMap<UUID, User> getUsers() {
        return this.users;
    }

    public HashMap<UUID, List<User>> getBlockLists() {
        return this.blockLists;
    }

    public void registerUser(User user) {
        if (this.userIsRegistered(user)) {
            throw new IllegalArgumentException("User is already registered.");
        }
        this.users.put(user.getId(), user);
        user.register(this);
    }

    public void unregisterUser(User user) {
        if (!this.userIsRegistered(user)) {
            throw new IllegalArgumentException("User is already registered.");
        }
        this.users.remove(user.getId());
        user.unregister();
    }

    public boolean userIsRegistered(User user) {
        return this.getUsers().containsKey(user.getId()) && this.getUsers().containsValue(user);
    }

    public void sendMessage(Message message) {
        for (User recipient : message.getRecipients()) {
            if (!this.userIsRegistered(recipient) || this.checkIfBlocked(recipient,
                    message.getSender())) {
                continue;
            }
            recipient.receiveMessage(message);
        }
        message.getSender().receiveMessage(message);
    }

    public void blockMessages(User blocker, User blockee) {
        this.getBlockLists().computeIfAbsent(blocker.getId(), _ -> new ArrayList<>());
        this.getBlockLists().get(blocker.getId()).add(blockee);
    }

    public boolean checkIfBlocked(User blocker, User blockee) {
        if (this.getBlockLists().get(blocker.getId()) != null) {
            return this.getBlockLists().get(blocker.getId()).contains(blockee);
        }
        return false;
    }

    public ChatHistory getHistory(User toCheck) {
        return toCheck.getChatHistory();
    }

    public void undoLastMessage(User user) {
        Message lastMessage = user.getChatHistory().getLastMessage();
        for (User recipient : lastMessage.getRecipients()) {
            recipient.getChatHistory().removeMessage(lastMessage);
        }
    }

}
