package racingcar.constants;

public final class Constants {

    // Car
    public static final int CAR_MAX_NAME_LENGTH = 5;
    public static final String CAR_NAME_EXCEED_ERROR_MSG = "이름은 5글자를 초과할 수 없습니다.";

    // Race
    public static final String EXECUTION_RESULT = "\n실행 결과";
    public static final String LAB_MSG = "# LAB ";
    public static final int RANDOM_START = 0;
    public static final int RANDOM_END = 9;
    public static final int MOVE_THRESHOLD = 4;

    // View
    public static final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ROUND_COUNT_PROMPT = "시도할 회수는 몇회인가요?";
    public static final String INVALID_INPUT_MSG = "양의 정수값만 입력해주세요.";
    public static final String WINNERS_MSG = "\n최종 우승자 : ";

    private Constants() {
    }
}
