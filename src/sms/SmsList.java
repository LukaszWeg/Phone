package sms;
//klasa ktora jest w liscie i poprzez nią tworzymy obiekt ktory posiada parametry do kogo jest wysylana wiadomosc i jaka ta wiadomosc jest
public class SmsList {
    private int who;
    private String message;

    public SmsList(int who, String message) {
        this.who = who;
        this.message = message;
    }

    public SmsList() {
    }

    public int getWho() {
        return who;
    }

    public void setWho(int who) {
        this.who = who;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
