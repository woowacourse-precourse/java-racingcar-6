package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public int size() {
        return cars.size();
    }

    public Car get(int index) {
        return cars.get(index);
    }

    public List<Car> getCars() {
        return cars;
    }

}
