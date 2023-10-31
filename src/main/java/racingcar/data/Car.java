package racingcar.data;

public class Car {
    private final CarName carName;
    private final CarPosition carPosition;

    public Car(String name, int pos) {
        this.carName = new CarName(name);
        this.carPosition = new CarPosition(pos);
    }
}
