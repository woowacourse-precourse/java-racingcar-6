package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private final List<Car> carList = new ArrayList<>();

    public CarList(List<String> carNames) {
        carNames.forEach(carName -> carList.add(new Car(carName)));
    }
}
