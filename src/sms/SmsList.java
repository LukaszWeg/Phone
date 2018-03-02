package sms;

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
