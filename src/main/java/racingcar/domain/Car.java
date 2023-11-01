package racingcar.domain;

public class Car {
    private final String name;
    private int distance = 0;

    private Car(String name) {
        this.name = name;
    }

    private Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car registerCar(String name) {
        return new Car(name);
    }

    public static Car moveForwardCar(Car car) {
        return new Car(car.name, car.distance + 1);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
