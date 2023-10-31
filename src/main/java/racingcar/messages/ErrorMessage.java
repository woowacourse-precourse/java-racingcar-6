package racingcar.messages;

public class ErrorMessage {
    private static String ERROR_TAG = "[ERROR] ";

    public static String CAR_NAMES_NOT_UNIQUE = ERROR_TAG + "자동차 이름은 중복될 수 없습니다.";
    public static String CAR_NAME_LENGTH_OUT_OF_RANGE = ERROR_TAG + "자동차 이름은 1~5자만 가능합니다.";

    public static String TRY_COUNT_NOT_INTEGER = ERROR_TAG + "시도 회수는 21474836470이하 정수만 가능합니다.";
    public static String TRY_COUNT_NOT_POSITIVE = ERROR_TAG + "시도 횟수는 1이상만 가능합니다.";
}
