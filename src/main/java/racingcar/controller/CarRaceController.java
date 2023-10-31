package racingcar.controller;

import racingcar.model.Car;
import racingcar.validator.AttemptNumberValidator;
import racingcar.validator.CarNameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarRaceController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void startRace() {
        List<String> carNames = inputView.inputCarNames();
        CarNameValidator.validateCarNames(carNames);

        int numberOfAttempts = AttemptNumberValidator.validateNumber(inputView.inputNumberOfAttempts());

        List<Car> cars = initializeCars(carNames);
    }

    private static List<Car> initializeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }
}