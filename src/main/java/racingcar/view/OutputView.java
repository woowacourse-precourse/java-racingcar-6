package racingcar.view;

import java.util.List;

import racingcar.MoveResult;

public class OutputView {

    public static void printRacingResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printMoveResult(MoveResult moveResult) {
        List<String> carNames = moveResult.carNames();
        List<Integer> forwardCounts = moveResult.forwardCounts();
        for (int i = 0; i < carNames.size(); i++) {
            System.out.print(carNames.get(i) + " : ");
            System.out.println("-".repeat(forwardCounts.get(i)));
        }
        System.out.print("\n");
    }

    public static void printWinners(List<String> winnerNames) {
        String joined = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + joined);
    }
}
