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

    }

    private String getCarName() {
        outputConsoleView.printAskingCarName();
        return inputConsoleView.readCarName();
    }

    private void initialParticipant(String carNames) {
        cars.addCars(carNames.split(","));
    }


}
