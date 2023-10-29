package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startProgram() {
        startRace(initCars());
    }

    public RacingCars initCars() {
        return new RacingCars(getCarName());
    }

    private List<String> getCarName() {
        return inputView.inputCarName();
    }

    private void startRace(RacingCars racingCars) {
        printMoveResult(racingCars);
        printRaceResult(racingCars);
    }

    private int getTryNumber() {
        return inputView.inputTryNumber();
    }

    private void printMoveResult(RacingCars racingCars) {
        outputView.outputExecutionResult();
        for (int tryNumber = getTryNumber(); tryNumber > 0; tryNumber--) {
            racingCars.moveCars();
            printMoveString(racingCars);
        }
    }

    private void printMoveString(RacingCars racingCars) {
        for (RacingCar car : racingCars.getCarList()) {
            outputView.outputMoveResult(car.getName(), car.getDashString());
        }
        outputView.outputBlank();
    }

    private void printRaceResult(RacingCars racingCars) {
        List<String> maxMoveCarsName = racingCars.getMaxMoveCarsName();
        outputView.outputRaceResult(maxMoveCarsName);
    }
}
