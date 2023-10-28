package racingcar;

import java.util.regex.Pattern;

public class Constants {
    public static final int NAME_SIZE = 5;
    public static final int MIN_RANDOM_NUM = 0;
    public static final int MAX_RANDOM_NUM = 9;
    public static final int GO_NUM = 4;

    public static final Pattern TRY_NUM_PATTERN = Pattern.compile("^[1-9][0-9]*$");

    public static final String DELIMETER = ",";
    public static final String ERROR = "ERROR: ";
    public static final String CAR_NAME_SIZE_ERROR_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";
    public static final String INPUT_WRONG_ERROR_MESSAGE = "입력값이 존재하지 않습니다.";
    public static final String INPUT_ONLY_INTEGER_ERROR_MESSAGE = "숫자만 입력 가능합니다.";

    public static final String WINNER_MESSAGE = "최종 우승자 : ";
}
