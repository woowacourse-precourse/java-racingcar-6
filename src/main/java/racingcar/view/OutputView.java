package racingcar.view;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public void printNameAndRecord(String result) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(result);
    }

    public void printWinnerName(String winnerName) {
        System.out.print(WINNER_MESSAGE);
        System.out.println(winnerName);
    }
}
