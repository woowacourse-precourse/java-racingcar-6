package racingcar;

public class Car {
    private String name;
    private Integer score;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    // for test
    public Car(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public void addScore() {
        score++;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }
}
