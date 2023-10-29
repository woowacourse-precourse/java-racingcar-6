package racingcar.view;

import racingcar.view.enums.Message;

public class OutputView {
    public static void printStartMessage() {
        System.out.println(Message.START_MESSAGE);
    }

    public static void printPlayRound() {
        System.out.println(Message.PLAY_ROUND_MESSAGE);
    }

    public static void printPlayResult() {
        System.out.println(Message.PLAY_RESULT_MESSAGE);
    }

}
