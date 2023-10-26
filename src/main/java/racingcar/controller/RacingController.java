package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.Arrays;
import java.util.List;

public class RacingController {

    private static final String CAR_NAME_DELIMITER = ",";

    private final Output output = new Output();
    private final Input input = new Input();

    public void run() {
        output.showCarNamesInputMessage();
        String carNames = input.readCarNames();

        List<Car> cars = makeCars(carNames);

        output.showCountInputMessage();
        String count = input.readCount();
    }

    private List<Car> makeCars(String carNames) {
        return Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .map(Car::new)
                .toList();
    }
}
