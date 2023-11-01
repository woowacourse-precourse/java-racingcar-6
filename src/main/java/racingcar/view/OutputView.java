package racingcar.view;


public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_INFO_MESSAGE = "최종 우승자 : ";

    public void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public void printGameResult(String result) {
        System.out.print(result);
    }

    public void printGameWinner(String winner) {
        System.out.print(WINNER_INFO_MESSAGE);
        System.out.println(winner);
    }
}
