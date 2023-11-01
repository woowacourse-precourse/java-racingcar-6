package racingcar;

public class Constant {
    public static final String CAR_NAME_SEPARATOR = ",";
    public static final String BLANK_SPACE = " ";
    public static final String EMPTY_SPACE = "";
    public static final String PRINT_DISTANCE_SEPARATOR = " : ";
    public static final String RESULT_JOIN_SEPARATOR = ", ";
    public static final String DISTANCE = "-";
    public static final int MIN_CAR_NUMBER = 2; // 최소 자동차 개수
    public static final int MAX_CAR_NAME_LENGTH = 5; // 자동차 이름의 최대 길이
    public static final int MIN_ATTEMPT_COUNT = 1; // 최소 시도할 횟수
    public static final int MIN_RANDOM_NUM = 0;
    public static final int MAX_RANDOM_NUM = 9;
    public static final int MOVE_FORWARD_NUM = 4;
    public static final String ENTER_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ENTER_ATTEMPT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String DUPLICATE_CAR_NAME_MESSAGE = "자동차들의 이름 중 중복된 이름이 존재합니다. 게임이 종료됩니다.";
    public static final String BLANK_CAR_NAME_MESSAGE = "자동차 이름에 공백이 포함되어 있습니다. 게임이 종료됩니다.";
    public static final String EMPTY_CAR_NAME_MESSAGE = "비어 있는 자동차 이름이 포함되어 있습니다. 게임이 종료됩니다.";
    public static final String SINGLE_CAR_NAME_MESSAGE = "자동차를 2대 이상 입력해야 합니다. 게임이 종료됩니다.";
    public static final String OVER_MAX_LENGTH_MESSAGE = "자동차 이름이 5자 이상입니다. 게임이 종료됩니다.";
    public static final String INVALID_NUMERIC_INPUT_MESSAGE = "시도할 횟수가 올바른 숫자가 아닙니다. 게임이 종료됩니다.";
    public static final String MINIMUM_ATTEMPT_COUNT_REQUIRED_MESSAGE = "시도할 횟수는 최소 1 이상이어야 합니다. 게임이 종료됩니다.";
    public static final String PRINT_RESULT_MESSAGE = "실행 결과";
    public static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
}
