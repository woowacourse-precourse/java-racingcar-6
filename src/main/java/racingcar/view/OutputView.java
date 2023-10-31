package racingcar.view;

import racingcar.message.NoticeMessage;

public class OutputView {

    public static void printRaceStart() {
        System.out.println(NoticeMessage.RACE_START_MESSAGE);
    }

    public static void printTryCount() {
        System.out.println(NoticeMessage.TRY_COUNT_MESSAGE);
    }

    public static void printWinners(String winners) {
        System.out.println(NoticeMessage.FINAL_WINNER_MESSAGE + winners);
    }

    public static void printResultMessage() {
        System.out.println(NoticeMessage.RESULT_MESSAGE);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void newLine() {
        System.out.println();
    }
}