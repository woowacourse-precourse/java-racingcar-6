package racingcar.view;

public class OutputView {

    private static final String ENTER_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_ATTEMPTS_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String ONE_STEP = "-";
    private static final String RESULT_MESSAGE = "실행 결과";

    public static void enterCarNames() {
        System.out.println(ENTER_CAR_NAME_MESSAGE);
    }

    public static void enterAttempts() {
        System.out.println(ENTER_ATTEMPTS_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }
}
