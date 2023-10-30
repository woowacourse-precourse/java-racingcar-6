package racingcar.domain;

public class Car {

    private String name;
    private int distance;

    public Car(Car car) {
        this.name = car.name;
    }

    public Car(String name) {
        this.name = name;
    }

    public void increaseDistance() {
        distance++;
    }
}
