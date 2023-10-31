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

    public List<Car> initializeGame() {
        return service.getRacingCars(InputView.inputCarNames());
    }

    public void start() {
        List<Car> cars = initializeGame();
        String tryCount = InputView.inputTryCount();

        play(service.getTryCount(tryCount), cars);
        OutputView.printFinalWinner(service.getWinners(cars));
    }

    public void play(int tryCount, List<Car> cars) {
        while (tryCount > 0) {
            OutputView.printResult(service.move(cars));
            tryCount--;
        }
    }
}
