package racingcar.database;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class CarData {
    private final List<Car> carFactory = new ArrayList<>();
    public void addAll(List<Car> carList) {
        carFactory.addAll(carList);
    }
}
