package racingcar.view;

import racingcar.Constants;

public class OutputView {
    public static void printGameResult() {
        System.out.println(Constants.OUTPUT_GAME_RESULT);
    }

    public static void printGameWinner(String winner) {
        System.out.print(Constants.OUTPUT_GAME_WINNER + winner);
    }
}
