package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class RacingGame {

    public void start() {
        List<String> carNames = inputAndValidateCarNames();
        int roundCount = inputAndValidateRound();

        OutputView.printRacingResult();

        Race race = new Race(createCars(carNames), new RandomMoveStrategy());

        for (int currentRound = 0; currentRound < roundCount; currentRound++) {
            race.executeOneRound();
            OutputView.printProgress(race.getCars());
        }

        OutputView.printRacingWinner(race.getWinners());
    }

    private List<String> inputAndValidateCarNames() {
        String carNamesInput = InputView.inputCarNames();
        InputValidator.validateCarNames(carNamesInput);

        return Arrays.stream(carNamesInput.split(","))
                .toList();
    }

    private int inputAndValidateRound() {
        String roundInput = InputView.inputRound();
        InputValidator.validateRound(roundInput);

        return Integer.parseInt(roundInput);
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }
}
