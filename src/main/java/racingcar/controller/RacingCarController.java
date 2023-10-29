package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    public void startGame() {
        OutputView.printStartGameMessage();
        List<Car> cars = InputView.inputCarNames();
}
