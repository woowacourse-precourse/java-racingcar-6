package racingcar.constant;

import static racingcar.constant.GameNumber.ATTEMPT_MINIMUM;
import static racingcar.constant.GameNumber.NAME_LENGTH_LIMIT;

public class ExceptionMessage {
    public static final String INVALID_NAME_EXCEPTION = "이름이 유효하지 않습니다.";
    public static final String BLANK_EXCEPTION = "공백을 입력하였습니다.";
    public static final String LENGTH_EXCEPTION = "이름은 " + NAME_LENGTH_LIMIT + "자 이내로 입력해주세요.";
    public static final String DUPLICATE_EXCEPTION = "중복된 이름이 있습니다.";
    public static final String NON_NUMBER_EXCEPTION = "정수를 입력해주세요.";
    public static final String NON_POSITIVE_NUMBER_EXCEPTION = ATTEMPT_MINIMUM + " 이상의 정수를 입력해주세요.";
}
