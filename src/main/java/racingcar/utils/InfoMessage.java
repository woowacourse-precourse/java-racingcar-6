package racingcar.utils;

public enum InfoMessage {
    CAR_NAME_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ROUND_INPUT_MESSAGE("시도할 회수는 몇회인가요?"),
    RESULT_MESSAGE("\n실행 결과");
    private final String message;

    InfoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
