package racingcar.util;

public enum OutputMessage {

    CAR_NAME("%s : "),
    FINAL_WINNER("최종 우승자 : %s"),
    CAR_MOVE("-"),
    EXECUTION("\n실행 결과");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage(String carName) {
        return String.format(message, carName);
    }

    public String getMessage() {
        return message;
    }
}
