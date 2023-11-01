package racingcar;

public class Car {

    private String carName;
    private int movingCount;

    public Car(String carName, int movingCount) {
        this.carName = carName;
        this.movingCount = movingCount;
    }

    public int getMovingCount() {
        return movingCount;
    }

    public String getCarName() {
        return carName;
    }
}
