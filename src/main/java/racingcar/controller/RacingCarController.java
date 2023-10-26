package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class RacingCarController {

    public static List<Car> cars = new ArrayList<>();

    public void start() {
        OutputView.printCarNameInputMessage();
        CarController.makeCar(InputView.inputCarNames());
        OutputView.printRacingCountInputMessage();
    }
}
