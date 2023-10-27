package racingcar.domain;

public class Car {

    private final Name name;
    private Distance distance;

    public Name getName() {
        return new Name(name.value());
    }

    public Distance getDistance() {
        return new Distance(distance.value());
    }

    public Car(final Name name) {
        this.name = name;
        this.distance = Distance.zero();
    }
}
