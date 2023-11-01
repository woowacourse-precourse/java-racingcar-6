package racingcar.utils;

import racingcar.configuration.ConfigurationConstants;

public enum CarExceptionMessage {
    BLANK_INPUT("공백 입력을 해선 안됩니다."),
    ONLY_BLANK_NAME("자동차 이름은 공백으로만 이루어져선 안됩니다."),
    DUPLICATE_EXISTS("중복된 자동차 이름이 존재합니다."),
    COMMA_EXISTS("자동차 이름에 콤마(,)가 있으면 안됩니다."),
    OUT_OF_NAME_LENGTH("자동차 이름 길이는 1 ~ 5 자리 이어야 합니다."),
    OUT_OF_TOTAL_COUNT(String.format("자동차이름은 %d ~ %d 개만 입력 가능합니다.", ConfigurationConstants.TOTAL_CAR_MIN_LIMIT,
            ConfigurationConstants.TOTAL_CAR_MAX_LIMIT));

    private final String error;

    CarExceptionMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
