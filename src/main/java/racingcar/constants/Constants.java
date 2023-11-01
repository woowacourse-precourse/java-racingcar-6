package racingcar.constants;

public enum Constants {
    MAX_NAME_LENGTH(5),
    MIN_MOVE_NUMBER(4),
    RANDOM_MIN_RANGE(0),
    RANDOM_MAX_RANGE(9),

    CAR_NAMES_PROMPT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ROUNDS_PROMPT("시도할 회수는 몇회인가요?"),
    CAR_STATE_FORMAT("%s : %s"),
    WINNER_MESSAGE("최종 우승자 : %s"),
    CAR_POSITION_SYMBOL("-"),
    CAR_DELIMITER(","),
    NAME_SEPARATOR(", ");



    private final Object value;

    Constants(Object value) {
        this.value = value;
    }

    public <T> T getValue() {
        return (T) value;
    }
}