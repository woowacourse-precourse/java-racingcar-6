package racingcar.view;

import racingcar.util.Message;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printGameStartMessage() {
        printMessage(Message.NAME_INPUT_MESSAGE);
    }

    public static void printInputNumberMessage() {
        printMessage(Message.COUNT_INPUT_MESSAGE);
    }

    public static void printRoundResultMessage() {
        // 따로 함수로 라운드 결과를 종합하는 것 만들기??
        printMessage(Message.ROUND_RESULT);
    }

    public static void printGameResultMessage() {
        // 최종 우승자를 선정하는 것 함수 만들기??
        printMessage("");
    }
}
