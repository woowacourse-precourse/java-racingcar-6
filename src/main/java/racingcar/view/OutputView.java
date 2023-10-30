package racingcar.view;

public class OutputView {

    private static final String ROUND_PROGRESS = "실행 결과\n";

    public void printRoundResult(String roundResult) {
        System.out.println(ROUND_PROGRESS + roundResult);
    }
}
