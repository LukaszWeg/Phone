package menu;

import contact.Contacts;
import game.Games;
import pin.Pin;
import sms.Sms;

import java.util.Scanner;
//glowna klasa ktora jest odpowiedzialna za nawigacje po calym programie
public class Menu {
    private boolean work = true; // pole odpowiedzialne za dzialanie switchu az do przerwania
    private String choice; // pole odpowiedzialne za wybor osoby co do switcha
    Scanner in = new Scanner(System.in);
    Pin pin = new Pin(); // tworzy obiekt klsay pin
    Contacts contacts = new Contacts(); //tworzy obiek klasy kontakt
    Sms sms = new Sms(); //tworzy obiekt klasy sms
    Games games = new Games(); //tworzy obiekt klasy game

    //metoda odpowiedizalna za sprawdzenie czy checkPin zwraca true a jezeli tak to wyswietli menu
    public void start()
    {
        if(pin.checkPin() == true){
            showMenu();
        }
    }

    //metoda odpowiedzialna za wyswietlenie menu
    public void showMenu()
    {
        while(work) {
            System.out.println("\nWybierz jedno: \"Kontakt\" \"SMS\" \"Gra\" \"Exit\"");
            choice = in.next().toLowerCase();
            switch(choice){
                case "kontakt":
                    contacts.action();
                    break;
                case "sms":
                    sms.action();
                    break;
                case "gra":
                    games.action();
                    break;
                case "exit":
                    work = false;
                    break;
                default :
                    System.out.println("Podano złą komendę!");
                    break;

            }
        }
    }
}
