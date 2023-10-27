package racingcar.domain;

public class Car {
    private final String name;

    // Car Constructor
    private Car(final String input) {

        this.name = input;
    }

    // Car Static Factory Method
    public static Car create(final String input) {
        return new Car(input);
    }
}
