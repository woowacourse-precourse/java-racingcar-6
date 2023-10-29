package racingcar.view;

public class OutputView {

    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자";

    public static void carNameInput() {
        print(CAR_NAME_MESSAGE);
    }
    public static void attemptCountInput() {
        print(ATTEMPT_COUNT_MESSAGE);
    }
    public static void executionResultView() {
        print(EXECUTION_RESULT);
    }
    public static void lastWinnerView() {
        print(FINAL_WINNER);
    }
    public static void print(String message) {
        System.out.println(message);
    }

}
