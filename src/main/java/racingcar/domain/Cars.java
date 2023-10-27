package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public List<String> moveCars(int randomNumber) {
        return carList.stream()
                .map(car -> car.move(randomNumber))
                .collect(Collectors.toList());
    }
}
