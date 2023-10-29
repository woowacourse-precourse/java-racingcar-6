package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> carList = new ArrayList<>();

    public void registerCar(Car... cars) {
        this.carList.addAll(List.of(cars));
    }

    public void registerCar(List<Car> carList) {
        this.carList.addAll(carList);
    }

    public List<Car> getCarList() {
        return carList;
    }
}
