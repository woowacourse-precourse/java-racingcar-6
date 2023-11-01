package racingcar;

public class Car {
    private final String name;
    private String steps;

    public Car(String name) {
        this.name = name;
        this.steps = "";
    }

    public String getName() {
        return name;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }
}
