package racingcar;

import java.util.List;

public class OutputView {
    private static final String DELIMITER = ", ";
    private static final String MESSAGE_WINNER_FORMAT = "최종 우승자 : %s";

    public void printCurrentResult(List<String> results) {
        System.out.println("실행 결과");
        for (String result : results) {
            System.out.println(result);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String names = String.join(DELIMITER, winners);
        System.out.println(String.format(MESSAGE_WINNER_FORMAT, names));
    }
}
