package racingcar.controller;

import racingcar.model.MovingNumber;
import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    RacingCarsValidator racingCarsValidator = new RacingCarsValidator();
    RacingCars racingCars;
    MovingNumber movingNumber;

    public void playGame() {
        initGame();
        proceedGame();
        terminateGame();
    }

    private void initGame() {
        List<String> racingCarNames = racingCarsValidator.validateNames(inputView.inputRacingCarNames());
        racingCars = RacingCars.createRacingCars(racingCarNames);
        movingNumber = MovingNumber.createMovingNumber(inputView.inputMovingNumber());
    }

    private void proceedGame() {
        outputView.printMessageStartResult();

        for (int i = 0; i < movingNumber.getNumber(); i++) {
            racingCars.tryMoveCars();
            outputView.printResultsMoving(racingCars.getResultsMoving());
        }
    }

    private void terminateGame() {
        outputView.printWinners(racingCars.getWinners());
    }
}
