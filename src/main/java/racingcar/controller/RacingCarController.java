package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.validate.InvalidInputException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final InvalidInputException invalidInputException = new InvalidInputException();
    private static final Cars cars = new Cars();

    public void run() {
        outputView.carNameInputGuide();
        String inputCarNames = carNamesInput();
        createCars(inputCarNames);
        outputView.timesInputGuide();
        int times = timesInput();
        outputView.resultGuide();
        for (int i = 0; i < times; i++) {
            startRacing();
        }
        outputView.printFinalWinner(formatWinnerNames(cars.getWinner()));
    }

    private void createCars(String inputCarNames) {
        List<Car> inputCarList = Arrays.stream(inputCarNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
        cars.addCars(inputCarList);
    }

    private void startRacing() {
        outputView.printSingleRoundResult(cars.singleRoundResult());
    }

    private String carNamesInput() {
        String input = inputView.carNamesInput();
        invalidInputException.checkCarNames(input);
        return input;
    }

    private int timesInput() {
        String times = inputView.timesInput();
        invalidInputException.checkTimes(times);
        return Integer.parseInt(times);
    }

    private String formatWinnerNames(List<String> winnerNames) {
        return String.join(",", winnerNames);
    }
}
