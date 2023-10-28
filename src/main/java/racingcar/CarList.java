package racingcar;

import java.util.List;

public class CarList {
    private final List<Car> carList;

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    public boolean contains(Car car) {
        return carList.contains(car);
    }

    public int size() {
        return carList.size();
    }
}
