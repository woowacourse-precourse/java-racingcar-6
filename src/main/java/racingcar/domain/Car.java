package racingcar.domain;

public class Car {

    private String name;
    private int moveForwardCount = 0;

    private static final int MOVE_FORWARD_STANDARD = 4;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getMoveForwardCount() {
        return moveForwardCount;
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= MOVE_FORWARD_STANDARD) {
            moveForwardCount++;
        }
    }
}