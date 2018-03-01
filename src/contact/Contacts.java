package contact;

import contact.Contact;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Contacts {
    private boolean work = true;
    private String choice;

    private List<Contact> contact = new ArrayList<>();
    public String name;
    public String lName;
    public int number;
    Scanner in = new Scanner(System.in);

    public List<Contact> getContact() {
        return contact;
    }



    public void action() {
        while(work) {
            System.out.println("\nWybierz jedno: \"Dodaj\" \"Usun\" \"Przegladaj\" \"Powrot\"");
            choice = in.next().toLowerCase();
            switch (choice) {
                case "dodaj":
                    addContact();
                    break;
                case "usun":
                    deleteContact();
                    break;
                case "przegladaj":
                    showContact();
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
    public void addContact() {
        System.out.println("Podaj imie:");
        name = in.next();
        System.out.println("nazwisko:");
        lName = in.next();
        System.out.println("numer telefonu:");

        try {
            number = in.nextInt();
            contact.add(new Contact(name, lName, number));
        }
        catch (InputMismatchException e) {
            System.out.println("Nie podano cyfr!");
        }

    }
    
    public void showContact() {
        for (Contact con: contact) {
            System.out.println(contact.indexOf(con) + 1 + ". " + con.getFirstName() + " " + con.getLastName() + " " + con.getNumber());
        }
    }

    public void deleteContact() {
        showContact();
        number = in.nextInt();
        try {
            contact.remove(number-1);
            System.out.println("Usunieto!");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Nie ma osoby pod tym numerem");
        }

    }
}
