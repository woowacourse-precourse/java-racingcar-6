package racingcar.domain.validator;

public class RoundNumberValidator implements InputValidator<String> {

    @Override
    public void validate(String target) {
        checkType(target);
    }

    private void checkType(String target) {
        if (!canConvertToInteger(target)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean canConvertToInteger(String target) {
        try {
            Integer.parseInt(target);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
