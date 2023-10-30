package racingcar.view;

public class OutputView {
    private static final String BEFORE_RACE_MESSAGE = "실행 결과";

    public static void beforeRaceMessage() {
        printEmptyLine();
        System.out.println(BEFORE_RACE_MESSAGE);
    }

    private static void printEmptyLine() {
        System.out.println();
    }

}
