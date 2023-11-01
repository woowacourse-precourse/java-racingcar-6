package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.car.TrialCount;
import racingcar.domain.dto.CarsMovementDto;
import racingcar.domain.dto.WinnersDto;
import racingcar.move.MoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MoveStrategy moveStrategy;

    public GameController(InputView inputView, OutputView outputView, MoveStrategy moveStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.moveStrategy = moveStrategy;
    }

    public void run() {
        Cars cars = inputView.getCarsFromUserInput();
        raceWithTrials(cars);
        announceGameWinners(cars);
    }

    private void raceWithTrials(Cars cars) {
        TrialCount trialCount = inputView.getTrialCountFromUserInput();
        raceSingleTrial(cars, trialCount);
    }

    private void raceSingleTrial(Cars cars, TrialCount trialCount) {
        if (trialCount.getTrialCount() < 1) {
            return;
        }
        cars.moveOnceIfMovable(moveStrategy);
        CarsMovementDto carsMovementDto = cars.toCarsMovementDto();
        outputView.printGameResult(carsMovementDto);

        raceSingleTrial(cars, trialCount.decremented());
    }

    private void announceGameWinners(Cars cars) {
        WinnersDto winnersDto = cars.toWinnerDto();
        outputView.printGameWinner(winnersDto);
    }
}
