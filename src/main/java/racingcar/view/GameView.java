package racingcar.view;

import racingcar.constant.GameMessage;

public class GameView {
    public static void askCarName() {
        System.out.println(GameMessage.INPUT_CAR_MESSAGE);
    }

    public static void askCount() {
        System.out.println(GameMessage.INPUT_COUNT_MESSAGE);
    }

    public static void printResult() {
        System.out.println(GameMessage.RESULT_MESSAGE);
    }

    public static void printWinner() {
        System.out.println(GameMessage.WINNER_MESSAGE);
    }
}
