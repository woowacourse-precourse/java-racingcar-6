package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final RacingGameService service;

    public RacingGameController() {
        this.service = new RacingGameService();
    }

    public void start() {
        List<Car> cars = service.getRacingCars(InputView.inputCarNames());
        int tryCount = InputView.inputTryCount();

        while (tryCount > 0) {
            OutputView.printResult(service.move(cars));
            tryCount--;
        }
        OutputView.printFinalWinner(service.getWinners(cars));

    }

}
