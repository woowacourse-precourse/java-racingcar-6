package racingcar;

public class Car {
    private String name;
    private int stepCount;
    public Car(String name) {
        this.name = name;
        this.stepCount = 0;
    }

    public String getName() {
        return name;
    }
}
