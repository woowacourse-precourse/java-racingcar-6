package racingcar.domain;

import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void move() {
        carList.forEach(Car::move);
    }

    public List<Car> getCarList() {
        return carList;
    }
}
