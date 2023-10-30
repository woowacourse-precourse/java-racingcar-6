package racingcar.constant;

public final class MessageConstants {

    private MessageConstants() {
        throw new AssertionError(NONE_INSTANTIABLE_CLASS);
    }

    public static final String NONE_INSTANTIABLE_CLASS = "인스턴스화 불가능한 클래스입니다.";
    public static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?";

    public static final String TRY_COUNT_NOT_PROVIDED = "시도할 횟수를 입력해주세요.";
    public static final String TRY_COUNT_NOT_INTEGER = "시도할 횟수는 정수여야 합니다.";
    public static final String TRY_COUNT_NOT_POSITIVE = "시도할 횟수는 양의 정수여야 합니다.";

    public static final String CAR_NAME_NOT_PROVIDED = "자동차 이름을 입력해주세요.";
    public static final String CAR_NAME_ALPHANUMERIC_COMMA_ONLY = "자동차 이름은 영숫자와 콤마로만 구성되어야 합니다.";
    public static final String CAR_NAME_MAX_LENGTH_EXCEEDED = "자동차 이름은 5글자 이하여야 합니다.";
    public static final String CAR_NAME_DUPLICATE = "자동차 이름은 중복될 수 없습니다.";

    public static final String CAR_NAME_REGEX = "[a-zA-Z0-9,]+";
    public static final String PARSE_CAR_NAME_DELIMITER = ",";
    public static final String WINNER_DELIMITER = ", ";
    public static final String WINNER_PREFIX = "최종 우승자";
    public static final String WINNER_SUFFIX = " : ";
    public static final String RESULT = "실행 결과";
    public static final String DASH = "-";

}
