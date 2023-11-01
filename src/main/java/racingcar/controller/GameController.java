package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private Cars cars = new Cars();

    public void proceedGame() {
        List<Car> carList = cars.setPlayer(InputView.carsName());
        int tryCount = InputView.tryCount();
        race(carList, tryCount);
    }

    private void race(List<Car> carList, int tryCount) {
        int countCheck = 1;

        while (countCheck < tryCount) {
            carList = cars.raceCars(carList);
            OutputView.executeResult(carList);
            countCheck ++;
        }


    }

}
