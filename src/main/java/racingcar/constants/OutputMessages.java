package racingcar.constants;

public enum OutputMessages {
    REQUEST_CAR_NAMES("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)"),
    REQUEST_TRY_COUNT("시도할 회수는 몇회인가요?"),
    START_RESULT("실행 결과"),
    FINAL_WINNER("최종 우승자 : ");

    private final String message;

    OutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
