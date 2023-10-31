package racingcar.View;

import java.util.List;

public class OutputView {

    public static void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printTryNumberMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

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
