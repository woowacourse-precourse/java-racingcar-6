package racingcar.domain.util;

public enum OutputMessage {

    PRINT_ROUND_RESULT("실행 결과"),
    PRINT_FINAL_WINNER("최종 우승자 : "),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
