package racingcar.controller;

import racingcar.model.MovingNumber;
import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    public void playGame() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingCarsValidator racingCarsValidator = new RacingCarsValidator();

        List<String> racingCarNames = racingCarsValidator.validateNames(inputView.inputRacingCarNames());
        RacingCars racingCars = RacingCars.createRacingCars(racingCarNames);
        MovingNumber movingNumber = MovingNumber.createMovingNumber(inputView.inputMovingNumber());
        outputView.printMessageStartResult();

        for (int i = 0; i < movingNumber.getNumber(); i++) {
            racingCars.tryMoveCars();
            outputView.printResultsMoving(racingCars);
        }

        outputView.printWinners(racingCars.getWinners());
    }
}
