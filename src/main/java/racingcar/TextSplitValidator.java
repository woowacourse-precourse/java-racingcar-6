package racingcar;

import java.util.regex.Pattern;

public class TextSplitValidator {

    private static final String SPLIT_DELIMITER = ",";
    private static final Pattern SPLIT_PATTERN = Pattern.compile(".*" + SPLIT_DELIMITER + ".*");

    public static void validate(final String words) {
        if (isNullOrEmpty(words) || !isSeparable(words)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNullOrEmpty(final String words) {
        return words == null || words.isBlank();
    }

    private static boolean isSeparable(final String words) {
        return SPLIT_PATTERN.matcher(words).matches();
    }
}
