package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String RUNNING_RESULT = "\n실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public static void noticeRunningResult() {
        System.out.println(RUNNING_RESULT);
    }

    public static void printPerMoveResult(String winner) {
        System.out.println(winner);
    }

    public static void noticeFinalWinner() {
        System.out.print(FINAL_WINNER);
    }

    public static void printWinnerNames(List<String> winnerList) {
        String winners = winnerList.stream()
                .collect(Collectors.joining(", "));

        System.out.print(winners);
    }
}
