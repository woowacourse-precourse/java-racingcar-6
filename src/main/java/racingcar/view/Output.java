package racingcar.view;

public class Output {
    private static final String NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_INPUT = "시도할 회수는 몇회인가요?";
    private static final String ATTEMPT_RESULT = "실행 결과";
    private static final String WINNER = "최종 우승자";

    private Output() {
    }

    public static void nameInputMessage() {
        System.out.println(NAME_INPUT);
    }

    public static void attemptInputMessage() {
        System.out.println(ATTEMPT_INPUT);
    }

    public static void attemptResultMessage() {
        System.out.println(ATTEMPT_RESULT);
    }

    public static void winnerMessage() {
        System.out.println(WINNER);
    }
}
