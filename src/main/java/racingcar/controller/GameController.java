package racingcar.controller;

import racingcar.model.Car;
import racingcar.validation.InputValidator;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    public GameController() {}

    public void startGame() {
        List<Car> cars = createCars(inputCarNames());
        int attemptCount = inputAttemptCount();

    }

    private int inputAttemptCount() {
        String inputCount = InputView.inputAttemptCount();

        InputValidator.validateNumericInput(inputCount);

        return Integer.parseInt(inputCount);
    }

    private List<Car> createCars(List<String> names) {
        return names.stream()
                    .map(Car::new)
                    .collect(Collectors.toList());
    }

    private List<String> inputCarNames() {
        String inputNames = InputView.inputCarNames();

        return Arrays.stream(inputNames.split(","))
                .toList();
    }
}
