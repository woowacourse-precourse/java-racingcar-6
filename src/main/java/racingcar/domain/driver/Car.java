package racingcar.domain.driver;

public class Car {

    private final String name;
    private int movementCount;

    public Car(String name) {
        this.name = name;
    }

    public int getMovementCount() {
        return movementCount;
    }

    public String getName() {
        return name;
    }

    public void moveForward(int commandNumber) {
        if (commandNumber >= 4) {
            movementCount++;
        }
    }

}
