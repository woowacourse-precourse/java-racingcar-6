package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Race;
import racingcar.model.RandomMovementStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final InputView inputView;

    public RaceController(InputView inputView) {

        this.inputView = inputView;
    }

    public void run() {

        final Cars cars = new Cars(inputView.inputCarName());

        int numberOfMoves = inputView.inputNumberOfMove();

        final Race race = new Race(cars);

        while (numberOfMoves != OutputView.END_GAME) {

            race.start(new RandomMovementStrategy());

            OutputView.outputResult(cars);

            numberOfMoves--;
        }

        OutputView.outputWinner(cars.findWinners());
    }
}
