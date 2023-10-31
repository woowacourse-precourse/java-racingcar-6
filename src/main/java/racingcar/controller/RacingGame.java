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
        initialize();
        raceStart();
        displayWinners();
    }

    private void initialize() {
        cars = new Cars(InputView.readCarNames());
        tryNumber = new TryNumber(InputView.readTryNumber());
    }

    private void raceStart() {
        int count = 0;
        OutputView.displayRoundResultHeader();
        while (tryNumber.isNotOver(count)) {
            cars.decideToMove();
            OutputView.displayRoundResult(cars.generateRoundResultString());
            count++;
        }
    }

    private void displayWinners() {
        List<Car> winners = cars.getWinners();
        OutputView.displayWinners(winners.stream()
                .map(Car::getNameFormat)
                .collect(Collectors.toList()));
    }

}
