package calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int INDEX_OF_TEXT = 2;
    private static final int INDEX_OF_DELIMITER = 1;
    private static final int MINIMUM_NUMBER = 0;
    private static final int MINIMUM_LENGTH = 1;
    private static final int DEFAULT_VALUE_FOR_NULL_OR_EMPTY = 0;
    private static final String REGEX = ",|:";
    private static final Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");

    public static int addString(String inputString) {
        if (isNullOrEmpty(inputString)) {
            return DEFAULT_VALUE_FOR_NULL_OR_EMPTY;
        }

        if (hasSingleNumber(inputString)) {
            return validateNumber(stringToInt(inputString));
        }

        Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            return sum(splitByDelimiter(matcher));
        }

        return sum(inputString.split(REGEX));
    }

    private static int stringToInt(String inputString) {
        return Integer.parseInt(inputString);
    }

    private static boolean isNullOrEmpty(String inputString) {
        return Objects.isNull(inputString) || inputString.isEmpty();
    }

    private static boolean hasSingleNumber(String inputString) {
        return inputString.length() == MINIMUM_LENGTH;
    }

    private static int validateNumber(int number) {
        if (number < MINIMUM_NUMBER) {
            throw new RuntimeException("1 이상의 수만 입력할 수 있습니다.");
        }
        return number;
    }

    private static String[] splitByDelimiter(Matcher matcher) {
        String delimiter = matcher.group(INDEX_OF_DELIMITER);
        return matcher.group(INDEX_OF_TEXT).split(delimiter);
    }

    private static int sum(String[] numbersOfString) {
        return Arrays.stream(numbersOfString).mapToInt(stringNumber -> validateNumber(stringToInt(stringNumber))).sum();
    }
}
