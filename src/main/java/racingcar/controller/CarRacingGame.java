package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.view.InputConsoleView;
import racingcar.view.OutputConsoleView;

public class CarRacingGame {

    private final InputConsoleView inputConsoleView;
    private final OutputConsoleView outputConsoleView;
    private final Cars cars;
    private int numberOfTrial;

    public CarRacingGame() {
        inputConsoleView = new InputConsoleView();
        outputConsoleView = new OutputConsoleView();
        cars = new Cars();
    }

    public void run() {

        initialParticipant(getCarName());
        initialNumberOfTrial(getNumberOfTrial());

    }

    private String getCarName() {
        outputConsoleView.printAskingCarName();
        return inputConsoleView.readCarName();
    }

    private String getNumberOfTrial() {
        outputConsoleView.printAskingNumberOfTrial();
        return inputConsoleView.readNumberOfTrial();
    }

    private void initialParticipant(String carNames) {
        cars.addCars(carNames.split(","));
    }

    private void initialNumberOfTrial(String number) {
        numberOfTrial = Integer.parseInt(number);
    }


}
