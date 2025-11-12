package memento_mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatHistory {

    private final List<Message> history;
    private MessageMemento memento;

    public ChatHistory() {
        this.history = new ArrayList<>();
        this.memento = null;
    }

    public void addMessageToHistory(Message message) {
        if (!this.isEmpty()) {
            this.history.addLast(this.getLastMessage());
        }
        if (this.memento == null) {
            this.memento = new MessageMemento(message);
        } else {
            memento.setState(message);
        }
    }

    public Message getLastMessage() {
        if (this.memento != null) {
            return this.memento.getAsMessage();
        }
        return null;
    }

    public boolean isEmpty() {
        return this.history.isEmpty();
    }

    public void removeMessage(Message message) {
        if (this.memento != null) {
            this.history.removeIf(m -> m == message);
        }
    }

    public void removeLastMessage() {
        if (!this.isEmpty()) {
            this.memento.setState(this.history.removeLast());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("--- MESSAGES ---\n");
        for (Message m : this.history) {
            sb.append(m.toString()).append('\n');
        }
        sb.append(this.memento.getAsMessage().toString()).append('\n');
        return sb.toString();
    }

}
