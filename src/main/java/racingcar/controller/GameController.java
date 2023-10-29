package racingcar.controller;

import racingcar.domain.dto.CarsMovementDto;
import racingcar.domain.dto.WinnersDto;
import racingcar.domain.game.car.Cars;
import racingcar.util.MoveStrategy;
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
        int trial = inputView.getTrialFromUserInput();
        WinnersDto winnersDto = playGame(trial, cars);
        outputView.printGameWinner(winnersDto);
    }

    private WinnersDto playGame(int trial, Cars cars) {
        for (int i = 1; i <= trial; i++) {
            CarsMovementDto carsMovementDto = cars.moveOnce(moveStrategy);
            outputView.printGameResult(carsMovementDto);
        }
        return cars.toWinnerDto();
    }
}
