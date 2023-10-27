package racingcar.view;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";

    public void printResultMessage() {
        newLine();
        System.out.println(RESULT_MESSAGE);
    }

    private void newLine() {
        System.out.println();
    }
}
