package racingcar;

public class Car {
    private String name;
    private int step = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }
}
