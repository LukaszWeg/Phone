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
    private static List<SmsList> sms = new ArrayList<>();
    Scanner in = new Scanner(System.in);

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
        if(who-1 >= contacts.getContact().size())
        {
            System.out.println("Nie ma takiej osoby");
        }
        else {
            sms.add(new SmsList(who, message));
            System.out.println("Wyslano");
        }
    }

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
