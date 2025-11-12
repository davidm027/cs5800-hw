package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchMessagesByUser implements Iterator {

    private final List<Message> messages;
    private int index;

    public SearchMessagesByUser(User user, List<Message> messages) {
        System.out.println(messages.size());
        this.messages = processMessages(user, messages);
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return this.index >= 0 && this.index < this.messages.size();
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return this.messages.get(index++);
        }
        throw new IndexOutOfBoundsException();
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    private List<Message> processMessages(User user, List<Message> messages) {
        List<Message> me = new ArrayList<>();

        for (Message m : messages) {
            if (m.getSender() == user || List.of(m.getRecipients()).contains(user)) {
                System.out.println("Found");
                me.add(m);
            }
        }
//                messages.stream().filter(m -> m.getSender() == user || List.of(m.getRecipients()).contains(user)).toList();
        return me;
    }

}