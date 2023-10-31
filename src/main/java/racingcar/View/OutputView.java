package racingcar.View;

import java.util.List;
public class OutputView {
    public static void printExecutionResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printExecutionMessage(String name, int position) {
        System.out.println(name + " " + "-".repeat(position));
    }

    public static void printWinnerMessage(List<String> winners) {
        System.out.print("최종 우승자 :" + String.join(", ", winners));
    }
}
