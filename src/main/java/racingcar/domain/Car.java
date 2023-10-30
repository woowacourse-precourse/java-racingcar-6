package racingcar.domain;

public class Car {

    private static final int INITIAL_DISTANCE = 0;

    private final String name;
    private int drivenDistance = INITIAL_DISTANCE;

    private Car(String name) {
        this.name = name;
    }

    public static Car from(String name) {
        return new Car(name);
    }
}
