package racingcar.utils.validator;

public class CarCommonValidator implements Validator<String>{
    public CarCommonValidator() {}

    @Override
    public void validate(final String value) {
        this.validateNotEmpty(value);
    }

    private void validateNotEmpty(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
