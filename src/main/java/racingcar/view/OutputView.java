package racingcar.view;

import racingcar.constant.GameMessage;

public class OutputView {
    public static void printStartMessage() {
        System.out.println(GameMessage.GAME_START_MESSAGE.getMessage());
    }

    public static void printTryNumMessage() {
        System.out.println(GameMessage.TRY_NUMBER_MESSAGE.getMessage());
    }

    public static void printResultMessage() {
        System.out.println();
        System.out.println(GameMessage.RESULT_MESSAGE.getMessage());
    }
}
