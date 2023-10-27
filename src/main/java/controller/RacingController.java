package controller;

import model.Cars;
import view.InputView;
import view.OutputView;

public class RacingController {

    public void playGame() {
        Cars cars = new Cars(InputView.getCarsNameFromUserInput());
        int attempt = InputView.getAttemptsFromUserInput();

        OutputView.displayResult();
        for (int i = 0; i < attempt; i++) {
            cars.applyRandomMovingCountIncrease();
            OutputView.displayCurrentRacingStatus(cars);
        }
        OutputView.displayFinalWinner(cars);
    }
}
