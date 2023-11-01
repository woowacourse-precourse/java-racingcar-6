package racingcar.view;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private static final String DELIMITER = ", ";
    private static final String PREFIX = IOMessage.FINAL_WINNER.getMessage();
    private static final String SUFFIX = "";

    public static void printMessage(IOMessage ioMessage) {
        System.out.println(ioMessage.getMessage());
    }

    public static void printExecutionResult(List<String> executionList) {
        StringBuilder playResult = new StringBuilder();
        executionList.forEach(playResult::append);
        System.out.println(playResult);
    }

    public static void printWinner(List<String> winnerList) {
        StringJoiner winner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
        winnerList.forEach(winner::add);
        System.out.println(winner);
    }
}
