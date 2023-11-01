package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String PARTITION = " : ";
    private static final String ONE_MOVE = "-";

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printMoveResult(Map<String, Integer> moveResults) {
        System.out.println("\n실행 결과");
        moveResults.keySet().forEach(carName -> printEachMove(carName, moveResults.get(carName)));
    }

    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    private static void printEachMove(String carName, int moveCount) {
        if (moveCount == 0) {
            System.out.println(carName + PARTITION);
            return;
        }
        System.out.print(carName + PARTITION);
        for (int i = 0; i < moveCount; i++) {
            System.out.print(ONE_MOVE);
        }
        System.out.println();
    }
}