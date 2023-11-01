package racingcar.Constants;

public enum PrintMessage {

    INPUT_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRYNUMBER("시도할 회수는 몇회인가요?"),
    EXECUTE_RESULT("\n실행 결과"),
    COLON(" : "),
    HYPHEN("-"),
    DELIMITER(", "),
    FINAL_WINNER("최종 우승자 : ");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
