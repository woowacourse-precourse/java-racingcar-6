package racingcar.domain;

import java.math.BigInteger;
import racingcar.util.BlankValidator;

public class AttemptCountValidator {
    private static final String PLEASE_NOT_INPUT_BETWEEN_NUMBER_BLANK = "숫자사이에 공백을 입력하지 마세요";
    private static final String PLEASE_INPUT_NATURAL_NUMBER = "자연수를 입력해주세요";
    private static final String NUMBER_OUT_OF_RANGE = "너무 크거나 작은 수를 입력했습니다.";
    private final BlankValidator blankValidator;

    public AttemptCountValidator(BlankValidator blankValidator) {
        this.blankValidator = blankValidator;
    }

    public int getAttemptCount(String attemptCountInput) {
        blankValidator.isEmpty(attemptCountInput);
        String trimmedCount = attemptCountInput.trim();
        ensureNoInternalSpaces(trimmedCount);
        int convertedValue = convertToInt(trimmedCount);
        return isNaturalNumber(convertedValue);
    }

    private void ensureNoInternalSpaces(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(PLEASE_NOT_INPUT_BETWEEN_NUMBER_BLANK);
        }
    }

    private BigInteger convertToBigInteger(String input) {
        try {
            return new BigInteger(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PLEASE_INPUT_NATURAL_NUMBER, e);
        }
    }

    private int convertToInt(String input) {
        BigInteger bigIntegerValue = convertToBigInteger(input);
        if (bigIntegerValue.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0 ||
                bigIntegerValue.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE);
        }
        return bigIntegerValue.intValue();
    }

    private int isNaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(PLEASE_INPUT_NATURAL_NUMBER);
        }
        return number;
    }
}


