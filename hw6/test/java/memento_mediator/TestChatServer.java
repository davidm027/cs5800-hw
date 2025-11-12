package memento_mediator;

import memento_mediator.mocks.ChatHistoryMock;
import memento_mediator.mocks.ChatServerMock;
import memento_mediator.mocks.MessageMock;
import memento_mediator.mocks.UserMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestChatServer {

    UserMock user1;
    UserMock user2;
    UserMock user3;
    ChatServerMock server;

    @BeforeEach
    void setup() {
        user1 = new UserMock("davidmalone");
        user2 = new UserMock("alice_b");
        user3 = new UserMock("bob_a");
        server = new ChatServerMock();
    }

    @Test
    void testRegisterUser() {
        server.registerUser(user1);
        assertTrue(server.userIsRegistered(user1));
        assertEquals(server, user1.getServer());
    }

    @Test
    void testRegisterUserAlreadyRegistered() {
        server.registerUser(user1);
        assertThrows(IllegalArgumentException.class, () -> server.registerUser(user1));
    }

    @Test
    void testUnregisterUser() {
        server.registerUser(user1);
        server.unregisterUser(user1);
        assertFalse(server.userIsRegistered(user1));
        assertNull(user1.getServer());
    }

    @Test
    void testUnregisterUserWhoDoesntExist() {
        assertThrows(IllegalArgumentException.class, () -> server.unregisterUser(user1));
    }

    @Test
    void testSendMessageSingleRecipient() {
        server.registerUser(user1);
        server.registerUser(user2);
        Instant message1Instant = Instant.parse("2025-10-29T12:09:00.00-07:00");
        MessageMock expectedMessage = new MessageMock(message1Instant, "Hello world!", user1,
                user2);
        user1.sendMessageTo(message1Instant, "Hello world!", user2);
        MessageMock actualMessage = user2.getChatHistory().getLastMessage();
        assertEquals(expectedMessage.toString(), actualMessage.toString());
    }

    @Test
    void testSendMessageMultipleRecipients() {
        server.registerUser(user1);
        server.registerUser(user2);
        server.registerUser(user3);
        Instant message2Instant = Instant.parse("2025-10-30T12:09:00.00-07:00");
        MessageMock expectedMessageUser1 = new MessageMock(message2Instant, "Hello to all!", user2,
                user1, user3);
        MessageMock expectedMessageUser3 = new MessageMock(message2Instant, "Hello to all!", user2,
                user1, user3);
        List<String> expectedMessages = Arrays.asList(expectedMessageUser1.toString(),
                expectedMessageUser3.toString());
        user2.sendMessageTo(message2Instant, "Hello to all!", user1, user3);
        List<String> actualMessages = new ArrayList<>();
        actualMessages.add(user1.getChatHistory().getLastMessage().toString());
        actualMessages.add(user3.getChatHistory().getLastMessage().toString());
        assertIterableEquals(expectedMessages, actualMessages);
    }

    @Test
    void testBlockUser() {
        server.registerUser(user1);
        server.registerUser(user2);
        user2.blockMessagesFrom(user1);
        assertTrue(server.checkIfBlocked(user2, user1));
    }

    @Test
    void testSendMessageToBlockedSender() {
        server.registerUser(user1);
        server.registerUser(user2);
        Instant messageInstant = Instant.parse("2025-10-29T12:09:00.00-07:00");
        user2.blockMessagesFrom(user1);
        user1.sendMessageTo(messageInstant, "Hello world!", user2);
        assertTrue(user2.getChatHistory().isEmpty());
    }

    @Test
    void getChatHistory() {
        server.registerUser(user1);
        server.registerUser(user2);
        Instant message1Instant = Instant.parse("2025-10-29T12:09:00.00-07:00");
        MessageMock expectedMessage = new MessageMock(message1Instant, "Hello world!", user1,
                user2);
        ChatHistoryMock expectedHistory = new ChatHistoryMock();
        expectedHistory.addMessageToHistory(expectedMessage);
        user1.sendMessageTo(message1Instant, "Hello world!", user2);
        ChatHistoryMock actualHistory = user1.getChatHistoryOf(user2);
        assertEquals(expectedHistory.getLastMessage().toString(), actualHistory.getLastMessage().toString());
    }

    @Test
    void testUndoLastMessage() {
        server.registerUser(user1);
        server.registerUser(user2);
        Instant message1Instant = Instant.parse("2025-10-29T12:09:00.00-07:00");
        user1.sendMessageTo(message1Instant, "Hello world!", user2);
        MessageMock expectedMessage = new MessageMock(message1Instant, "Hello world!", user1,
                user2);
        MessageMock actualMessage1 = user1.getChatHistory().getLastMessage();
        MessageMock actualMessage2 = user2.getChatHistory().getLastMessage();
        assertEquals(expectedMessage.toString(), actualMessage1.toString());
        assertEquals(expectedMessage.toString(), actualMessage2.toString());
        user1.undoLastMessage();
        assertTrue(user1.getChatHistory().isEmpty());
        assertTrue(user2.getChatHistory().isEmpty());
    }

}