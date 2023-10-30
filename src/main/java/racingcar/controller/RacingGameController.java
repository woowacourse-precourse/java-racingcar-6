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

    public void play(int tryCountNumber, List<Car> cars) {
        while (tryCountNumber > 0) {
            OutputView.printResult(service.move(cars));
            tryCountNumber--;
        }
    }
}
