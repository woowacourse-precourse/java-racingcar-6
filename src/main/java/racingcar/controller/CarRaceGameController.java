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
        car.initCar(inputView.userInputCarNames());
    }

    private void carRace(Car car) {
        userInputRaceCount();
        printRaceResult(car, userInputRaceCount());
    }

    private int userInputRaceCount() {
        return Integer.parseInt(inputView.userInputGameCount());
    }

    private void printRaceResult(Car car, int count) {
        for (int i=0; i<count; i++) {
            car.move();
            outputView.outputCarMoveResults(car.getCarData());
        }
        printWinnerResult(car);
    }

    private void printWinnerResult(Car car) {
        List<String> winners = car.findWinners();
        outputView.outputWinnerResult(winners);
    }
}
