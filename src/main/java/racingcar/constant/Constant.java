package racingcar.constant;

public final class Constant {
    public static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String PLAY_TIME_QUESTION = "시도할 회수는 몇회인가요?";
    public static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    public static final String GAME_WINNER_MESSAGE = "최종 우승자 : ";
    public static final Integer RANDOM_NUMBER_MIN = 0;
    public static final Integer RANDOM_NUMBER_MAX = 9;
    public static final Integer MOVE_LOWER_BOUND = 4;
    public static final Integer CAR_NAME_MAX_SIZE = 5;
    public static final Integer ZERO = 0;
    public static final Integer MAX_VALUE = 100_000;
    public static final Character CAR_MOVE_MARK = '-';
    public static final Integer REQUIRE_EXECUTION_RESULT_MESSAGE = -1;

    private Constant() {
    }
}
