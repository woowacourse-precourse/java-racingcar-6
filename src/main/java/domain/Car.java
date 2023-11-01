package domain;

public class Car {
    private final static int MOVEMENT = 1;
    private final static int MIN_MOVEMENT_NUMBER = 4;
    private final static int MAX_MOVEMENT_NUMBER = 9;

    private String name;
    private Integer position;

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void initGame() {
        position = 0;
    }

    public void gameMovement(int roundRandomNumber) {
        if (isValidNumberMovementPosition(roundRandomNumber)) {
            position += MOVEMENT;
        }
    }

    public Boolean isValidNumberMovementPosition(int roundRandomNumber) {
        return MIN_MOVEMENT_NUMBER <= roundRandomNumber && MAX_MOVEMENT_NUMBER >= roundRandomNumber;
    }
}
