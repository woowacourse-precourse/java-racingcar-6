package racingcar.domain;

import racingcar.util.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Cars {

    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void makeCars(List<String> carNames) {
        cars.addAll(carNames.stream()
                .map(Car::makeCar)
                .collect(toList()));
    }

    public void moveCars() {
        cars.forEach(car -> car.moveCar(Utils.makeRandomNumber()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
