package racingcar.controller;

import racingcar.model.GameManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    public static void runApp() {

        String carNamesInput = InputView.getCarNames();
        String numberOfRoundInput = InputView.getNumberRound();

        String[] carNames = carNamesInput.split(",");
        int numberOfRounds = Integer.parseInt(numberOfRoundInput);

        GameManager gameManager = GameManager.create();
        for (String name : carNames) {
            gameManager.addCar(name);
        }

        for (int round = 0; round < numberOfRounds; round++) {
            gameManager.moveAllCars();
        }

        OutputView.printRaceResultHeader();
        OutputView.printCarProgress(gameManager);
        OutputView.printWinner(gameManager);
    }
}
