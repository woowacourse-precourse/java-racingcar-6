package racingcar.model;

import static racingcar.utility.Constants.MIN_ACCEPTABLE;

public class Car {
    private String name;
    private Integer steps;
    public Car (String name) {
        this.name = name;
        this.steps = 0;
    }
    public String name() {
        return this.name;
    }
    public Integer steps() {
        return this.steps;
    }
    public void addStep(Integer randInt) {
        if (randInt >= MIN_ACCEPTABLE) {
            this.steps++;
        }
    }
}
