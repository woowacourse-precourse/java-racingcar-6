package racingcar.data.car;

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

    public boolean isSamePosition(int pos) {
        return carPosition.toInt() == pos;
    }

    public int getPosition() {
        return carPosition.toInt();
    }

    public String getName() {
        return carName.toString();
    }

    @Override
    public String toString() {
        return carName + CAR_DELIMITER + carPosition;
    }
}
