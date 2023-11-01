package racingcar.util;

import java.util.Arrays;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";

    public void validateInputCarNames(String[] names) {
        if (hasEmptyCarName(names)) {
            throw new IllegalArgumentException("이름은 공백으로만 이루어질 수 없습니다.");
        }

        if (isDuplicate(names)) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    public boolean hasEmptyCarName(String[] names) {
        for (String name : names) {
            if (name.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean isNaturalNumber(String number) {
        return Pattern.matches(REGEXP_PATTERN_NUMBER, number);
    }

    public boolean isDuplicate(String[] names) {
        return names.length != Arrays.stream(names).distinct().count();

    }
}
