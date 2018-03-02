package contact;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Contacts {
    private boolean work = true; //pole odpowiedzialne za pracę switcha do czasu aż osoba nie przerwie jego działania
    private String choice; // pole w którym zapisujemy co chcemy aby nasz switch wykonał
    private static List<Contact> contact = new ArrayList<>(); // lista kontaktów
    public String name; //imie do listy
    public String lName; // nazwisko do listy
    public int number; // numer do listy
    Scanner in = new Scanner(System.in);

    public List<Contact> getContact() {
        return contact;
    } // metoda która zwraca liste


//menu dzięki któremy można wejść do aktualnie potrzebnej funckji
    public void action() {
        while(work) {
            System.out.println("\nWybierz jedno: \"Dodaj\" \"Usun\" \"Przegladaj\" \"Powrot\"");
            choice = in.next().toLowerCase();
            switch (choice) {
                case "dodaj":
                    addContact(); // odwolanie do metody
                    break;
                case "usun":
                    deleteContact(); // odwolanie do metody
                    break;
                case "przegladaj":
                    showContact(); // odwolanie do metody
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

    //metoda dzięki której możemy dodać kontakt, podajemy dane a potem jeżeli numer jest cyfrą dodaje do listy
    public void addContact() {
        System.out.println("Podaj imie:");
        name = in.next();
        System.out.println("nazwisko:");
        lName = in.next();
        System.out.println("numer telefonu:");

       try {
            number = in.nextInt();
            contact.add(new Contact(name, lName, number)); // dodanie do listy
       }
       catch (InputMismatchException e) { //wylapanie bledu jezeli osoba zamiast cyfr wpisze litery
           System.out.println("Nie podano cyfr! lub numer jest zby długi");
       }

    }
    // wyswietla kontakty
    public void showContact() {
        for (Contact con: contact) {
            System.out.println(contact.indexOf(con) + 1 + ". " + con.getFirstName() + " " + con.getLastName() + " " + con.getNumber());
        }
    }
    //usuwa kontakty i wylapuje blad jezeli wpiszemy numer ktory nie istnieje
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
