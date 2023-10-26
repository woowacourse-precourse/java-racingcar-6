package racingcar.domain;

public class Car {
    private final String name;

    public Car(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
