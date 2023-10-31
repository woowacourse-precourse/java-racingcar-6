package racingcar.exception;

import static racingcar.domain.Name.CAR_LIMIT_NAME_LENGTH;

public enum ErrorMessage {
    NOT_INTEGER("숫자만 입력가능합니다."),
    INVALID_NAME_LENGTH(String.format("이름 길이는 %d 이하만 가능합니다.", CAR_LIMIT_NAME_LENGTH)),
    CANT_FIND_MAX_VALUE("최대 위치를 찾을 수 없습니다."),
    BLANK_NAME("이름은 빈칸일 수 없습니다."),
    NEGATIVE_POSITION("위치가 음수일 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }

}
