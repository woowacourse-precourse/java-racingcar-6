package racingcar.controller;

import racingcar.domain.car.CarsRacing;
import racingcar.domain.car.dto.output.CarsFinishedDto;
import racingcar.domain.car.dto.output.CarsRacingDto;
import racingcar.domain.move.MoveCommander;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import round.boxed.MaxRound;

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
        showWinners(cars);
    }


    private void playUntilMaxRound(final CarsRacing cars) {
        final MaxRound maxRound = inputView.inputMaxRound();
        _playUntilMaxRound(cars, 1, maxRound);
    }

    private void _playUntilMaxRound(
            final CarsRacing cars,
            final int currentRound,
            final MaxRound maxRound
    ) {
        if (currentRound > maxRound.maxRound()) {
            return;
        }
        cars.moveAllBy(moveCommander);
        final CarsRacingDto dto = cars.toDto();
        outputView.printRoundResult(dto);
        _playUntilMaxRound(cars, currentRound + 1, maxRound);
    }

    private void showWinners(CarsRacing cars) {
        final CarsFinishedDto dto = cars.toFinished().toWinnersResult();
        outputView.printGameResult(dto);
    }
}
