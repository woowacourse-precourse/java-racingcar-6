package racingcar.controller;

import racingcar.domain.NameValidation;
import racingcar.domain.NumberValidation;
import racingcar.domain.RacingGame;
import racingcar.utils.Util;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class RaceManager {

    private RacingGame racingGame;
    private int attemptNumber;

    public void setCarNames() {
        try {
            String names = InputView.inputName();
            new NameValidation(names).validation();
            ArrayList<String> nameList = Util.toArrayList(names);
            racingGame = new RacingGame(nameList);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void setAttemptNumber() {
        try {
            String attempts = InputView.inputAttempt();
            new NumberValidation(attempts).isCorrectPattern();
            this.attemptNumber = Integer.parseInt(attempts);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void printResult() {
        OutputView.printResultMessage();
        for (int i = 0; i < attemptNumber; i++) {
            OutputView.printResultPerAttempt(racingGame.getResultPerAttempt());
        }
    }

    public void printWinner() {
        OutputView.printWinner(racingGame.getWinner());
    }

}
