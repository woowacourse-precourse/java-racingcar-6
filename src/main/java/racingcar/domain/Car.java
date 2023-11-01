package racingcar.domain;


public class Car {
    private String carName;
    private int distance = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public void move() {
        this.distance += 1;
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName() {
        return carName;
    }

}
