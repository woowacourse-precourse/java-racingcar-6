package racingcar.domain;

import java.util.List;

public class OutputView {
    public static void printCarsMovementHeadline() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printCarMovement(String name, int movedLately) {
        System.out.println(name + " : " + "-".repeat(movedLately));
    }

    public static void printWinnerNames(List<String> winnerNames) {
        System.out.println();
        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }
}
