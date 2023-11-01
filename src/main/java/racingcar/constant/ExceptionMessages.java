package racingcar.constant;

import static racingcar.constant.GameOptions.MAX_NAME_LENGTH;

public class ExceptionMessages {
    public static final String DUPLICATE_NAME_MESSAGE = "중복된 자동차 이름이 없어야 합니다.";
    public static final String NAME_BLANK_MESSAGE = "자동차 이름은 공백일 수 없습니다.";
    public static final String NAME_LEADING_SPACE_MESSAGE = "자동차 이름은 공백으로 시작할 수 없습니다.";
    public static final String NAME_TRAILING_SPACE_MESSAGE = "자동차 이름은 공백으로 끝날 수 없습니다.";
    public static final String NAME_OVER_LIMIT_MESSAGE = "자동차 이름의 길이는 " + MAX_NAME_LENGTH + "이하여야 합니다.";

    public static final String ZERO_NAME_MESSAGE = "적어도 하나의 자동차 이름이 입력되어야 합니다.";
    public static final String NEGATIVE_INTEGER_MESSAGE = "라운드는 0 이상의 정수여야 합니다.";
    public static final String NUMBER_FORMAT_MESSAGE = "라운드는 정수형으로 입력되어야 합니다.";
}
