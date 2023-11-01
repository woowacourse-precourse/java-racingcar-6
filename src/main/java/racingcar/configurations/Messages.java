package racingcar.configurations;

public enum Messages {
    INPUT_CAR_NAMES_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_NUMBER_OF_ROUNDS_MESSAGE("시도할 회수는 몇회인가요?"),
    ROUND_STATE_MESSAGE("실행 결과"),
    WINNER_MESSAGE("최종 우승자"),
    COLON(" : "),
    WHEEL_MARK("-"),
    COMMA(", ");



    String message;

    Messages(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
