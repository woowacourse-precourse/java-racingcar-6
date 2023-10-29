package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.CarNames;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void runGame() {
        CarNames carNames = CarNames.from(inputView.readCarNames());
        TryCount tryCount = new TryCount(inputView.readTryCount());
        Cars cars = Cars.from(carNames);
        startRace(cars, tryCount);
        printWinners(cars);
    }

    private void startRace(Cars cars, TryCount tryCount) {
        outputView.printRaceResultMessage();
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            cars.move();
            outputView.printCurrentRaceStatus(cars);
        }
    }

    private void printWinners(Cars cars){
        List<CarName> winnerCarNames = getWinnerCarNames(cars.getWinnerCars());
        outputView.printRaceResult(winnerCarNames);
    }

    public List<CarName> getWinnerCarNames(List<Car> winnerCars){
        return winnerCars.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
