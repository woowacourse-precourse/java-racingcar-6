package racingcar.constant;

public final class GameMessage {
    private GameMessage() {
    }

    public static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String GAME_MOVE_CNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static final String GAME_RESULT_MESSAGE = "\n실행 결과";
    public static final String EACH_MOVE_RESULT_MESSAGE = "%s : %s\n";
    public static final String GAME_WINNER_MESSAGE = "최종 우승자 : %s";
    public static final String DASH = "-";

    public static final int CAR_NAME_LENGTH_MAX_SIZE = 5;

    public static final int MOVE_CNT_MIN_SIZE = 0;

    public static final int GO_RAND_NUM_MIN_SIZE = 0;
    public static final int GO_RAND_NUM_MAX_SIZE = 9;
    public static final int GO_MIN_VALUE = 4;
}