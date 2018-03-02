package game;
//klasa game ktora odpowiada za tworzenie obekitu gry gdzie zapisujemy wynik i nick osoby grajacej w liscie
public class Game {
    private String nick;
    private int score;

    public Game(String nick, int score) {
        this.nick = nick;
        this.score = score;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
