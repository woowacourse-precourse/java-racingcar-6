package racingcar.io;

public enum ConsoleMessage {
    REQUEST_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REQUEST_LOOP_COUNT("시도할 횟수는 몇회인가요?"),
    RESPONSE_LOOP_RESULT("실행 결과"),
    RESPONSE_WINNER("최종 우승자 : ");

    private final String message;

    ConsoleMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
