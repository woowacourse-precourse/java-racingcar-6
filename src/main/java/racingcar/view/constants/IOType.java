package racingcar.view.constants;

public enum IOType {
    REQUEST_CAR_NAMES_SENTENCE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REQUEST_ATTEMPTS_NUMBER_SENTENCE("시도할 회수는 몇회인가요?"),
    ALERT_EXECUTION_RESULT_SENTENCE("실행 결과"),
    SPLIT_DELIMITER(","),
    REMOVE_WHITE_SPACE_REGEX("\\s+"),
    DISTANCE_POLE_CHAR("-"),
    WINNER_DELIMITER(", ");

    private final String text;

    IOType(String text) {
        this.text = text;
    }


    public String getText() {
        return text;
    }

}
