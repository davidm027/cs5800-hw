package memento_mediator;

public class Driver {
    
    public static void main(String[] args) {
        User user1;
        User user2;
        User user3;
        ChatServer server;
        
        user1 = new User("davidmalone");
        user2 = new User("alice_b");
        user3 = new User("bob_a");

        server = new ChatServer();
        server.registerUser(user1);
        server.registerUser(user2);
        server.registerUser(user3);

        System.out.println("Sending message to a single user...");
        user1.sendMessageTo( "Hello world!", user2);
        System.out.println(user2.getChatHistory().getLastMessage().toString());
        System.out.println();
        System.out.println("Undoing a message...");
        user1.undoLastMessage();
        System.out.println("User 1's chat history is empty? " + user1.getChatHistory().isEmpty());
        System.out.println();
        System.out.println("Blocking a user and trying to send a message...");
        user2.blockMessagesFrom(user1);
        System.out.println("User 2's most recently received message:");
        user1.sendMessageTo( "Hello, user 2!", user2);
        System.out.println(user2.getChatHistory().getLastMessage().toString());
        System.out.println();
        System.out.println("Sending message to multiple users...");
        user2.sendMessageTo( "Hello to all!", user1, user3);
        System.out.println(user3.getChatHistory().getLastMessage().toString());
        System.out.println();
        System.out.println("User 1 getting User 2's chat history...");
        System.out.println(user1.getChatHistoryOf(user2));
        System.out.println("User 1 can't find their most recent message to User 2 in User 2's " +
                "chat history. \n" +
                "Looks like they've been blocked.");
    }

}
