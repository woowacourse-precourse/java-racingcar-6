package racingcar.domain.car;

public class Car {

    private final String carName;
    private int carLocation;

    public Car(String carName) {
        this.carName = carName;
        this.carLocation = 0;
    }

    public void updateCarLocation(int carMoveDistance) {
        this.carLocation += carMoveDistance;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarLocation() {
        return carLocation;
    }
}
