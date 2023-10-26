package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    public static List<Car> cars = new ArrayList<>();

    public void play() {
        OutputView.printCarNameInputMessage();
        CarController.makeCar(InputView.inputCarNames());
        OutputView.printRacingCountInputMessage();
        int racingCount = RacingCountController.makeRacingCount(InputView.inputRacingCount());
        OutputView.printRacingResultMessage();
        RacingController.racingStart(racingCount);
    }
}
