package racingcar.constant;

public class ExceptionMessage {
    public static final String BLANK_INPUT = "빈 문자열은 입력할 수 없습니다.";
    public static final String NULL_CAR_NAME = "입력된 문자열 안에 누락된 자동차 이름이 있습니다: ";
    public static final String SPACE_IN_CAR_NAME = "입력된 자동차 이름에 공백이 포함되어 있습니다.";
    public static final String OVER_CAR_NAME_LIMIT = "자동차 이름의 길이는 최대 5글자입니다: ";
    public static final String CAR_NAME_DUPLICATED = "자동차 이름은 서로 중복되지 않아야 합니다: ";
    public static final String NUMERIC_ROUNDS = "문자가 아닌 숫자를 입력해야 합니다: ";
    public static final String ZERO_ROUNDS = "시도 횟수는 0보다 커야 합니다.";
}
