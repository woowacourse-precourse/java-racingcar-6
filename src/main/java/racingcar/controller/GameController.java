package racingcar.controller;

import java.util.List;
import racingcar.dto.CarStatus;
import racingcar.dto.WinnerResult;
import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.model.Winner;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void start() {
        String names = getCarNames();
        Cars cars = createCars(names);
        String count = getTryCount();
        TryCount tryCount = createTryCount(count);

        raceOn(cars, tryCount);

        Winner winners = new Winner(cars);
        OutputView.printWinners(getWinnerResult(winners));
    }

    private void raceOn(Cars cars, TryCount tryCount) {
        OutputView.printResultMessage();

        for (int i = 0; i < tryCount.value(); i++) {
            gameService.tryRunCars(cars);
            printCarStatusOfRace(cars);
        }
    }

    private void printCarStatusOfRace(Cars cars) {
        List<CarStatus> carStatusOfRace = gameService.getCarStatusOfRace(cars);
        OutputView.printCarStatusOfRace(carStatusOfRace);
    }

    private WinnerResult getWinnerResult(Winner winner) {
        return new WinnerResult(winner);
    }

    private String getCarNames() {
        OutputView.printRaceStart();
        return InputView.readConsole();
    }

    private Cars createCars(String names) {
        return new Cars(names);
    }

    private String getTryCount() {
        OutputView.printTryCount();
        return InputView.readConsole();
    }

    private TryCount createTryCount(String count) {
        return new TryCount(count);
    }
}