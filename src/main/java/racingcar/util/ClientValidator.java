package racingcar.util;

import java.math.BigInteger;

public class ClientValidator extends Validator {

    public static final int LEAST_NATURAL_NUMBER = 1;

    public static BigInteger getValidatedBigIntegerValue(String inputtedStringTryNumber) {
        BigInteger validatedValue = validateCastToBigInteger(inputtedStringTryNumber);
        validateNaturalNumber(validatedValue);
        return validatedValue;
    }

    private static BigInteger validateCastToBigInteger(String inputtedString) {
        BigInteger value = null;
        try {
            value = new BigInteger(inputtedString);
        } catch (NumberFormatException e) {
            throwIllegalArgumentException(Error.NOT_NUMBER_INPUTTED.getMessage());
        }
        return value;
    }

    private static void validateNaturalNumber(BigInteger value) {
        if (value.compareTo(BigInteger.valueOf(LEAST_NATURAL_NUMBER)) < 0) {
            throwIllegalArgumentException(Error.NOT_NATURAL_NUMBER.getMessage());
        }
    }
}
