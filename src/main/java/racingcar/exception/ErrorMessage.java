package racingcar.exception;

import racingcar.domain.RaceAttempts;
import racingcar.domain.RacingCar;

public enum ErrorMessage {
    INPUT_IS_EMPTY("입력값은 비어있을 수 없습니다."),
    INPUT_NOT_A_NUMBER("입력값은 숫자여야 합니다."),
    INPUT_NOT_POSITIVE_NUMBER("입력값은 자연수여야 합니다."),

    CAR_NAMES_NOT_EMPTY("자동차 이름은 비어있을 수 없습니다."),
    INVALID_CAR_NAME_LENGTH(
            String.format("자동차 이름은 %d~%d자만 가능합니다.", RacingCar.NAME_MIN_LENGTH, RacingCar.NAME_MAX_LENGTH)),
    CAR_NAME_DUPLICATE("자동차 이름은 중복될 수 없습니다."),

    INVALID_RACE_ATTEMPTS(String.format("시도 횟수는 %d이상이어야 합니다.", RaceAttempts.MIN_ATTEMPTS));


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
