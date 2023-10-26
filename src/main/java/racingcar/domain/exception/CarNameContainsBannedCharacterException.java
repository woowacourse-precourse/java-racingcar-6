package racingcar.domain.exception;

public final class CarNameContainsBannedCharacterException extends IllegalArgumentException {

    public static final String CAR_NAME_CONTAINS_BANNED_CHARACTER_EXCEPTION_MESSAGE = "차 이름은 공백이 포함될 수 없습니다.";

    public CarNameContainsBannedCharacterException() {
        super(CAR_NAME_CONTAINS_BANNED_CHARACTER_EXCEPTION_MESSAGE);
    }
}
