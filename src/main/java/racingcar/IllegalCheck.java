package racingcar;

public class IllegalCheck {

    private static final int INPUT_RANGE_MIN = 0;
    private static final int INPUT_RANGE_MAX = Integer.MAX_VALUE;
    private static final int STRING_MAX_LENGTH = 5;

    public boolean integerRangeOverCheck(Long checkIntegerValue) {
        if (INPUT_RANGE_MIN < checkIntegerValue && checkIntegerValue <= INPUT_RANGE_MAX) {
            return true;
        }
        return false;
    }


    public boolean stringLengthOverCheck(String splittedName) {
        return splittedName.length() > STRING_MAX_LENGTH;
    }

    public boolean availableConvertInteger(int thisChar) {
        if (!Character.isDigit(thisChar)) {
            return false;
        }

        return true;
    }
}
