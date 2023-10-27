package racingcar.validator;

public class ErrorMessage {
    public static final String NULL_ERROR = "아무런 값을 입력하지 않았습니다.";
    public static final String ONLY_COMMA = "자동차 이름은 쉼표(,)를 기준으로 구분해야 합니다.";
    public static final String NAME_BETWEEN_ONE_AND_FIVE = "자동차 이름은 1 ~ 5글자로 입력해야 합니다.";
    public static final String NOT_ALLOW_NAME_REPLACED_BLANK = "자동차 이름을 공백으로 입력해선 안됩니다.";
    public static final String NOT_ALLOW_BLANK_IN_START = "첫 글자를 공백으로 사용할 수 없습니다.";
    public static final String NOT_ALLOW_BLANK_IN_END = "마지막 글자를 공백으로 사용할 수 없습니다.";
    public static final String NOT_ALLOW_NAME_DUPLICATION = "중복된 이름을 입력할 수 없습니다.";
    public static final String TRY_COUNT_ONY_NUMBER = "횟수는 숫자만 입력할 수 있습니다.";
    public static final String TRY_COUNT_GT_ZERO = "게임 시도 횟수는 0보다 커야 합니다.";
    public static final String TRY_COUNT_NOT_ALLOW_ZERO_IN_FIRST = "게임 시도 횟수의 첫 번째 숫자는 0이 될 수 없습니다.";
}
