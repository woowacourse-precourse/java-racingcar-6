package Controller;

import domain.Car;
import domain.CarName;
import domain.Cars;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingController {
    Cars cars = new Cars();

    public void startGame() {
        initCars();

        OutputView.printResultStartMessage();
        while (!cars.isCompleted()) {
            tryOnce();
        }

        OutputView.printWinnerMessage(cars.findWinner());
    }

    public void initCars() {
        InputView.inputCarNames().forEach(name
                -> cars.insertCar(new Car(new CarName(name))));
        cars.setTryCount(InputView.inputTryCount());
    }

    public void tryOnce() {
        cars.moveAllCar();
        OutputView.printScores(cars.getScores());
    }
}
