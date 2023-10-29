package racingcar.controller;

import java.util.List;
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
        printWinners();
    }

    private void startRace(Cars cars, TryCount tryCount) {
        outputView.printRaceResultMessage();
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            cars.move();
            outputView.printCurrentRaceStatus(cars);
        }
    }

    private void printWinners(){
        // TODO: 우승자들 출력
    }
}
