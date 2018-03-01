package sms;


import contact.Contacts;

import java.util.*;

public class Sms {
    private boolean work = true;
    private String choice;
    private int who;
    private int check;
    private String message;
    Contacts contacts = new Contacts();
    private static List<Sms> sms = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public Sms(int who, String message) {
        this.who = who;
        this.message = message;
    }

    public Sms(){};

    public int getWho() {
        return who;
    }

    public String getMessage() {
        return message;
    }

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

    public void sendSms() {
        System.out.println("Podaj tresc sma");
        message = in.next();
        System.out.println("Do kogo wysłać");
        contacts.showContact();
        who  = in.nextInt();
        sms.add(new Sms(who,message));
    }

    public void showSms() {
        System.out.println("wybierz kogo smsy chesz zobaczyc");
        contacts.showContact();
        check = in.nextInt();

        for(Sms sm: sms)
        {
            if(check == sm.getWho())
            System.out.println(sm.getMessage());
            else
            {
                System.out.println("Brak");
                break;
            }
        }

        }
}
