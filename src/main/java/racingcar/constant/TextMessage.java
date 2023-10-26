package racingcar.constant;

public enum TextMessage {

    RACING_CAR_NAME_INPUT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

    public final String message;

    TextMessage(final String message) {
        this.message = message;
    }
}
