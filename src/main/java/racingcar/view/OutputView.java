package racingcar.view;

import racingcar.constant.Message;

public class OutputView {
    public static void printTryResult() {
        System.out.println(Message.TRY_RESULT.getMessage());
    }

    public static void printUpdatedResult(String updatedResult) {
        System.out.println(updatedResult);
        System.out.println();
    }

    public static void printWinners(String winners) {
        System.out.print(Message.FINAL_WINNERS.getMessage());
        System.out.print(winners);
    }
}