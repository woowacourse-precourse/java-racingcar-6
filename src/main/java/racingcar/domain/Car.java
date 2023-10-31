package racingcar.domain;


public class Car {
    String carName;
    int distance = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public void move(Car name) {
        this.distance += 1;
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName() {
        return carName;
    }

}
