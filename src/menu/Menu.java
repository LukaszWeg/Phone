package menu;

import contact.Contacts;
import pin.Pin;
import sms.Sms;

import java.util.Scanner;

public class Menu {
    private boolean work = true;
    private String choice;
    Scanner in = new Scanner(System.in);
    Pin pin = new Pin();
    Contacts contacts = new Contacts();
    Sms sms = new Sms();

    public void start()
    {
        if(pin.checkPin() == true){
            showMenu();
        }
    }
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
