package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public void start() {
        String carNamesInput = inputAndValidateCarNames();
        int roundCount = inputAndValidateRound();

        OutputView.printRacingResult();

        Race race = new Race(createCars(carNamesInput), new RandomMoveStrategy());

        for (int currentRound = 0; currentRound < roundCount; currentRound++) {
            race.oneRound();
            OutputView.printProgress(race.getCars());
        }

        OutputView.printRacingWinner(race.getWinnerNamesToString());
    }

    private String inputAndValidateCarNames() {
        String carNamesInput = InputView.inputCarNames();
        InputValidator.validateCarNames(carNamesInput);

        return carNamesInput;
    }

    private int inputAndValidateRound() {
        String roundInput = InputView.inputRound();
        InputValidator.validateRound(roundInput);

        return Integer.parseInt(roundInput);
    }

    private List<Car> createCars(String input) {
        List<Car> cars = new ArrayList<>();

        String[] carNames = input.split(",");
        for (String carName : carNames) {
            Car car = new Car(carName);

            cars.add(car);
        }

        return cars;
    }
}
