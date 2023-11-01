package racingcar.exception;

public enum ViewExceptionMessage {
    ERROR_NOT_NUMBER("[ERROR] 숫자 이외의 값을 입력할 수 없습니다."),
    ERROR_GAME_ROUND_SMALL_THAN_ONE("[ERROR] 입력할 수 있는 실행 회수는 1 이상의 숫자입니다."),
    ERROR_GAME_ROUND_BLANK("[ERROR] 공백을 입력할 수 없습니다."),
    ERROR_NAMES_SMALL_THAN_TWO("[ERROR] 이름은 최소 2개 이상 입력하셔야 합니다."),
    ERROR_NOT_LETTER("[ERROR] 이름에 글자 이외의 문자를 입력할 수 없습니다.");

    private final String message;

    ViewExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
