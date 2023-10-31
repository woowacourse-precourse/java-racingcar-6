package racingcar.constant;

import static racingcar.constant.Constants.MAX_CAR_NAME_LEN;
import static racingcar.constant.Constants.MIN_CAR_NAME_LEN;

public class ExceptionMessage {
    public static final String LENGTH_OUT_OF_RANGE_CAR_NAME = "자동차 이름의 길이는 " + MIN_CAR_NAME_LEN + "이상, " + MAX_CAR_NAME_LEN + "이하여야 합니다.";
    public static final String DUPLICATED_CAR_NAME = "중복된 이름을 입력하였습니다.";
    public static final String NOT_ALLOWED_WORDS_CAR_NAME = "차 이름은 숫자, _, 영어, 한글만 입력 가능합니다.";
    public static final String INVALID_TRIAL_NUMBER = "시도 횟수는 1이상의 숫자만 입력해야 합니다.";
}
