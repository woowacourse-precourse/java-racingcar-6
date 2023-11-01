package racingcar.Util;

import static racingcar.Util.Constants.DUPLICATED;
import static racingcar.Util.Constants.HAS_BLANK;
import static racingcar.Util.Constants.MAX_LENGTH_NAME;
import static racingcar.Util.Constants.MORE_THAN_MAXLENGTH;
import static racingcar.Util.Constants.UNVALID_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exceptions {
    public static void isDuplicated(List<String> nameList) {
        Set<String> nameSet = new HashSet<String>(nameList);
        if (nameSet.size() != nameList.size()) {
            throw new IllegalArgumentException(DUPLICATED);
        }
    }

    public static void isBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(HAS_BLANK);
        }
    }

    public static void isLessThanMaxLength(String name) {
        if (name.length() > MAX_LENGTH_NAME) {
            throw new IllegalArgumentException(MORE_THAN_MAXLENGTH);
        }
    }

    public static void isPositiveNumber(int num) {
        if (num < 0) {
            throw new IllegalArgumentException(UNVALID_NUMBER);
        }
    }
}
