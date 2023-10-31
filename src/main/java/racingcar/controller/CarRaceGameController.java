package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarRaceGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public CarRaceGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        gameSetting();
    }

    private void gameSetting() {
        Car car = new Car();
        raceGame(car);
    }

    private void raceGame(Car car) {
        cartSetting(car);
        carRace(car);
    }

    private void cartSetting(Car car) {
        car.initCar(inputView.userInputCarName());
    }

    private void carRace(Car car) {
        userInputRaceCount();
        carMoveResult(car, userInputRaceCount());
    }

    private int userInputRaceCount() {
        return Integer.parseInt(inputView.userInputGameCount());
    }

    private void carMoveResult(Car car, int count) {
        for (int i=0; i<count; i++) {
            car.move();
            outputView.outputCarMoveResult(car.getCarData());
        }
        printWinnerResult(car);
    }

    private void printWinnerResult(Car car) {
        List<String> winners = car.findWinner();
        outputView.outputWinnerResult(winners);
    }
}
