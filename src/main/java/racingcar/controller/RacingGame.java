package racingcar.controller;

import racingcar.constant.NumberConstant;
import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.util.Utils;
import racingcar.view.OutputView;

public class RacingGame {
    private final Cars cars;
    private final int tryCount;

    public RacingGame(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount.getTryCount();
    }

    public void run() {
        for (int i = 0; i < tryCount; i++) {
            moveCars();
            OutputView.printCarNameAndPosition(cars.getCarNamePositionMap());
        }
        OutputView.printVictoryCarNames(cars.getVictoryCarNames());
    }

    private void moveCars() {
        for (int i = 0; i < cars.size(); i++) {
            if (Utils.getRandomNumber() >= NumberConstant.TARGET_NUMBER) {
                cars.moveCar(i);
            }
        }
    }
}
