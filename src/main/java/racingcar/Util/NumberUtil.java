package racingcar.Util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.regex.Pattern;

public class NumberUtil {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final String TRY_NUMBER_IS_NOT_POSITIVE = "입력한 시도 횟수가 양수가 아닙니다.";

    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";

    private NumberUtil() {
    }

    public static int create() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public static void validateNumber(String input) {
        if (!Pattern.matches(REGEXP_PATTERN_NUMBER, input)) {
            throw new IllegalArgumentException(TRY_NUMBER_IS_NOT_POSITIVE);
        }
    }
}
