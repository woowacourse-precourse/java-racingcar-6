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

    private Car(String name, int forward) {
        this.name = name;
        this.forward = forward;
    }

    public static Car make(String name, int forward) {
        return new Car(name, forward);
    }

    public String getName() {
        return name;
    }

    public int getForward() {
        return forward;
    }

    public void setForward() {
        this.forward++;
    }
}
