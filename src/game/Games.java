package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Games {
    private boolean  work = true; // pole odpowiedzialne za dzialanie switch dopoki go nie wylaczymy
    private boolean gamee; // pole odpowiedzialne za dzialanie gry dopoki nie przegramy
    private String choice; // pole odpowiedzialne za nasz wybor w switchu
    private String nick; // nick osoby grajacej
    private int gameRandom; // pole ktore zapisuje jakas wartosc od 0 do 20
    private int gamerShot; // pole ktore zapisuje  wybor gracza co do liczby
    private int health; // zycia ktore ma gracz
    private int score; // wynik gracza
    List<Game> game = new ArrayList<>(); // lista ktora zapisuje wynik i nick gracza
    Scanner in = new Scanner(System.in);

 //metoda ktrora tworzy switcha
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
//wlasciwie cala metoda ktora reprezentuje gre
    public void newGame() {
        gamee = true;
        health = 10;
        System.out.println("Podaj swój nick");
        nick = in.next();
        System.out.println("Liczby z zakresu od 0-20! pierwsza cyfra: ");
        gameRandom = (int) (Math.random()*20);
        while (gamee) {

            if(health > 0) {
                gamerShot = in.nextInt();
                if (gamerShot == gameRandom) {
                    System.out.println("brawo trafiłeś! - Kolejna cyfra:");
                    score++;
                    gameRandom = (int) (Math.random()*20);
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

    //wyswietla liste wynikow z gier graczy
    public void topList(){
        for(Game gam: game)
        {
            System.out.println(gam.getNick() + " " + gam.getScore());
        }
    }
}

