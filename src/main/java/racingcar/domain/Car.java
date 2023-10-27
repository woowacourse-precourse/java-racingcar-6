package racingcar.domain;

public class Car {

    private final Name name;
    private int position;

    public Car(final Name name, final int position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(final String name, final int position) {
        return new Car(Name.from(name), position);
    }

    public void moveForward() {
        position++;
    }
}
