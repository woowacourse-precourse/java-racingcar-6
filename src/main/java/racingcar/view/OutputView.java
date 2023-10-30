package racingcar.view;

public class OutputView {

    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String COLON = " : ";

    // 상수랑 상수를 출력시키는 함수는 별도로 관리하는게 좋지 않을까용
    public static void carNameInput() {
        System.out.println(CAR_NAME_MESSAGE);
    }
    public static void attemptCountInput() {
        System.out.println(ATTEMPT_COUNT_MESSAGE);
    }
    public static void executionResultView() {
        System.out.println(EXECUTION_RESULT);
    }
    public static void finalWinnerView() {
        System.out.print(FINAL_WINNER);
    }
    public static void blankLine() {
        System.out.println();
    }
    public static void colon() {
        System.out.print(COLON);
    }

}
