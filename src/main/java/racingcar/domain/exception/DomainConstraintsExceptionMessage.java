package racingcar.domain.exception;

import static racingcar.domain.constant.GameValueConstant.CAR_NAME_MAX_LENGTH;
import static racingcar.global.Constants.ERROR_PREFIX;

public enum DomainConstraintsExceptionMessage {
    CAR_NAME_LENGTH_EXCEEDS_LIMIT("차 이름의 길이가 " + CAR_NAME_MAX_LENGTH.getValue() + " 초과입니다."),
    CAR_NAME_IS_DUPLICATED("중복된 차량 이름이 입력 되었습니다."),
    EMPTY_CARS("차량 리스트가 비어있습니다.");

    private final String message;

    DomainConstraintsExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}