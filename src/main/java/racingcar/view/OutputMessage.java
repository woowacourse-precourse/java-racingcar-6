package racingcar.view;

public enum OutputMessage {
    REQUEST_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REQUEST_NUMBER_OF_TRY("시도할 회수는 몇회인가요?"),
    RACE_RESULT("실행 결과"),
    WINNER_IS("최종 우승자 : ");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}
