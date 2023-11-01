package racingcar;

import java.util.regex.Pattern;

public final class Constants {
    public static final String DELIMITER = ",";
    public static final int VALID_LENGTH  = 5;
    public static final int MINIMUM_LENGTH  = 4;
    public static final Pattern NAMES_STRING_PATTERN  = Pattern.compile("^[가-힣\\w]+(?:(?<!"+ DELIMITER + ")" + DELIMITER + "[가-힣\\w]+)*$");
    public static final Pattern ROUND_NUM_PATTERN = Pattern.compile("^[1-9][0-9]*$");
    public static final String ERROR = "[ERROR] ";
    public static final String ROUND_NUM_ERROR = ERROR + "1 이상의 숫자여야합니다";
    public static final String INVALID_LENGTH_ERROR = ERROR + "자동차 이름은 5자 이하만 가능합니다.";
    public static final String INVALID_STRING_FORMAT_ERROR = ERROR + "이름 형식이 잘못 되었습니다";
    public static final String INVALID_DUPLICATE_ERROR = ERROR + "중복 입력은 안됩니다";

    private Constants() {}
}
