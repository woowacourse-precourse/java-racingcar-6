package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.GameConfig;
import racingcar.model.Car;
import racingcar.validation.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    public GameController() {}

    public void startGame() {
        List<Car> cars = createCars(inputCarNames());
        int attemptCount = inputAttemptCount();

        for (int i = 0; i < attemptCount; i++) {
            moveAllCarsForward(cars);
            displayAllCarsPosition(cars);
        }
    }

    private void displayAllCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            OutputView.printCarPosition(car.getName(), car.getPosition());
        }
    }

    private void moveAllCarsForward(List<Car> cars) {
        for (Car car : cars) {
            moveForward(car);
        }
    }

    private void moveForward(Car car) {
        int randomValue = Randoms.pickNumberInRange(GameConfig.RANDOM_MINIMUM_RANGE, GameConfig.RANDOM_MAXIMUM_RANGE);

        if (randomValue >= GameConfig.MINIMUM_NUMBER_FOR_FORWARD) {
            car.forward();
        }
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
