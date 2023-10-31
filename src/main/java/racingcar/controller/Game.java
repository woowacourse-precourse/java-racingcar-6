package racingcar.controller;

import static java.lang.Integer.parseInt;
import static racingcar.validate.InputValidator.validateEmptyInput;
import static racingcar.validate.InputValidator.validateInput;
import static racingcar.validate.InputValidator.validateNameLength;
import static racingcar.validate.InputValidator.validateNumberInput;
import static racingcar.view.InputView.askCarNames;
import static racingcar.view.InputView.askNumberOfAttempts;
import static racingcar.view.OutputView.newLine;
import static racingcar.view.OutputView.printAttempts;
import static racingcar.view.OutputView.printWinners;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarManager;

public class Game {
    private CarManager carManager;

    public void play() {
        start();
        race();
        end();
    }

    private void start() {
        String input = askCarNames();
        validateEmptyInput(input);
        validateInput(input);
        String[] names = input.split(",");

        List<Car> cars = Arrays.stream(names)
                .filter(name -> {
                    validateEmptyInput(name);
                    validateNameLength(name);
                    return true;
                })
                .map(Car::new)
                .collect(Collectors.toList());

        carManager = new CarManager(cars);
    }

    private void race() {
        String input = askNumberOfAttempts();
        validateEmptyInput(input);
        validateNumberInput(input);
        newLine();

        int numberOfAttempts = parseInt(input);
        while (numberOfAttempts-- > 0) {
            carManager.attempt();
        }

        printAttempts(carManager.getAttempts());
    }

    private void end() {
        List<String> winners = carManager
                .getWinners().stream()
                .map(Car::getName)
                .toList();

        printWinners(winners);
    }
}
