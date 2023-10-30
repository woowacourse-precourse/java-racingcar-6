package racingcar.domain;

public class Car {
    private String name;
    private int distance;

    private Car(String name) {
        this.name = name;
    }

    public static Car createCar(String name) {
        Car car = new Car(name);
        car.distance = 0;
        return car;
    }
}
