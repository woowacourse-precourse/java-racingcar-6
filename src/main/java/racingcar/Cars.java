package racingcar;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Car get(int index) {
        return cars.get(index);
    }
}
