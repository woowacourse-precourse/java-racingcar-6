package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    private final List<String> carNameList;

    private List<Car> carList;

    public CarFactory(List<String> carNameList) {
        this.carNameList = carNameList;
    }

    public void produceCars() {
        carList = carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCarList() {
        return carList;
    }
}
