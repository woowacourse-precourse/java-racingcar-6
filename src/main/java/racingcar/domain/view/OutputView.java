package racingcar.domain.view;

import racingcar.domain.util.OutputMessage;

public class OutputView {
    public static void printEndGame() {
        System.out.println(OutputMessage.PRINT_FINAL_WINNER.getMessage());
    }

    public static void printRoundResult() {
        System.out.println(OutputMessage.PRINT_ROUND_RESULT.getMessage());
    }
}
