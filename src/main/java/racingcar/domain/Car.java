package racingcar.domain;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public void increasePosition() {
        position++;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
