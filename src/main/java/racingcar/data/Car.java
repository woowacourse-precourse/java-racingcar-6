package racingcar.data;

public class Car {
    private final CarName carName;
    private final CarPosition carPosition;
    private static final String CAR_DELIMITER = " : ";

    public Car(String name, int pos) {
        this.carName = new CarName(name);
        this.carPosition = new CarPosition(pos);
    }

    public void moveCarPosition(int moveNum) {
        carPosition.move(moveNum);
    }

    @Override
    public String toString() {
        return carName + CAR_DELIMITER + carPosition;
    }
}
