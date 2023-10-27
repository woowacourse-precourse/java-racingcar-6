package racingcar.model;

public class Car {

    private static final int MINIMUM_ACCERATE_VALUE = 4;

    private final Name name;
    private int position;

    private Car(final Name name) {
        this.name = name;
        this.position = 0;
    }

    public static Car from(final Name name) {
        return new Car(name);
    }

    public void accelerate(final int number) {
        if (number >= MINIMUM_ACCERATE_VALUE) {
            position++;
        }
    }
}
