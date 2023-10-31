package racingcar;

import java.util.List;

public class OutputView {
    public static void printExecutionResultInKorean() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printCarMovement(String name, int movedLately) {
        System.out.println(name + " : " + "-".repeat(movedLately));
    }

    public static void printResult(List<String> winnerCarNames) {
        System.out.println();
        System.out.print("최종 우승자 : " + String.join(", ", winnerCarNames));
    }
}
