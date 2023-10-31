package racingcar.constant;

public enum InputDelimiter {

    PARTICIPANT_INPUT_DELIMITER(",");

    private final String value;

    InputDelimiter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
