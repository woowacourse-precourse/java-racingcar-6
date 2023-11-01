package racingcar.constant;

import static racingcar.configuration.InputFormatConfig.MAX_LENGTH_OF_CAR_NAME;

public class ErrorMessage {
    public static final String CAR_NAME_LENGTH_EXCESS_EXCEPTION
            = "자동차 이름은 " + MAX_LENGTH_OF_CAR_NAME + "글자 이하여야 합니다.";
}
