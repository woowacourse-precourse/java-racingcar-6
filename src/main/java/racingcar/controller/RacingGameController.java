package racingcar.controller;

import racingcar.domain.Car;
import racingcar.util.Converter;
import racingcar.util.InputValidator;
import racingcar.view.InputView;

import java.util.List;

public class RacingGameController {
    private final InputView inputView = new InputView();
    private final InputValidator inputValidator = new InputValidator();
    private final Converter converter = new Converter();

    public void run() {
        initialize();
    }

    private void initialize() {
        String inputNames = inputView.inputNames();
        List<String> carNames = converter.getCarNames(inputNames);
        inputValidator.validateCarNames(carNames);
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        String inputNumber = inputView.inputAttemptNumber();
        if (inputValidator.validateAttemptNumber(inputNumber)) {
            int attemptNumber = Integer.parseInt(inputNumber);
        }
    }
}
