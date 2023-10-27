package racingcar.model;

public class Car {

    private final Name name;

    private Car(final Name name) {
        this.name = name;
    }

    public static Car from(final Name name) {
        return new Car(name);
    }
}
