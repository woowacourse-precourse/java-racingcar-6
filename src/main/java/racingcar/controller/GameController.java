package racingcar.controller;

import racingcar.domain.dto.CarsMovementDto;
import racingcar.domain.dto.WinnersDto;
import racingcar.domain.game.car.Cars;
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
        startGameWithTrials(cars);
        announceGameWinners(cars);
    }

    private void startGameWithTrials(Cars cars) {
        int trialCount = inputView.getTrialFromUserInput();
        for (int i = 1; i <= trialCount; i++) {
            cars.moveOnceIfMovable(moveStrategy);
            CarsMovementDto carsMovementDto = cars.toCarsMovementDto();
            outputView.printGameResult(carsMovementDto);
        }
    }

    private void announceGameWinners(Cars cars) {
        WinnersDto winnersDto = cars.toWinnerDto();
        outputView.printGameWinner(winnersDto);
    }
}
