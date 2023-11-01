package racingcar.domain;

public class Car {
    private final String name;
    private int score;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void move(int number) {
        if (number >= 4) {
            score++;
        }
    }
}
