package racingcar.model;

public class Car {
    private String name;
    private int currentPosition;
    private boolean isMoving;

    public Car(String name) {
        this.name = name;
        this.currentPosition = 0;
        this.isMoving = false;
    }
}
