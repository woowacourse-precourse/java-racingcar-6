package racingcar.view;

public class Output {
    private static final String NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String ATTEMPT_RESULT = "실행 결과";
    private static final String WINNER = "최종 우승자";

    private Output() {
    }

    public static void carNameInputMessage() {
        System.out.println(NAME_MESSAGE);
    }

    public static void attemptInputMessage() {
        System.out.println(ATTEMPT_MESSAGE);
    }

    public static void attemptResultMessage() {
        System.out.println(ATTEMPT_RESULT);
    }

    public static void winnerMessage() {
        System.out.println(WINNER);
    }

    public static void getError(String message) {
        System.out.println(message);
    }
}
