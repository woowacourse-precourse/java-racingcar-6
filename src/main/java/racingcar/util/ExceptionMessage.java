package racingcar.util;

public enum ExceptionMessage {
    INVALID_GAME_TRY_INPUT("시도할 횟수는 1 이상을 입력해야 합니다."),
    INVALID_NUMERIC_GAME_TRY("시도할 횟수는 숫자를 입력해야 합니다."),
    INVALID_NICKNAME("자동차 이름에 공백은 입력할 수 없습니다."),
    INVALID_NICKNAME_RANGE("자동차 이름은 최대 5글자까지 가능합니다."),
    INVALID_POSITION("position은 음수값을 가질 수 없습니다."),
    INVALID_UNIQUE_NICKNAME("중복된 자동차 이름은 허용되지 않습니다."),
    INVALID_NUMBER_OF_CARS("자동차 이름을 두 개 이상 입력해주세요.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
