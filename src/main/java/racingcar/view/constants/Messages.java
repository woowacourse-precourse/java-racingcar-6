package racingcar.view.constants;

public enum Messages {
    ASK_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_PLAY_TIME("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과"),
    FINAL_WINNER("최종 우승자 : ");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}