package racingcar.domain;

public class Car {
    private String name;

    private Car() {}
    public static Car createCarByCarName(String carName) {
        Car car = new Car();
        car.name = carName;
        return car;
    }
}
