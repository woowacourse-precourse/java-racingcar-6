package racingcar.service;

import racingcar.controller.RandomMoveController;
import racingcar.model.Cars;
import racingcar.model.Trial;
import racingcar.model.dto.WinnerDTO;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCar {
    private final Cars cars;
    private final Trial trial;

    public RacingCar() {
        this.cars = insertCarNamesAndgetCars();
        this.trial = insertNumOfTrial();
    }

    private Cars insertCarNamesAndgetCars() {
        String input = InputView.insertCarNames();
        return new Cars(input);
    }

    private Trial insertNumOfTrial() {
        String input = InputView.insertNumOfTrial();
        return new Trial(input);
    }

    public void doMoveForward() {
        RandomNumbers randomNumbers;
        RandomMoveController randomMoveController;
        OutputView.printTrialStartMessage();
        for (int i = 0; trial.compare(i); i++) {
            randomNumbers = new RandomNumbers(cars.size());
            randomMoveController = new RandomMoveController(randomNumbers);
            randomMoveController.moveForward(cars);
            OutputView.printCarsStatus(cars);
        }
    }

    public void printWinners() {
        WinnerDTO winnerDTO = Winner.getWinners(cars);
        OutputView.printWinners(winnerDTO);
    }
}
