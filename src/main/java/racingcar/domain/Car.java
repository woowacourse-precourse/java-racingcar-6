package racingcar.domain;

public class Car {
    private String name;
    private int score;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    public void updateScore() {
        this.score++;
    }

    public int getScore() {
        return this.score;
    }
}