package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    public void startGame() {
        OutputView.printStartGameMessage();
        List<String> carstr = InputView.inputCarNames();
        List<Car> cars = RacingCarService.convertCarNames(carstr);
        OutputView.printAttempNumMessage();
        int attempNum = InputView.inputAttempNum();

        OutputView.printResultMessage();
        for (int i = 0; i < attempNum; i++) {
            RacingCarService.raceCar(cars);
            OutputView.printAttempResult(cars);
        }

        List<Car> winners = RacingCarService.calculatWinner(cars);
        OutputView.printWinners(winners);
    }
}
