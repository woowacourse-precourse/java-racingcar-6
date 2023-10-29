package racingcar.repository;

import java.util.List;

public class Car {
    private static Car car;

    private List<String> cars;

    private Car() {
    }

    public static Car getInstance() {
        if (car == null) {
            car = new Car();
        }
        return car;
    }

    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }
}
