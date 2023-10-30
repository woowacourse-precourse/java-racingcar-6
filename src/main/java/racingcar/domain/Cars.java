package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> carList) {
        this.cars = carList;
    }

    public void race(Strategy strategy) {
        cars.stream().forEach(car -> car.move(strategy));
    }

    public List<Car> getCars() {
        return cars;
    }
}
