package racingcar.constant;

public enum ViewConstant {
    USER_INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    USER_INPUT_TRIAL_NUMBER("시도할 회수는 몇회인가요?"),

    USER_OUTPUT_MESSAGE("실행 결과"),
    WINNER_OUTPUT_MESSAGE("최종 우승자 : ");

    private final String message;

    ViewConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
