package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import static racingcar.controller.CarController.cars;

public class GameController {

    public void play() {
        OutputView.printCarNameInputMessage();
        CarController.makeCar(InputView.inputCarNames());
        OutputView.printRacingCountInputMessage();
        int racingCount = RacingCountController.makeRacingCount(InputView.inputRacingCount());
        OutputView.printRacingResultMessage();
        RacingController.startRacing(cars, racingCount);
        RacingController.showRacingWinner(cars);
    }
}
