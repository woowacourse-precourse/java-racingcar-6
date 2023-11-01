package racingcar.constant;

public enum Console {
    INIT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과"),
    WINNER("최종 우승자 : "),
    SEPARATOR(" : "),
    PROGRESS("-"),
    INPUT_DELIMITER(","),
    PRINT_DELIMITER(", ");

    private final String message;

    Console(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
