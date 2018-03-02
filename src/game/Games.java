package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Games {
    private boolean  work = true;
    private boolean gamee;
    private String choice;
    private String nick;
    private int gameRandom;
    private int gamerShot;
    private int health;
    private int score;
    List<Game> game = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public void action() {
        while(work) {
            System.out.println("\nWybierz jedno: \"Nowa\" \"wyniki\" \"Powrot\"");
            choice = in.next().toLowerCase();
            switch (choice) {
                case "nowa":
                    newGame();
                    break;
                case "wyniki":
                    topList();
                    break;
                    case "powrot":
                    work = false;
                    break;
                default :
                    System.out.println("Podano złą komendę!");
                    break;
            }
        }
        work = true;
    }

    public void newGame() {
        gamee = true;
        health = 10;
        System.out.println("Podaj swój nick");
        nick = in.next();
        System.out.println("Liczby z zakresu od 0-20! pierwsza cyfra: ");
        gameRandom = (int) (Math.random()*20);
        System.out.println(gameRandom);
        while (gamee) {

            if(health > 0) {
                gamerShot = in.nextInt();
                if (gamerShot == gameRandom) {
                    System.out.println("brawo trafiłeś! - Kolejna cyfra:");
                    score++;
                    gameRandom = (int) (Math.random()*20);
                    System.out.println(gameRandom);
                } else if (gamerShot > gameRandom) {
                    health--;
                    System.out.println("Liczba jest mniejsza zostało: " + health + " żyć");
                } else if (gamerShot < gameRandom) {
                    health--;
                    System.out.println("Liczba jest wieksza zostało: " + health + " żyć");

                }
            }
            else
            {
                System.out.println("koniec gry! Twój wynik to: " + score);
                game.add(new Game(nick, score));
                gamee = false;
            }

        }

    }
    public void topList(){
        for(Game gam: game)
        {
            System.out.println(gam.getNick() + " " + gam.getScore());
        }
    }
}

