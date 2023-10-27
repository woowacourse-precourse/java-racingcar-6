package controller;

import model.Cars;
import view.InputView;
import view.OutputView;

public class RacingController {
    private Cars cars;

    public void playGame() {
        String[] carNames = InputView.getCarsNameFromUserInput();
        int attempt = InputView.getAttemptsFromUserInput();
        cars = new Cars(carNames);

        OutputView.displayResult();
        for (int i = 0; i < attempt; i++) {
            cars.carsPickRandomNumber();
            OutputView.displayCurrentRacingStatus(cars);
        }
        OutputView.displayFinalWinner(cars);
    }
}
