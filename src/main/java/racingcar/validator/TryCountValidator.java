package racingcar.validator;

public class TryCountValidator {

    public int checkInput(String tryCount) {
        checkPositiveNumeric(tryCount);
        return parseTryCountOrThrow(tryCount);
    }

    private void checkPositiveNumeric(String tryCount) {
        if (!tryCount.matches("\\d+")) {
            throw new IllegalArgumentException("Try count input is invalid");
        }
    }

    private int parseTryCountOrThrow(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Try count input is invalid");
        }
    }
}
