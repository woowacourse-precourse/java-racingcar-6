package racingcar;

public class OutputView {
    private final String RESULT_MESSAGE = "실행 결과";
    private final String FINAL_WINNER = "최종 우승자 : ";
    private final String DELIMITER = ",";
    private final String COLON = " : ";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }
}
