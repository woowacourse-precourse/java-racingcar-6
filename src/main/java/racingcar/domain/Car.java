package racingcar.domain;

public class Car {
    private final Name name;

    private Car(Name name) {
        this.name = name;
    }

    public static Car of(Object name) {
        return new Car(Name.of(name));
    }
}
