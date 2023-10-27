package racingcar.controller;

import racingcar.domain.car.CarsFinished;
import racingcar.domain.car.CarsRacing;
import racingcar.domain.game.CarsFinishedDto;
import racingcar.domain.move.MoveCommander;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public final class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MoveCommander moveCommander;

    public GameController(
            final InputView inputView,
            final OutputView outputView,
            final MoveCommander moveCommander
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.moveCommander = moveCommander;
    }

    public void run() {
        final CarsRacing cars = inputView.inputCarsRacing();
        playUntilMaxRound(cars);
        showResult(cars);
    }


    private void playUntilMaxRound(final CarsRacing cars) {
        final int maxRound = inputView.inputMaxRound();
        _playUntilMaxRound(cars, 1, maxRound);
    }

    private void _playUntilMaxRound(
            final CarsRacing cars,
            int currentRound,
            final int maxRound
    ) {
        if (currentRound > maxRound) {
            return;
        }
        cars.moveAllBy(moveCommander);
        _playUntilMaxRound(cars, currentRound + 1, maxRound);
    }

    private void showResult(CarsRacing cars) {
        final CarsFinishedDto dto = CarsFinished
                .from(cars)
                .toWinnersResult();
        outputView.printGameResult(dto);
    }
}
