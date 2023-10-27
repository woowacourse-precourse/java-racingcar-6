package racingcar.view;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";

    public void printNameAndRecord(String result) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(result);
    }
}
