package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private Cars cars = new Cars();
    private Winner winner = new Winner();

    public void proceedGame() {
        List<Car> carList = cars.setPlayer(InputView.carsName());
        int tryCount = InputView.tryCount();
        race(carList, tryCount);
    }

    private void race(List<Car> carList, int tryCount) {
        int countCheck = 0;

        OutputView.printResultMessage();

        while (countCheck < tryCount) {
            carList = cars.raceCars(carList);
            OutputView.executeResult(carList);
            countCheck++;
        }

        List<String> winnerCarList = winner.determineWinner(carList);
        OutputView.printWinner(winnerCarList);

    }

}
