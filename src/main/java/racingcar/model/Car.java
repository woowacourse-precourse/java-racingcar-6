package racingcar.model;

public class Car {
    private String name;
    private int step;

    public Car(String name, int step) {
        this.name = name;
        this.step = step;
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }
}
