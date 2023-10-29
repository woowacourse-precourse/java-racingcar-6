package racingcar.controller;

import racingcar.domain.car.CarsRacing;
import racingcar.domain.car.dto.output.CarsRacingDto;
import racingcar.domain.car.dto.output.WinnerNamesDto;
import racingcar.domain.move.MoveCommander;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import round.boxed.CurrentRound;
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
        playUntilMaxRoundRecursive(cars, CurrentRound.min(), maxRound);
    }

    private void playUntilMaxRoundRecursive(
            final CarsRacing cars,
            final CurrentRound currentRound,
            final MaxRound maxRound
    ) {
        if (currentRound.isAfter(maxRound)) {
            return;
        }
        cars.moveAllBy(moveCommander);
        final CarsRacingDto dto = cars.toDto();
        outputView.printRoundResult(dto);
        playUntilMaxRoundRecursive(cars, currentRound.nextRound(), maxRound);
    }

    private void showWinners(CarsRacing cars) {
        final WinnerNamesDto dto = cars.toFinished().toWinnerNamesDto();
        outputView.printGameResult(dto);
    }
}
