package racingcar.domain;

public class Car {
    private String name;
    private final Integer score = 0;

    // Car Constructor
    private Car(String name) {
        this.name = name;
    }

    // Car Static Factory Method
    public static Car create(final String name) {
        return new Car(name);
    }
}
