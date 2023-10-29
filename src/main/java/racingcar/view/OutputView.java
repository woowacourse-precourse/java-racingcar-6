package racingcar.view;

public class OutputView {
    private static final String RACE_RESULT_MESSAGE = "실행 결과";
    private static final String GAP = "\n";

    public static void printRaceResult() {
        System.out.println(GAP + RACE_RESULT_MESSAGE);
    }
}
