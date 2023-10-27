package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Driver;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void play() {
        Cars cars = createCars();
        int totalRound = inputView.totalRound();
        race(cars, totalRound);
        selectWinner(cars);
    }

    private void race(Cars cars, int totalRound) {
        outputView.printResultGuideMessage();
        for (int currentRound = 0; currentRound < totalRound; currentRound++) {
            proceedCurrentRound(cars);
            outputView.printRoundSeparator();
        }
    }

    private void proceedCurrentRound(Cars cars) {
        for (Car car : cars) {
            Driver driver = new Driver();
            driver.drive(car);
            outputView.printMoveRecord(car.getName(), car.getMoveDistance());
        }
    }

    private void selectWinner(Cars cars) {
        outputView.printWinners(cars.getWinnersName());
    }

    private Cars createCars() {
        return new Cars(inputView.carsName());
    }
}
