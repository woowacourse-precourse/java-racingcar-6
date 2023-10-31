package racingcar.controller;

import racingcar.domain.car.CarsRacing;
import racingcar.domain.car.dto.output.CarsRacingDto;
import racingcar.domain.car.dto.output.WinnersDto;
import racingcar.domain.move.MoveCommander;
import racingcar.domain.round.boxed.CurrentRound;
import racingcar.domain.round.boxed.MaxRound;
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
        showWinners(cars);
    }

    private void playUntilMaxRound(final CarsRacing cars) {
        final MaxRound maxRound = inputView.inputMaxRound();
        _playUntilMaxRound(cars, CurrentRound.min(), maxRound);
    }

    private void _playUntilMaxRound(
            final CarsRacing cars,
            final CurrentRound currentRound,
            final MaxRound maxRound
    ) {
        if (currentRound.isAfter(maxRound)) {
            return;
        }
        cars.moveAllBy(moveCommander);
        final CarsRacingDto carsDto = cars.toCarsRacingDto();
        outputView.printRoundResult(carsDto);
        _playUntilMaxRound(cars, currentRound.nextRound(), maxRound);
    }

    private void showWinners(final CarsRacing cars) {
        final WinnersDto winnersDto = cars.toFinished().toWinnersDto();
        outputView.printGameResult(winnersDto);
    }
}
