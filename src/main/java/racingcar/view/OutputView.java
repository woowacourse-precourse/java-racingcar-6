package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String PREFIX = "최종 우승자 : ";
    public static void gameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void scanNumber() {
        System.out.print("시도할 회수는 몇회인가요?");
    }

    public static void printSingleWinner(String winner) {
        System.out.println(PREFIX + winner);
    }

    public static void printMultipleWinners(List<String> winners) {
        System.out.println(PREFIX + String.join(", ", winners));
    }
}
