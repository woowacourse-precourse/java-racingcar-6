package racingcar.utils;

import racingcar.constants.AppConstants;

import java.util.List;

public class InputValidationUtil {
    public static void validateCarNameList(List<String> nameList) {
        for (String name : nameList) {
            validateCarName(name);
        }
        validateDistinctNamesList(nameList);
    }

    public static void validateCarName(String name) {
        if (!hasValue(name)) {
            throw new IllegalArgumentException(AppConstants.ERR_NAME_CANNOT_BE_BLANK);
        }
        if (!isValidLength(name)) {
            throw new IllegalArgumentException(AppConstants.ERR_INVALID_NAME_LENGTH);
        }
    }

    private static void validateDistinctNamesList(List<String> nameList) {
        if (nameList.stream().distinct().count() < nameList.size()) {
            throw new IllegalArgumentException(AppConstants.ERR_DUPLICATE_NAME_EXISTS);
        }
    }

    public static boolean hasValue(String str) {
        return str != null && !str.isEmpty() && !str.isBlank();
    }

    public static boolean isValidLength(String str) {
        return str.length() <= AppConstants.NAME_LENGTH_LIMIT;
    }

    public static int validateAndParseRound(String str) {
        if (! hasValue(str)) {
            throw new IllegalArgumentException(AppConstants.ERR_ROUND_CANNOT_BE_BLANK);
        }

        try {
            int val = Integer.parseInt(str);
            if (val < 1) {
                throw new IllegalArgumentException(AppConstants.ERR_INVALID_ROUND_LOWER);
            }
            return val;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(AppConstants.ERR_INVALID_ROUND_NUMBER);
        }
    }

}
