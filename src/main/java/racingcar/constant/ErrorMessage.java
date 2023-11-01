package racingcar.constant;

import static racingcar.configuration.InputFormatConfig.MAX_LENGTH_OF_CAR_NAME;

public class ErrorMessage {
    public static final String CAR_NAME_LENGTH_EXCESS_EXCEPTION
            = "자동차 이름은 " + MAX_LENGTH_OF_CAR_NAME + "글자 이하여야 합니다.";
    public static final String INVALID_NUMBER_FORMAT_EXCEPTION = "시도할 회수는 양의 정수 값만 입력할 수 있습니다. 예 : 1";
}
