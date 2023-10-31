package racingcar.View;

import java.util.List;

public class OutputView {

    public static void printCurrentStatus(List<String> carNames, List<Integer> carpositions) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i) + " : " + "-".repeat(carpositions.get(i)));
        }
        System.out.println();
    }

    public static void printStart() {
        System.out.println("\n실행 결과");
    }

    public static void printWinner(List<String> winner) {
        System.out.print("최종 우승자 : " + String.join(", ", winner));
    }
}
