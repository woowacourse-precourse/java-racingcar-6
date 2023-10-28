package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class CarNameSeperator {

    private static final String DILIMITER =",";
    private static final String DOUBLE_DELIMITER = ",,";

    public List<String> seperateCarNames(final String input) {
        validateNoName(input);
        StringTokenizer stringtokenizer = new StringTokenizer(input, DILIMITER);
        List<String> result = new ArrayList<>();

        while (stringtokenizer.hasMoreTokens()) {
            result.add(stringtokenizer.nextToken());
        }

        return result;
    }

    private void validateNoName(final String input) {
        if (input.startsWith(DILIMITER) || input.endsWith(DILIMITER) || input.contains(DOUBLE_DELIMITER)) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_IS_BLANK.getMessage());
        }
    }
}
