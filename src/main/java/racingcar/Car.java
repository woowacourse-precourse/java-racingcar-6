package racingcar;

public class Car {
    private String name;
    private Integer score;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    public void move(Judge judge) {
        if (judge.isMoveAvailable()) {
            score += 1;
        }
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + " : " +
                "-".repeat(score);
    }
}
