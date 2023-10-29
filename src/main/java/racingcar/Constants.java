package racingcar;

import java.util.regex.Pattern;

public class Constants {
    public static final int MIN_RANDOM_NUM = 0;
    public static final int MAX_RANDOM_NUM = 9;
    public static final int START_NUM = 4;
    public static final int NAME_SIZE = 5;
    public static final String NAME_PATTERN = "[a-zA-Z]+";

    public static final String NAME_SIZE_ERROR = "자동차 이름은 1자 이상 5자 이하의 알파벳 문자여야 합니다.";
    public static final String ROUND_SIZE_ERROR = "시도 횟수는 1 이상 이어야 합니다.";
    public static final String NAME_DUPLICATE_ERROR ="중복된 자동차 이름이 있습니다.";
}
