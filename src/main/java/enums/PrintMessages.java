package enums;

public enum PrintMessages {

    CAR_NAME_PROMPT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT_PROMPT("시도할 회수는 몇회인가요?"),
    EXECUTION_RESULT("실행 결과");

    private final String message;

    PrintMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}