package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.TryNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    Cars cars;
    TryNumber tryNumber;

    public void play() {
        initialize();
        raceStart();
    }

    private void initialize() {
        cars = new Cars(InputView.readCarNames());
        tryNumber = new TryNumber(InputView.readTryNumber());
    }

    private void raceStart() {
        int count = 0;
        OutputView.startDisplayRoundResults();
        while (!tryNumber.isOver(count)) {
            cars.decideToMove();
            OutputView.displayRoundResult(cars);
            count++;
        }
    }

}
