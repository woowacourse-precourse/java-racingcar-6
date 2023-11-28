package racingcar.type.message;
import static racingcar.type.PlayType.*;
public enum ErrorMessageType {
    INVALID_LENGTH(String.format("이름의 길이는 %s 이상 %s 이하여야 합니다.", MIN_LENGTH, MAX_LENGTH)),
    BLANK_SPACE("이름은 공백이 아니어야 합니다."),
    NO_PARTICIPANT("참가자가 없습니다."),
    INVALID_TYPE("잘못된 타입 입니다."),
    INVALID_RANGE("잘못된 범위 입니다.");

    private final String errorMessageValue;

    ErrorMessageType(String errorMessageValue) { this.errorMessageValue = errorMessageValue; }

    public String getErrorMessageValue() { return errorMessageValue; }
}
