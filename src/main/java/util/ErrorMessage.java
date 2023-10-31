package util;

public class ErrorMessage {
    public static final String ERROR = "[ERROR] ";
    public static final String CAR_COUNT_ERROR = ERROR + "자동차의 개수는 2개 이상이어야 한다.";
    public static final String CAR_NAME_DUPLICATE_ERROR = ERROR + "자동차의 이름은 중복될 수 없다.";
    public static final String CAR_NAME_SIZE_ERROR = ERROR + "자동차의 이름은 1글자 이상 5글자 이하여야 한다.";
    public static final String CAR_NAME_SPACE_ERROR = ERROR + "자동차의 이름은 공백문자로만 이루어질 수 없다.";
    public static final String CAR_NAME_COMMA_ERROR = ERROR + "자동차의 이름은 컴마로만 이루어질 수 없다.";

}
