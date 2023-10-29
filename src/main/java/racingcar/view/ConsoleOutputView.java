package racingcar.view;

public class ConsoleOutputView implements OutputView {
    private static final String EXECUTION_RESULT_LABEL = "실행 결과";
    private static final String WINNER_LABEL = "최종 우승자 : ";

    @Override
    public void outputExcutionResult() {
        System.out.println(EXECUTION_RESULT_LABEL);
    }

    @Override
    public void outputWinner() {
        System.out.println(WINNER_LABEL);
    }
}
