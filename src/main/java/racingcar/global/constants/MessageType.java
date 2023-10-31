package racingcar.global.constants;

public enum MessageType {
    CAR_NAME_REQUEST_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TOTAL_COUNT_REQUEST_MESSAGE("시도할 횟수는 몇회인가요?"),
    RESULT_MESSAGE("실행 결과"),
    FINAL_RESULT_MESSAGE("최종 우승자 : %s");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
