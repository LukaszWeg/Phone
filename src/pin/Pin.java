package pin;

import java.util.Scanner;

public class Pin {
    private static final short pin = 1234; //nasz pin
    private short userPin; // pin ktory wybral uzytkownik
    private static short attempt = 3; // liczba prob
    Scanner in = new Scanner(System.in);

    public static short getPin() {
        return pin;
    }
// metoda ktora sprawdza czy podane haslo jest takie same jak wymagane i jezeli tak zwraca true
    public boolean checkPin() {
        System.out.println("Podaj PIN:");
        while (true) {
            userPin = in.nextShort();
            if (pin == userPin) {
                System.out.println("Logowanie powiodło się");
                return true;
            } else {
                if(attempt == 0)
                {
                    System.out.println("Podano zby wiele razy zły PIN");
                    return false;
                }
                else {
                    System.out.println("Wpisano zły PIN! zostało: " + attempt + " próby");
                    attempt--;
                }
            }
        }
    }
}
