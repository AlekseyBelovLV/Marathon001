package day7;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random rnd = new Random();
        Player player1 = new Player(rnd.nextInt(11) + 90);
        Player player2 = new Player(rnd.nextInt(11) + 90);
        Player player3 = new Player(rnd.nextInt(11) + 90);
        Player player4 = new Player(rnd.nextInt(11) + 90);
        Player player5 = new Player(rnd.nextInt(11) + 90);
        Player player6 = new Player(rnd.nextInt(11) + 90);
        System.out.println("На поле сейчас " + Player.getCountPlayers() + " играков.");
//        Player player7 = new Player(rnd.nextInt(11) + 90);
        Player.info();
        Player.shouPlayersGroup(player1, player2, player3, player4, player5, player6);
        player2.run();
        Player.shouPlayersGroup(player1, player2, player3, player4, player5, player6);
        while(player2.getStamina() > 0) {
            player2.run();
        }
        System.out.println("На поле сейчас " + Player.getCountPlayers() + " играков.");
        Player.shouPlayersGroup(player1, player2, player3, player4, player5, player6);
        Player.info();
    }
}

class Player {
    private int stamina;
    private final int MAX_STAMINA = 100;
    private final int MIN_STAMINA = 0;
    static int countPlayers = 0;

    Player(int stamina) {
        this.stamina = stamina;
        if(countPlayers < 6) {
            countPlayers++;
        } else {
            System.out.println("На поле достаточно игроков.");
        }
    }

    int getStamina() { return stamina; }

    static int getCountPlayers() { return countPlayers; }

    void run() {
        if(stamina > MIN_STAMINA && countPlayers > 0) {
            stamina--;
            if(stamina == MIN_STAMINA) { countPlayers--; }
        } else if(countPlayers > 0) {
            countPlayers--;
        }
    }

    static void info() {
        if(countPlayers < 6) {
            System.out.println("Команды не полные. На поле ещё есть " + (6-countPlayers) + " свабодных мест.");
        } else {
            System.out.println("На поле нет свободных мест.");
        }
    }
    static void shouPlayersGroup(Player a, Player b, Player c, Player d, Player e, Player f) {
        System.out.println(a.stamina +
                ", " + b.stamina +
                ", " + c.stamina +
                ", " + d.stamina +
                ", " + e.stamina +
                ", " + f.stamina + ", ");
    }
}
