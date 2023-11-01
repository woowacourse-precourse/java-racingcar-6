package racingcar.exception;

public enum ExceptionMessage {
    INPUT_BLANK("[ERROR] 입력값이 빈 문자열 또는 공백입니다.\n"),
    NAME_BLANK("[ERROR] 이름을 입력해주세요.\n"),
    NAME_DUPLICATION("[ERROR] 중복된 이름입니다.\n"),
    NAME_LENGTH("[ERROR] 이름은 5자 이하만 가능합니다.\n"),
    INPUT_FORMAT("[ERROR] 1이상의 숫자만 입력해주세요.\n"),
    MAX_NOT_EXIST("[ERROR] 최대값이 존재하지 않습니다.\n");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public GameException getException() {
        return new GameException(this.message);
    }
}
