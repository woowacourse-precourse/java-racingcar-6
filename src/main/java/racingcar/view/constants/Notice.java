package racingcar.view.constants;

public enum Notice {
    ASK_MULTIPLE_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_RESTART_OR_EXIT("시도할 회수는 몇회인가요?"),
    RESPONSE_RESULT_MESSAGE("실행 결과");

    private final String message;

    Notice(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
