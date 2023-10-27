package racingcar.domain;

public class Car {

    private final Name name;
    private Distance distance;

    public Name getName() {
        return name;
    }

    public Distance getDistance() {
        return distance;
    }

    public Car(final Name name) {
        this.name = name;
        this.distance = Distance.zero();
    }
}
