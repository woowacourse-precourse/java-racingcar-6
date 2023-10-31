package racingcar.view;

public class InputView {
    private static final String PRINT_CARNAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PRINT_TRIALNUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    public static void requestCarNames() {
        System.out.println(PRINT_CARNAMES_MESSAGE);
    }

    public static void requestTrialNumber() {
        System.out.println(PRINT_TRIALNUMBER_MESSAGE);
    }
}