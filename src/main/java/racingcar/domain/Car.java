package racingcar.domain;

public class Car {

    public static final int MOVEABLE_OFFSET = 4;

    private final Name name;
    private int position;

    private Car(final Name name, final int position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(final String name, final int position) {
        return new Car(Name.from(name), position);
    }

    public void moveForward(final int randomNumber) {
        if (randomNumber >= MOVEABLE_OFFSET) {
            position++;
        }
    }
}
