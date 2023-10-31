package racingcar.domain.enums;

import static racingcar.domain.enums.Constants.MAX_NAME_LENGTH;
import static racingcar.domain.enums.Constants.MIN_RACING_COUNT;

public class Error {
    public static final String INVALID_NAME_LENGTH = "이름의 길이는 " + MAX_NAME_LENGTH + "이하로 입력해야합니다.";
    public static final String INVALID_NAME_BLANK = "이름을 빈값으로 입력하면 안됩니다.";
    public static final String INVALID_MIN_RACE_COUNT = "시도횟수를 " + MIN_RACING_COUNT + "이상으로 입력해야합니다.";
    public static final String DUPLICATE_NAME = "중복된 자동차 이름을 입력하면 안됩니다.";
    public static final String INVALID_NUMBER_FOMMAT = "시도횟수는 숫자로 입력해야합니다.";
}
