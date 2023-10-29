package racingcar.model;

public class Car {
    private static final Integer INIT_POSITION = 0;

    private final String name;
    private Integer position;

    public Car(String name) {
        this.name = name;
        this.position = INIT_POSITION;
    }
}
