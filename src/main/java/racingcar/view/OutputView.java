package racingcar.view;

public class OutputView {
    private static OutputView outputView = new OutputView();

    private OutputView() {}

    public static OutputView getInstance() {
        return outputView;
    }

    public void printResult() {
        System.out.println("\n실행 결과");
    }
}
