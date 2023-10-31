package racingcar.enums;

public enum InputMessage {
    INPUT_CAR_NAMES_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ATTEMPT_NUMBER_MESSAGE("시도할 횟수는 몇회인가요?");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
