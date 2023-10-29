package racingcar.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Validator {

    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 이름이 있습니다.";
    private static final String HAS_WHITE_SPACE_ERROR_MESSAGE = "[ERROR] 이름에 공백이 존재합니다.";
    private static final String NAME_LENGTH_ERROR_MESSAGE  = "[ERROR] 이름은 1~5자만 가능합니다.";
    private static final String INTEGER_INPUT_ERROR_MESSAGE  = "[ERROR] 정수만 입력 가능합니다.";

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String WHITE_SPACE  = " ";

    public static void inputCarNames(String[] carNameArr) {
        if (hasDuplicates(carNameArr)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
        for (String carName : carNameArr) {
            if (hasWhitespace(carName)) {
                throw new IllegalArgumentException(HAS_WHITE_SPACE_ERROR_MESSAGE);
            }
            if (isInvalidLength(carName)) {
                throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }

    private static boolean hasWhitespace(String carName) {
        return carName.contains(WHITE_SPACE);
    }

    private static boolean isInvalidLength(String carName) {
        return !(MIN_NAME_LENGTH <= carName.length() && carName.length() <= MAX_NAME_LENGTH);
    }

    private static boolean hasDuplicates(String[] carNameArr) {
        List<String> carNameList = arrayToList(carNameArr);
        HashSet<String> carNameSet = new HashSet<>(carNameList);
        return carNameSet.size() != carNameList.size();
    }

    private static List<String> arrayToList(String[] carNameArr) {
        return Arrays.stream(carNameArr).toList();
    }

    public static void isInteger(String attemptCount) {
        try {
            Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INTEGER_INPUT_ERROR_MESSAGE);
        }
    }
}
