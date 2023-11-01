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
        OutputView.printResultMessage();
        carList = proceedRace(carList, tryCount);
        showResult(carList);
    }

    private List<Car> proceedRace(List<Car> carList, int tryCount) {
        int countCheck = 0;

        while (countCheck < tryCount) {
            carList = cars.raceCars(carList);
            OutputView.executeResult(carList);
            countCheck++;
        }
        return carList;
    }

    private void showResult(List<Car> carList) {
        List<String> winnerCarList = winner.determineWinner(carList);
        OutputView.printWinner(winnerCarList);
    }

}
