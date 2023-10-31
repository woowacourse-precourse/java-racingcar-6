package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarStatus;
import racingcar.dto.WinnerResult;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

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
        OutputView.newLine();
        OutputView.printResultMessage();

        for (int i = 0; i < tryCount.value(); i++) {
            cars.tryRun();
            OutputView.printCurrentCarStatus(getCurrentCarsStatus(cars.getCars()));
        }
    }

    private List<CarStatus> getCurrentCarsStatus(List<Car> cars) {
        return cars.stream()
                .map(CarStatus::new)
                .collect(Collectors.toList());
    }

    private WinnerResult getWinnerResult(Winner winner) {
        return new WinnerResult(winner);
    }

    private String getCarNames() {
        OutputView.printRaceStart();
        return InputView.readConsole();
    }

    private Cars createCars(String names) {
        Cars cars = new Cars(names);
        return cars;
    }

    private String getTryCount() {
        OutputView.printTryCount();
        return InputView.readConsole();
    }

    private TryCount createTryCount(String count) {
        return new TryCount(count);
    }
}