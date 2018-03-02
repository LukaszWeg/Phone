package sms;


import contact.Contacts;

import java.util.*;

public class Sms {
    private boolean work = true; // pole odpowiedzialne za dzialanie switcha
    private String choice; // pole odpowiedzialne za nasz wybor w switchu
    private int who; // pole gdzie podajemy do kogo wysylamy wiadomosc
    private int check; //pole gdzie wybieramy kogo chcemy zobaczyc smsy
    private String message; // pole gdzie zapisujemy wiadomosc
    Contacts contacts = new Contacts(); // tworzy obiekt klasy contact
    private static List<SmsList> sms = new ArrayList<>(); // lista gdzie jest zapisywana wiadomosc i do kogo ona jest
    Scanner in = new Scanner(System.in);

    public Sms(){};

    public int getWho() {
        return who;
    }

    public String getMessage() {
        return message;
    }
  // metoda ktora pokazuje nam switch z wyborami
    public void action() {
        while(work) {
            System.out.println("\nWybierz jedno: \"Wyslij\" \"Przegladaj\" \"Powrot\"");
            choice = in.next().toLowerCase();
            switch (choice) {
                case "wyslij":
                    sendSms();
                    break;
                case "przegladaj":
                    showSms();
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
// metoda dzieki ktorej mozemy wyslac wiadomosc do kogos z listy
    public void sendSms() {
        System.out.println("Podaj tresc sma");
        message = in.next();
        System.out.println("Do kogo wysłać");
        contacts.showContact();
        who  = in.nextInt();
        if(who-1 >= contacts.getContact().size())
        {
            System.out.println("Nie ma takiej osoby");
        }
        else {
            sms.add(new SmsList(who, message));
            System.out.println("Wyslano");
        }
    }
// metoda ktora pokazuje nam jakie wiadomosci wyslalismy do wybranej osoby
    public void showSms() {
        System.out.println("wybierz kogo smsy chesz zobaczyc");
        contacts.showContact();
        check = in.nextInt();

        for(SmsList sm: sms)
        {
            if(sm.getWho() == check)
            {
                System.out.println(sm.getMessage());
            }
        }

        }
}
