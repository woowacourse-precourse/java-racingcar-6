package constant;

import static constant.ConstantNumber.MAX_NAME_LENGTH;

public class ExceptionString {
    public static String MAX_LENGTH_EXCEEDED_MESSAGE = String.format("자동차 이름 길이가 %d를 초과했습니다.", MAX_NAME_LENGTH.getValue());
    public static String EMPTY_NAME_MESSAGE = "자동차 이름이 공백입니다.";
    public static String DUPLICATE_NAME_MESSAGE = "자동차 이름이 중복이 존재합니다.";

    public static String INVALID_ATTEMPT_MEESAGE = "시도 횟수가 잘못 되었습니다.";
}
