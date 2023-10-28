package racingcar;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public void plusMoveForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
