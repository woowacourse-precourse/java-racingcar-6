package racingcar.validation;

public enum ErrorMessage {
    MAXIMUM_NAME_LENGTH("플레이어 이름은 5자 이하이어야 합니다."),
    MINIMUM_NAME_LENGTH("플레이어 이름은 1자 이상이어야 합니다."),
    DUPLICATED_NAME("플레이어 이름은 중복될 수 없습니다."),
    ONLY_PLAYER("플레이어는 최소 2명 이어야 합니다."),
    EMPTY_INPUT("입력값이 없습니다."),
    INVALID_TYPE("숫자만 입력 가능합니다."),
    MINIMUM_PLAY_TIME("시도 횟수는 1번 이상이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}

