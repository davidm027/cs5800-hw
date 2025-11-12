package memento_mediator;

import memento_mediator.mocks.MessageMock;
import memento_mediator.mocks.UserMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestMessageMetadata {

    UserMock user1;
    UserMock user2;
    UserMock user3;
    MessageMock messageSingleRecipient;
    MessageMock messageMultipleRecipients;

    @BeforeEach
    void setup() {
        user1 = new UserMock("davidmalone");
        user2 = new UserMock("alice_b");
        user3 = new UserMock("bob_a");
        Instant message1Instant = Instant.parse("2025-10-29T12:09:00.00-07:00");
        Instant message2Instant = Instant.parse("2025-10-30T12:09:00.00-07:00");
        messageSingleRecipient = new MessageMock(message1Instant, "Hello world!", user1, user2);
        messageMultipleRecipients = new MessageMock(message2Instant, "Hello to all!", user2,
                user1, user3);
    }

    @Test
    void testGetSender() {
        UserMock expected = user1;
        UserMock actual = messageSingleRecipient.getSender();
        assertEquals(expected, actual);
    }

    @Test
    void testGetRecipientsSingleRecipient() {
        UserMock expected = user2;
        UserMock actual = messageSingleRecipient.getRecipients()[0];
        assertEquals(expected, actual);
    }

    @Test
    void testGetRecipientsMultipleRecipients() {
        List<String> expected = new ArrayList<>(List.of(user1.getUsername(),
                user3.getUsername()));
        List<String> actual =
                Arrays.stream(messageMultipleRecipients.getRecipients()).map(UserMock::getUsername).toList();
        assertTrue(expected.containsAll(actual));
    }

    @Test
    void testGetTimestamp() {
        String expected = Instant.parse("2025-10-29T12:09:00.00-07:00").toString();
        String actual = messageSingleRecipient.getTimestamp().toString();
        assertEquals(expected, actual);
    }

    @Test
    void testGetMessageContents() {
        String expected = "Hello to all!";
        String actual = messageMultipleRecipients.getMessageContents();
        assertEquals(expected, actual);
    }

    @Test
    void testToStringSingleRecipient() {
        String expected = """
                FROM: davidmalone
                TO: alice_b
                DATE: Wednesday, October 29, 2025 at 12:09PM
                CONTENT: 'Hello world!'""";
        String actual = messageSingleRecipient.toString();
        assertEquals(expected, actual);
    }

    @Test
    void testToStringMultipleRecipients() {
        String expected = """
                FROM: alice_b
                TO: davidmalone, bob_a
                DATE: Thursday, October 30, 2025 at 12:09PM
                CONTENT: 'Hello to all!'""";
        String actual = messageMultipleRecipients.toString();
        assertEquals(expected, actual);
    }

}