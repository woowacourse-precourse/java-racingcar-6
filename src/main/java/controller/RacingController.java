package controller;

import camp.nextstep.edu.missionutils.Console;
import model.Cars;
import view.InputView;
import view.OutputView;

public class RacingController {

    private static final int MINIMUM_NUMBER = 4;

    public void playGame() {
        Cars cars = new Cars(InputView.getCarsNameFromUserInput());
        int attempt = InputView.getAttemptsFromUserInput();

        OutputView.displayResult();
        for (int i = 0; i < attempt; i++) {
            cars.updateMovingCounts(MINIMUM_NUMBER);
            OutputView.displayCurrentRacingStatus(cars);
        }
        OutputView.displayFinalWinner(cars);
        Console.close();
    }
}
