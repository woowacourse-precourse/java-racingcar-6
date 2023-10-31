package racingcar.domain;

public enum ErrorMessage {
    NAME_LENGTH_MIN_LIMIT("자동차 이름의 길이는 1 이상여야 합니다."),
    NAME_LENGTH_MAX_LIMIT("자동차 이름의 길이는 5 이하여야 합니다."),
    PLAYER_NUMBER("최소 2명의 플레이어가 필요합니다."),
    COUNT_NUMBER_SIGN("시도 횟수는 양수여야 합니다.");

    static private final String ERROR_FORMAT = "[ERROR] %s";
    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = String.format(ERROR_FORMAT, errorMessage);
    }

    @Override
    public String toString() {
        return errorMessage;
    }
}
