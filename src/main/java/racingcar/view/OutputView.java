package racingcar.view;

import java.util.List;

public class OutputView {

    public static void printRacingResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printRacingResult(List<String> carNames, List<Integer> forwardCounts) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.print(carNames.get(i) + " : ");
            for (int j = 0; j < forwardCounts.get(i); j++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }
    }
}
