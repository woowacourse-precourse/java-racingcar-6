package racingcar.domain;

public class Player {
    public String name;
    public int score;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void addScore() {
        score++;
    }
}
