package racingcar;

import java.util.ArrayList;

public class RacingGame {

    public static void initializeGame() {
        OutputView.printStartMessage();
    }

    public static void racingGame() {
        initializeGame();
        ArrayList<String> players = InputView.getCarsName();
    }
}
