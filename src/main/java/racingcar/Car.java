package racingcar;

public class Car {
    private final String name;

    public Car(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isRunnable() {
        return false;
    }
}
