package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.util.Constants;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class RacingGameConsole {
    private final MoveStrategy moveStrategy;

    public RacingGameConsole(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void run() {
        Cars cars = createCars(InputView.inputCarNames());
        int roundCount = parseRoundCount(InputView.inputRound());

        startRacing(cars, roundCount);
    }

    private void startRacing(Cars cars, int roundCount) {
        Race race = new Race(cars, moveStrategy);

        OutputView.printRacingResult();

        for (int currentRound = 0; currentRound < roundCount; currentRound++) {
            race.executeOneRound();
            OutputView.printProgress(race.getCars());
        }

        OutputView.printWinners(race.getWinnerNames());
    }

    private Cars createCars(String carNamesInput) {
        InputValidator.validateCarNames(carNamesInput);

        List<String> carNames = Arrays.asList(carNamesInput.split(Constants.CAR_NAME_DELIMITER));
        return new Cars(carNames.stream()
                .map(Car::new)
                .toList());
    }

    private int parseRoundCount(String roundInput) {
        InputValidator.validateRound(roundInput);

        return Integer.parseInt(roundInput);
    }
}
