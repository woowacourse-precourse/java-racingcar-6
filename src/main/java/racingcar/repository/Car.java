package racingcar.repository;

import java.util.List;

public class Car {
    private static Car car;

    private List<CarInfo> cars;

    private Car() {
    }

    public static Car getInstance() {
        if (car == null) {
            car = new Car();
        }
        return car;
    }

    public List<CarInfo> getCars() {
        return cars;
    }

    public void setCars(List<CarInfo> cars) {
        this.cars = cars;
    }
}
