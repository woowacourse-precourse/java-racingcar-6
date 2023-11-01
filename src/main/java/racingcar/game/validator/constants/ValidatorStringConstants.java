package racingcar.game.validator.constants;

public enum ValidatorStringConstants {
    INTEGER_REGULAR_EXPRESSION("^[0-9]*$");

    final String value;

    ValidatorStringConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
