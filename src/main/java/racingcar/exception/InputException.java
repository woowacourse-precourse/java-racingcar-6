package racingcar.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static racingcar.constant.ExceptionMessage.*;
import static racingcar.constant.NumberConstant.*;
import static racingcar.constant.StringConstant.*;

public class InputException {
    public static List<String> checkDuplicationName(List<String> names) {
        List<String> nameList = new ArrayList<>();
        for (String name : names
        ) {
            if (nameList.contains(name)) {
                throw new IllegalArgumentException(INPUT_ERROR_DUPLICATED_CAR_NAME_MESSAGE.getMessage());
            }
            nameList.add(name);
        }
        return nameList;
    }

    public static void checkCarCount(List<String> names) {
        int size = names.size();
        if (size < CAR_COUNT_MIN_SIZE.getNumber()) {
            throw new IllegalArgumentException(INPUT_ERROR_CAR_COUNT_MESSAGE.getMessage());
        }
    }

    public static void checkContainSpace(String name) {
        if (name.contains(SPACE.getMessage())) {
            throw new IllegalArgumentException(INPUT_ERROR_SPACE_MESSAGE.getMessage());
        }
    }

    public static void checkNameType(String name) {
        boolean matches = Pattern.matches(PATTERN.getMessage(), name);
        if (!matches) {
            throw new IllegalArgumentException(INPUT_ERROR_CAR_TYPE_MESSAGE.getMessage());
        }
    }

    public static void checkNameLength(String name) {
        int length = name.length();
        if (length > NAME_LENGTH_MAX_SIZE.getNumber() || length < NAME_LENGTH_MIN_SIZE.getNumber()) {
            throw new IllegalArgumentException(INPUT_ERROR_CAR_NAME_LENGTH_MESSAGE.getMessage());
        }
    }

    public static void checkNumber(int number) {
        if (number < INPUT_MIN_NUMBER.getNumber()) {
            throw new IllegalArgumentException(INPUT_ERROR_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }
}
