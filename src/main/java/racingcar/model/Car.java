package racingcar.model;

public class Car {

    private static final int MOVE_FORWARD_CRITERION = 4;

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveForwardRandomly() {
    }

    public boolean isPositionGreaterThan(int num) {
        return false;
    }
}
