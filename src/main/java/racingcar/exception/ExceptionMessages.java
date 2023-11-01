package racingcar.exception;

import static racingcar.model.CarConstants.LIMIT_NAME_SIZE;

public enum ExceptionMessages {
    INPUT_ONLY_NUMBERS("숫자를 입력해 주세요."),
    LIMIT_CAR_NAME_SIZE("Car 객체의 name 속성은 " + LIMIT_NAME_SIZE + "자 이하만 가능합니다."),
    DISTANCE_NOT_FOUND("해당하는 스타일을 찾을 수 없습니다.");

    private final String message;

    ExceptionMessages(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
