package day13;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        User user1 = new User("Ivan");
        User user2 = new User("Alex");
        User user3 = new User("Oleg");

        user2.subscribe(user1);
        user2.subscribe(user3);
        user3.subscribe(user2);
        System.out.println(user1.getSubscriptions());
        System.out.println(user2.getSubscriptions());
        System.out.println(user3.getSubscriptions());

        user1.sendMessage(user2, "Привет.");
        user1.sendMessage(user2, "Что делаешь?");
        user2.sendMessage(user1, "Привет.");
        user2.sendMessage(user1, "Кушаю.");
        user2.sendMessage(user1, "А ты чем занят?");
        user3.sendMessage(user1, "Здравствуйте Иван.");
        user3.sendMessage(user1, "Нам надо встретится.");
        user3.sendMessage(user1, "Вы завтра сможете?");
        user1.sendMessage(user3, "Здравствуйте Олег.");
        user1.sendMessage(user3, "Когда?");
        user1.sendMessage(user3, "Хорошо, давайте завтра.");
        user3.sendMessage(user1, "Договорились. До встречи.");

        MessageDatabase.showDialog(user1, user2);
        MessageDatabase.showDialog(user3, user1);
    }
}


class User {
    private String userName;
    private List<User> subscriptions;
    private List<User> friends;

    public User(String userName) {
        this.userName= userName;
        this.subscriptions = new ArrayList<>();
        this.friends = new ArrayList<>();
    }

    public String getUserName() { return userName; }
    public List<User> getSubscriptions() { return subscriptions; }
    public List<User> getFriends() { return friends; }

    public void subscribe(User user) {
        if(!isSubscribed(user)) {
            this.subscriptions.add(user);
        } else {
            System.out.println("Пользаватель " + this.userName + " уже подписана на пользавателя " + user.getUserName());

        }
        if(!isFriend(user) && isSubscribed(user) && user.isSubscribed(this)) { this.friends.add(user); }
    }

    private boolean isSubscribed(User user) {
        for(User i: subscriptions) {
            if(user.equals(i)) { return true; }
        }
        return false;
    }

    public void makeFriend(User user) {
        if(!isFriend(user)) {
            if(user.isSubscribed(this) && isSubscribed(user)) { this.friends.add(user); }
        }
    }

    private boolean isFriend(User user) {
        for(User i: friends) {
            if(user.equals(i)) { return true; }
        }
        return false;
    }

    public void sendMessage(User user, String text) { MessageDatabase.addNewMessages( this , user, text); }

    public String toString() { return userName; }
}

class Message {
    private User sender;
    private User receiver;
    private String text;
    private LocalDateTime date;

    public Message(User sender, User receiver, String text) {
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
        this.date = LocalDateTime.now();
    }

    public User getSender() { return sender; }
    public User getReceiver() { return receiver; }
    public String getText() { return text; }
    public LocalDateTime getDate() { return date; }

    public String toString() {
        return "\n FROM: " + this.sender +
                "\n   TO: " + this.receiver +
                "\n   ON: " + date.toString() +
                "\n" + this.text;
    }

}

class MessageDatabase {
    static List<Message> messages = new ArrayList<>();

    public static void addNewMessages(User u1, User u2, String text) { messages.add(new Message(u1, u2, text)); }

    public static List<Message> getMessages() { return messages; }

    public static void showDialog(User u1, User u2) {
        for(Message i: messages) {
            if(i.getSender().equals(u1) && i.getReceiver().equals(u2) || i.getSender().equals(u2) && i.getReceiver().equals(u1)) {
                System.out.println(i.getSender().getUserName() + ": " + i.getText());
            }
        }
    }

}
