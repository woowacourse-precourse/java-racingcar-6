package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    private static final String ROUND_RESULT = "실행 결과";

    public static void printRoundResultMessage() {
        System.out.println(ROUND_RESULT);
    }

    public static void printRoundResult(List<String> roundResults) {
        roundResults.stream().forEach(result -> System.out.println(result));
    }

    public static void printWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
