package racingcar.view;

public class OutputView {
    private static final String RACING_RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_RESULT_MESSAGE = "최종 우승자 : %s";

    public void printRacingResult(final String result) {
        System.out.println(RACING_RESULT_MESSAGE);
        System.out.println(result);
    }

    public void printWinnerResult(final String result) {
        System.out.printf((WINNER_RESULT_MESSAGE), result);
    }
}
