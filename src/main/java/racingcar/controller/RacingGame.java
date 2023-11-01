package racingcar.controller;

import java.util.List;
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
        OutputView.printVictoryCarNames(getVictoryCarName());
    }

    public List<String> getVictoryCarName() {
        return cars.getCarNamesAtPosition(cars.getMaxPosition());
    }

    public void moveCars() {
        for (int index = 0; index < cars.size(); index++) {
            moveCarOrNot(index, Utils.getRandomNumber());
        }
    }

    public void moveCarOrNot(int index, int randomValue) {
        if (randomValue >= NumberConstant.TARGET_NUMBER) {
            cars.moveCar(index);
        }
    }
}
