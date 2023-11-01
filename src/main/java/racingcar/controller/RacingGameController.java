package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.TryNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private Cars cars;
    private TryNumber tryNumber;

    public void play() {
        startGame();
        startRace();
        displayWinners();
    }

    private void startGame() {
        cars = new Cars(InputView.inputCarNames());
        tryNumber = new TryNumber(InputView.inputTryNumber());
    }

    private void startRace() {
        int tryCount = 0;
        OutputView.outputResultHeader();
        while (tryNumber.isNotOver(tryCount)) {
            playSingleRound();
            tryCount++;
        }
    }

    private void playSingleRound() {
        cars.decideToMove();
        OutputView.displayRoundResult(cars.generateRoundResultString());
    }

    private void displayWinners() {
        List<Car> winners = cars.getWinners();
        OutputView.displayWinners(winners.stream()
                .map(Car::getNameFormat)
                .collect(Collectors.toList()));
    }
}
