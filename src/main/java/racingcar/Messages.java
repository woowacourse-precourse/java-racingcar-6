package racingcar;

public enum Messages {
    PLEASE_INPUT_RACERS("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    PLEASE_INPUT_TURNS("시도할 회수는 몇회인가요?"),
    RACING_RESULT("실행 결과"),
    WINNER_IS("최종 우승자"),
    ;

    @Override
    public String toString() {
        return message;
    }

    private final String message;

    Messages(String message) {
        this.message = message;
    }
}
