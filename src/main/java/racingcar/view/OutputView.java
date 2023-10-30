package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String MOVE_SYMBOL = "-";

    public static void printRacingResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printMoveResult(List<String> carNames, List<Integer> forwardCounts) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.print(carNames.get(i) + " : ");
            System.out.println(MOVE_SYMBOL.repeat(forwardCounts.get(i)));
        }
        System.out.print("\n");
    }

    public static void printWinners(List<String> winnerNames) {
        String joined = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + joined);
    }
}
