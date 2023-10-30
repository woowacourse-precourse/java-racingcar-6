package racingcar.enums;

public enum Message {
    CAR_NAME_INPUT_PROMPT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRIAL_COUNT_INPUT_PROMPT("시도할 회수는 몇회인가요?"),
    RUN_RESULT("실행 결과"),
    FINAL_WINNER("최종 우승자");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
