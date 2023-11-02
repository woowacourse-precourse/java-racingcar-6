package racingcar;

import java.util.List;

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

    public static boolean blankCheck(String inputLine) {
        if (inputLine.length() == 0) {
            return false;
        }

        if (!middleBlankCheck(inputLine)) {
            return false;
        }

        return true;
    }

    public static boolean middleBlankCheck(String inputLine) {
        if (inputLine.length() != inputLine.trim().length()) {
            return false;
        }

        if (inputLine.contains(" ")) {
            return false;
        }

        return true;
    }

    public boolean stringLengthOverCheck(String splittedName) {
        if (splittedName.length() > STRING_MAX_LENGTH) {
            return false;
        }

        return true;
    }

    public boolean availableConvertInteger(int thisChar) {
        if (!Character.isDigit(thisChar)) {
            return false;
        }

        return true;
    }

    public boolean duplicateNameCheck(List<String> splittedNames) {
        int splittedNamesSize = splittedNames.size();
        int splittedNamesFilteredSize = splittedNames.stream()
                .distinct()
                .toList()
                .size();

        if (splittedNamesSize != splittedNamesFilteredSize) {
            return false;
        }

        return true;
    }
}
