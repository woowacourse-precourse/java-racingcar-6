package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.InputValidator;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarGame {
    private Car car;
    private InputValidator inputValidator;
    private List<String> carNameList;
    private int attemptNumber;
    private int[] distanceCount;

    public RacingCarGame() {
        inputValidator = new InputValidator();
    }
    public void start(){
        getNamesOfCar();
        setNamesOfCar();
        getNumberOfAttempt();
        setNumberOfAttempt();
        this.distanceCount = car.moveCarsAndPrintMovingForNumberOfAttempt(carNameList, attemptNumber);
    }
    public List<String> getNamesOfCar(){
        return inputValidator.validateNamesOfCarFromPlayer(InputView.getCarNameFromPlayer());
    }
    public void setNamesOfCar(){
        carNameList = getNamesOfCar();
        car = new Car(carNameList);
    }
    public int getNumberOfAttempt(){
        return inputValidator.validateNumberOfAttemptFromPlayer(InputView.getNumberFromPlayer());
    }

    public void setNumberOfAttempt(){
        attemptNumber = getNumberOfAttempt();
    }
}
