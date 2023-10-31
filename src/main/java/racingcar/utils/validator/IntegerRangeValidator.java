package racingcar.utils.validator;

import java.math.BigInteger;

public class IntegerRangeValidator {
    public static boolean validate(String input, int min, int max) {
        try {
            BigInteger value = new BigInteger(input);

            if (value.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0 ||
                    value.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
                return false;
            }

            int intValue = value.intValue();
            return intValue >= min && intValue <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
