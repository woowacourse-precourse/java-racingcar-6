package racingcar;

import racingcar.Controller.RacingGame;

import static racingcar.view.OutputView.printErrorMessage;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();

        try {
            racingGame.start();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
        }
    }
}
