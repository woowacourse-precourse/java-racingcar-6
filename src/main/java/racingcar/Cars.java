package racingcar;

import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int getSize() {
        return cars.size();
    }

    public Car getCar(int index) {
        return cars.get(index);
    }
}
