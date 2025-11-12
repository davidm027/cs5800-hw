package memento_mediator.mocks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistoryMock {

    private final List<MessageMock> history;
    private MessageMementoMock memento;

    public ChatHistoryMock() {
        this.history = new ArrayList<>();
        this.memento = null;
    }

    public void addMessageToHistory(MessageMock message) {
        if (!this.isEmpty()) {
            this.history.addLast(this.getLastMessage());
        }
        if (this.memento == null) {
            this.memento = new MessageMementoMock(message);
        } else {
            memento.setState(message);
        }
    }

    public MessageMock getLastMessage() {
        if (this.memento != null) {
            return this.memento.getAsMessage();
        }
        return null;
    }

    public boolean isEmpty() {
        return this.history.isEmpty();
    }

    public void removeMessage(MessageMock message) {
        if (this.memento != null) {
            this.history.removeIf(m -> m == message);
        }
    }

    public void removeLastMessage() {
        if (!this.isEmpty()) {
            this.memento.setState(this.history.removeLast());
        }
    }

}
