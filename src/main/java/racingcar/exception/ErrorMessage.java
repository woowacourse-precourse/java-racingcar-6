package racingcar.exception;

import static racingcar.domain.RacingCar.MAX_RACING_CAR_NAME_LENGTH;

public enum ErrorMessage {

    INVALID_CAR_NAMES("자동차 이름은 쉼표로 구분되어야 합니다."),
    INVALID_CAR_NAME_LENGTH(String.format("자동차 이름은 %d자 이하여야 합니다.", MAX_RACING_CAR_NAME_LENGTH)),
    INVALID_CAR_NAME_EMPTY("자동차 이름은 공백일 수 없습니다."),
    INVALID_SPACES_BETWEEN_COMMA("쉼표 뒤에 공백 없이 입력해주세요."),
    INVALID_INPUT_NUMBER("양의 정수를 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
