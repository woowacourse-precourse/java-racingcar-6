package racingcar;

public class OutputView {
    private static final String RUNNING_RESULT = "\n실행 결과";

    public static void noticeRunningResult() {
        System.out.println(RUNNING_RESULT);
    }

    public static void printPerMoveResult(String winner) {
        System.out.println(winner);
    }
}
