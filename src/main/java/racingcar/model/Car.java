package racingcar.model;

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
}
