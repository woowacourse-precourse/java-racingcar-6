package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Driver;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    InputView inputView;
    OutputView outputView;

    public RacingcarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
    
    public void play() {
        Cars cars = createCars();
        int totalRound = inputView.inputTotalRound();
        race(cars, totalRound);
        selectWinner(cars);
    }

    private Cars createCars() {
        return new Cars(inputView.inputCarsName());
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
            outputView.printMoveRecord(car.getName(), car.getPosition());
        }
    }

    private void selectWinner(Cars cars) {
        outputView.printWinners(cars.getWinnersName());
    }
}
