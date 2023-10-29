package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.CarRace;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    public void startGame() {
        OutputView.printStartGameMessage();
        List<String> carstr = InputView.inputCarNames();
        List<Car> cars = CarRace.formatCarNames(carstr);
        OutputView.printAttempNumMessage();
        int attempNum = InputView.inputAttempNum();
    }
}
