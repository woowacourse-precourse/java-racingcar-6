package racingcar.Validator;

public enum CarNameValidationCriteria {
    MAX_LENGTH(5),
    MIN_LENGTH(1),
    INVALID_CHARACTER(" ");


    private final Object value;

    CarNameValidationCriteria(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
