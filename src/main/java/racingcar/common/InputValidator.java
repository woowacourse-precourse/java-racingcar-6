package racingcar.common;

import java.util.List;

import static racingcar.common.ExceptionConstants.*;
import static racingcar.util.TextUtil.hasDuplicates;
import static racingcar.util.TextUtil.isOverLength;

/**
 * @Class : 입력 유효성 검사 클래스
 */
public class InputValidator {

    public static void validateNameLength(List<String> targetList, int maxSize) {
        if (hasOverLengthString(targetList, maxSize)) {
            throw new IllegalArgumentException(ERROR_TOO_LONG_INPUT);
        }
    }

    public static void validateNoDuplicates(List<String> targetList) {
        if (hasDuplicates(targetList)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_ENTRIES);
        }
    }

    public static int parseInputToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionConstants.ERROR_NON_NUMERIC_INPUT);
        }
    }

    public static void validateMinCount(int target, int minCount) {
        if (target < minCount) {
            throw new IllegalArgumentException(ERROR_NON_POSITIVE_INPUT);
        }
    }

    private static boolean hasOverLengthString(List<String> targetList, int maxLength) {
        return targetList.stream().anyMatch(s -> isOverLength(s, maxLength));
    }
}
