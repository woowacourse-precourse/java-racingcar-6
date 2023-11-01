package racingcar.model;

import java.util.Collections;
import java.util.List;

public class Referee {
    public List<Car> getWinner(List<Car> carList) {
        int maxStatus = Collections.max(carList.stream().map(Car::getStatus).toList());
        return carList.stream().filter(car -> car.getStatus() == maxStatus).toList();
    }
}
