package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.TryNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private Cars cars;
    private TryNumber tryNumber;

    public void play() {
        initializeGame();
        startRace();
        displayWinners();
    }

    private void initializeGame() {
        cars = new Cars(InputView.readCarNames());
        tryNumber = new TryNumber(InputView.readTryNumber());
    }

    private void startRace() {
        int count = 0;
        OutputView.displayRoundResultHeader();
        while (tryNumber.isNotOver(count)) {
            playSingleRound();
            count++;
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
