package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Racing {
    private Cars cars;
    private int movementTime;
    private final InputView inputView;
    private final OutputView outputView;

    public Racing() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startRace() {
        registerCars();
        registerMovementTime();

        outputView.printExecutionResultsInfo();
        for (int turn = 0; turn < this.movementTime; turn++) {
            race();
        }

        getFinalWinners();
    }

    private void registerCars() {
        outputView.printCarNamesInput();
        List<String> carNames = inputView.getCarNames();
        this.cars = new Cars(carNames);
    }

    private void registerMovementTime() {
        outputView.printMovementInfoInput();
        this.movementTime = inputView.getMovementTime();
    }

    private void race() {
        for (Car car : this.cars.getCarList()) {
            car.moveForward();
        }
        outputView.printExecutionResultsOrder(this.cars.getCarList());
    }

    private void getFinalWinners() {
        outputView.printFinalWinners(this.cars.getMostForwardedCars());
    }
}
