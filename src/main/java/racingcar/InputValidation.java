package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidation {
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        if (hasDuplicates(carNames)) {
            throw new IllegalArgumentException("자동차 이름에 중복된 이름이 있습니다.");
        }

        if (hasConsecutiveCommas(carNames)) {
            throw new IllegalArgumentException("자동차 이름에 연속된 쉼표가 있습니다.");
        }
    }
    public static void validateTryCount(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private static boolean hasDuplicates(String[] arr) {
        Set<String> set = new HashSet<>(Arrays.asList(arr));
        return set.size() != arr.length;
    }

    private static boolean hasConsecutiveCommas(String[] arr) {
        for (String name : arr) {
            if (name.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
