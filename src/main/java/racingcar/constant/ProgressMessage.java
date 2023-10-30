package racingcar.constant;

public enum ProgressMessage {
    RACING_CAR_NAMES_REQUEST("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT_REQUEST("시도할 횟수는 몇회인가요?"),
    NEW_LINE("\n"),
    RESULT(NEW_LINE.message + "실행 결과"),
    MOVE_EXPRESSION("-"),
    NAME_STATUS_DELIMITER(" : "),
    WINNERS_MESSAGE_PREFIX("최종 우승자 : ");

    private final String message;

    ProgressMessage(final String message) {
        this.message = message;
    }

    public String toValue() {
        return this.message;
    }
}
