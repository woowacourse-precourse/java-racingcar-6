package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Computer;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    private List<Car> cars;
    private int playCount;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Computer computer = new Computer();
    Winner winner = new Winner();

    public void run() {
        cars = new ArrayList<>();
        addCarNames(inputView.carName());

        playCount = inputView.playNumber();

        outputView.printResultMessage();
        attemptCount();
        winner.findWinnerName(cars);
        outputView.printWinnerCarName(winner.getWinnerName());
    }

    private void addCarNames(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void attemptCount() {
        for (int attempt = 0; attempt < playCount; attempt++) {
            showMovingCars();
            outputView.printLineChange();
        }
    }

    private void showMovingCars() {
        for (Car car : cars) {
            car.moveForward(computer.getRandomNumber());
            outputView.printCarPositionMessage(car);
        }
    }
}
