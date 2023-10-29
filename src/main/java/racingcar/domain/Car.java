package racingcar.domain;

public class Car {

    private String name;
    private int forwardStep;

    public Car(String name, int forwardStep) {
        this.name = name;
        this.forwardStep = forwardStep;
    }

    public String getName() {
        return name;
    }

    public int getForwardStep() {
        return forwardStep;
    }

    public static Car of(String name) {
        return new Car(name, 0);
    }
}
