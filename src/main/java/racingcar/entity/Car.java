package racingcar.entity;

public class Car {
    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    private String name;

    private Integer score;

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }
}
