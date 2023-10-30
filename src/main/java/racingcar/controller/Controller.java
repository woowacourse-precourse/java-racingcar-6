package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Attempt;
import racingcar.domain.Car;
import racingcar.view.InputView;

public class Controller {

    public void createAttempt() {
        Attempt attempt = new Attempt(InputView.inputAttemptCount());
    }

    public List<Car> addCarToList() {
        List<Car> cars = InputView.inputCarName()
                                  .stream()
                                  .map(Car::new)
                                  .collect(Collectors.toList());
        return cars;
    }
}
