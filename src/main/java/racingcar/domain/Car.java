package racingcar.domain;

public class Car {
    private final CarName name;

    public Car(final String name) {
        this.name = CarName.from(name);
    }
}
