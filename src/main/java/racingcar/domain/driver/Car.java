package racingcar.domain.driver;

public class Car {

    private int movementCount;

    public int getMovementCount() {
        return movementCount;
    }

    public void moveForward(int commandNumber) {
        if (commandNumber >= 4) {
            movementCount++;
        }
    }

}
