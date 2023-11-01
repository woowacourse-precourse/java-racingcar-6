package racingcar.exception;

public enum RaceRoundExceptionMessage {
    ERROR_TOTAL_GAME_ROUND_COUNT("[ERROR] 게임 실행 회수 입력값은 1 이상이어야 합니다.");

    private final String message;

    RaceRoundExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
