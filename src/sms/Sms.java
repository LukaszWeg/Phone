package sms;

import contact.Contacts;

import java.util.*;

public class Sms {
    private boolean work = true;
    private String choice;
    Scanner in = new Scanner(System.in);

    public void action() {
        while(work) {
            System.out.println("\nWybierz jedno: \"Wyslij SMS\" \"Przegladaj\" \"Powrot\"");
            choice = in.next().toLowerCase();
            switch (choice) {
                case "wyslij sms":
                    break;
                case "przegladaj":
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



    }
}
