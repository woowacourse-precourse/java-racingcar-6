package racingcar.constant;

public class Constants {
    public static final String DISTANCE_CHARACTER = "-";
    public static final String KEY_VALUE_SEPARATOR = " : ";
    public static final String VALUE_SEPARATOR = ", ";

    public static final String DIVIDE_BY_COMMA = "\\s*,\\s*";
    public static final String INVALID_CHARACTER = ".*[^a-zA-Z0-9 ,].*";
    public static final String VALID_NUMBER = "[1-9][0-9]*";

    public static final int MAX_RANDOM_NUM = 9;
    public static final int MIN_RANDOM_NUM = 0;
    public static final int THRESHOLD = 3;
    public static final int MOVE_AMOUNT = 1;
    public static final int NAME_MIN_LENGTH = 5;

    public static final String NAME_OUT_OF_RANGE_ERROR = "자동차의 이름은 1~5자이어야 합니다.";
    public static final String NAME_INVALID_ERROR = "쉼표 외의 특수문자를 입력하시면 안됩니다.";
    public static final String NAME_DUPLICATE_ERROR = "자동차의 이름은 중복되지 않아야 합니다.";
    public static final String ROUND_NUMBER_EMPTY_ERROR = "라운드 회수를 입력해주셔야 합니다.";
    public static final String ROUND_NUMBER_INVALID_ERROR = "라운드 회수를 입력해주셔야 합니다.";

    public static final String REQUEST_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String REQUEST_REPETITION = "시도할 회수는 몇회인가요?";
    public static final String ROUND_RESULT = "실행 결과";
    public static final String WINNER = "최종 우승자";
}
