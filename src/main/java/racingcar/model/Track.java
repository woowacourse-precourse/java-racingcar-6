package racingcar.model;

import java.util.List;

public class Track {
    private final List<Car> cars;

    public Track(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
