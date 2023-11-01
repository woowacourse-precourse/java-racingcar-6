package racingcar.variable;

public class MagicVariable {
    public static final int PICK_NUM_MIN = 0;
    public static final int PICK_NUM_MAX = 9;
    public static final int FORWARD_NUM = 4;
    public static final String RACE_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String CAR_NAME_RULE = "^[a-z]{1,5}$";
    public static final String CAR_DUPLICATE_ERROR_MESSAGE = "자동차 이름에 중복된 값이 있습니다.";
    public static final String CAR_NAME_ERROR_MESSAGE = "자동차 이름은 공백없이 1자 이상 5자 이하의 소문자만 가능합니다.";
    public static final String ASK_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String TRY_COUNT_RANGE_ERROR_MESSAGE = "시도할 횟수는 1회 이상이어야 합니다.";
}
