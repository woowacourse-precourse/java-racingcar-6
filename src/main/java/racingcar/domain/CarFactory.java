package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private List<Car> carList;

    public void produceCars(List<String> carNameList) {
        carList = carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCarList() {
        return carList;
    }
}
