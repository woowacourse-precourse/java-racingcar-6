package racingcar.constant;

public enum ConsoleMessage {
    ENTER_CAR_NAMES("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)"),
    ENTER_CYCLE("시도할 회수는 몇회인가요?"),
    RACE_RESULT_HEADER("실행 결과"),
    RACE_WINNER_ANNOUNCEMENT("최종 우승자");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
