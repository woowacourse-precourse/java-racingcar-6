package racingcar.view.enums;

public enum ResultMessage {
    RACING_RESULT("실행 결과"),
    RACING_WINNER("최종 우승자 : %s");

    private final String value;

    ResultMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
