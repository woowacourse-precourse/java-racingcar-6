package racingcar.model;

public class Car {
    private final String name;
    private int forward;

    private Car(String name) {
        this.name = name;
    }

    public static Car make(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getForward() {
        return forward;
    }

    public void setForward(int forward) {
        this.forward = forward;
    }
}
