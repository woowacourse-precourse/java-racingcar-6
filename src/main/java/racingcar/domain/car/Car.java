package racingcar.domain.car;

public class Car {

    private static final int START_LOCATION = 0;

    private final String name;
    private Integer location;

    public Car(String name) {
        this.name = name;
        this.location = START_LOCATION;
    }

    public void move(Integer commandNumber) {
    }
}
