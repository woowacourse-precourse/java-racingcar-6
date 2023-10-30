package racingcar.controller;

import racingcar.model.MovingNumber;
import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void playGame() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        RacingCars racingCars = RacingCars.createRacingCars(inputView.inputRacingCarNames());
        MovingNumber movingNumber = MovingNumber.createMovingNumber(inputView.inputMovingNumber());
        outputView.printMessageStartResult();

        for (int i = 0; i < movingNumber.getNumber(); i++) {
            racingCars.tryMoveCars();
        }
    }
}
