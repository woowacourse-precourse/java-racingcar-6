package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Car get(int i) {
        return cars.get(i);
    }

    public String toString() {
        return Arrays.toString(this.cars.toArray());
    }

    public int size() {
        return cars.size();
    }


}
