package racingcar.Domain;

public class Car {
    private final String carName;
    private int carPosition = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public void carMove(int distance) {
        carPosition += distance;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }

    @Override
    public String toString() {
        return carName;
    }

}
