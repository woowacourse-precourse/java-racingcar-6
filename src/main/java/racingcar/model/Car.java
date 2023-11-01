package racingcar.model;

public class Car {
    private final String name;
    private int currentPosition;
    private static final int CAN_MOVE_NUMBER = 4;

    public Car(String name) {
        this.name = name;
        this.currentPosition = 0;
    }
}
