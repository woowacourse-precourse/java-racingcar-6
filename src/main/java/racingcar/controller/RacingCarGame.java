package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.InputValidator;
import racingcar.model.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarGame {
    private Car car;
    private InputValidator inputValidator;
    private Referee referee;
    private List<String> carNameList;
    private int attemptNumber;
    private int[] distanceCount;

    public RacingCarGame() {
        inputValidator = new InputValidator();
    }

    public void start() {
        setNamesOfCar();
        setNumberOfAttempt();
        OutputView.printExecutionResultMessage();
        this.distanceCount = car.moveCarsAndPrintMovingForNumberOfAttempt(carNameList, attemptNumber);
        printWinner();
    }

    public List<String> getNamesOfCar() {
        return inputValidator.validateNamesOfCarFromPlayer(InputView.getCarNameFromPlayer());
    }

    public void setNamesOfCar() {
        carNameList = getNamesOfCar();
        car = new Car(carNameList);
    }

    public int getNumberOfAttempt() {
        return inputValidator.validateNumberOfAttemptFromPlayer(InputView.getNumberFromPlayer());
    }

    public void setNumberOfAttempt() {
        attemptNumber = getNumberOfAttempt();
    }

    public void printWinner() {
        referee = new Referee(distanceCount);
        OutputView.printWinner(referee.getWinner(carNameList));
    }
}
