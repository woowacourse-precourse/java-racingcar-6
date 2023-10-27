package racingcar.domain;

public class Car {
    private final MovingStrategy movingStrategy;

    private final String name;
    private int position;

    public Car(MovingStrategy movingStrategy, String name, int position) {
        this.movingStrategy = movingStrategy;
        this.name = name;
        this.position = position;
    }
}
