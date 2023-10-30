package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.view.InputView;

public class Controller {
    public List<Car> addCarToList() {
        List<Car> cars = InputView.inputCarName()
                                  .stream()
                                  .map(Car::new)
                                  .collect(Collectors.toList());
        return cars;
    }
}
