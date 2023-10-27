package racingcar.domain.entity;

public class Car {
    private String carName;
    private int distance;

    private Car() {
    }

    public static Car create(String name) {
        Car car = new Car();
        car.carName = name;
        car.distance = 0;

        return car;
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    public void changeDistance(int distance) {
        this.distance = distance;
    }
}
