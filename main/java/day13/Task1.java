package day13;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        User user1 = new User("Ivan");
        User user2 = new User("Alex");
        User user3 = new User("Oleg");

        System.out.println(user2);
        user2.subscribe(user1);
        user2.subscribe(user3);
        System.out.println(user2);

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

        System.out.println(MessageDatabase.getMessages());
        MessageDatabase.showDialog(user1, user2);
        MessageDatabase.showDialog(user3, user1);
    }
}

class User {
    private String userName;
    private List<User> subscriptions;
    private List<String> friends;

    public User(String userName) {
        this.userName= userName;
        this.subscriptions = new ArrayList<>();
    }

    public String getUserName() { return userName; }
    public List<User> getSubscriptions() { return subscriptions; }

    public void subscribe(User user) { if(isSubscribed(user)) { this.subscriptions.add(user); } }

    public boolean isSubscribed(User user) {
        for(User i: subscriptions) {
            if(user.equals(i)) {
                System.out.println("Пользаватель " + this.userName + " уже подписана на пользавателя " + user.getUserName());
                return false;
            }
        }
        return true;
    }

    public boolean isFriend(User user) {
        return true;//Этот метод реализуется и список инициализируется точно также как и метод isSubscribed.
        // Наличие или отсутствие таковой включает(или выключает) фильтры на доступ к информации пользователя.
    }

    public void sendMessage(User user, String text) {
        MessageDatabase.addNewMessages( this , user, text);
    }

    public String toString() { return userName + subscriptions; }
}

class Message {
    private User sender;
    private User receiver;
    private String text;
    private Calendar calendar;

    public Message(User sender, User receiver, String text) {
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
        this.calendar = new GregorianCalendar();
    }

    public User getSender() { return sender; }
    public User getReceiver() { return receiver; }
    public String getText() { return text; }
    public Calendar getCalendar() { return calendar; }

    public String toString() {
        return "\n FROM: " + this.sender +
                "\n   TO: " + this.receiver +
                "\n   ON: " + calendar.getTime() +
                "\n" + this.text;
    }

}

class MessageDatabase {
    static List<Message> messages = new ArrayList<>();

    public static void addNewMessages(User u1, User u2, String text) { messages.add(new Message(u1, u2, text)); }

    public static List<Message> getMessages() { return messages; }

    public static void showDialog(User u1, User u2) {
        for(Message i: messages) {
            if(i.getSender().equals(u1) && i.getReceiver().equals(u2)) { System.out.println(u1.getUserName() + ": " + i.getText()); }
            if(i.getSender().equals(u2) && i.getReceiver().equals(u1)) { System.out.println(u2.getUserName() + ": " + i.getText()); }
        }
    }

}
