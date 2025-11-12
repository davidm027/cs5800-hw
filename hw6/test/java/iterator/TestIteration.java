package iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIteration {

    User user1;
    User user2;
    ChatServer server;

    @BeforeEach
    void setup() {
        user1 = new User("alice_b");
        user2 = new User("bob_a");
        server = new ChatServer();
    }

    @Test
    void testIteration() {
        server.registerUser(user1);
        server.registerUser(user2);
        user1.sendMessageTo("Hello!", user2);
        user1.sendMessageTo("My second message to you!", user2);
        user1.sendMessageTo("My third message to you!", user2);
        user2.sendMessageTo("Hello to you!", user1);
        user2.sendMessageTo("How are you?", user1);
        Iterator iter = user1.iterator(user2);
        int count = 0;
        while (iter.hasNext()) {
            iter.next();
            count++;
        }
        assertEquals(5, count);
    }

}
