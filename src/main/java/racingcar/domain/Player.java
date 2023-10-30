package racingcar.domain;

public class Player {
    public String name;
    public int score;

    public Player(String name) {
        this.name = name;
    }

    public void addScore(){
        score++;
    }
}
