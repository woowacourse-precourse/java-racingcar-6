package racingcar;

public class OutputView {
    private static final String RUNNING_RESULT = "\n실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public static void noticeRunningResult() {
        System.out.println(RUNNING_RESULT);
    }

    public static void printPerMoveResult(String winner) {
        System.out.println(winner);
    }

    public static void noticeFinalWinner() {
        System.out.print(FINAL_WINNER);
    }
}
