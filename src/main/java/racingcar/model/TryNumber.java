package racingcar.model;

public class TryNumber {
    private static final int MIN_TRY_NUMBER = 1;
    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "숫자만 입력 가능합니다";
    private static final String NOT_NATURAL_NUMBER_EXCEPTION_MESSAGE = "자연수만 입력 가능합니다";
    private final int tryNumber;

    public TryNumber(String number) {
        validate(number);
        this.tryNumber = Integer.parseInt(number);
    }

    private void validate(String number) {
        validateIsNumber(number);
        validateIsNaturalNumber(number);
    }

    private void validateIsNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void validateIsNaturalNumber(String number) {
        int tryNumber = Integer.parseInt(number);
        if (tryNumber < MIN_TRY_NUMBER) {
            throw new IllegalArgumentException(NOT_NATURAL_NUMBER_EXCEPTION_MESSAGE);
        }
    }

}
