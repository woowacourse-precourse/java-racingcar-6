package racingcar.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputConvertor {
    private static final String COMMA_SEPARATOR = ",";
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_EXCEED_ERROR = "이름의 제한 길이를 초과했습니다.";
    private static final String NAME_DUPLICATION_ERROR = "이름의 중복은 허용하지 않습니다.";
    private static final String INVALID_NAME_FORMAT_ERROR = "적절하지 않은 이름 형식입니다.";
    private static final String INVALID_NATURAL_NUMBER = "유효한 숫자를 입력해주세요.";
    private static final String INVALID_TRY_COUNT = "시도 횟수는 1 이상이어야 합니다.";
    private static final String CAR_NAME_INPUT_REGEX = "^[a-zA-Z0-9,가-힣]+$";

    public static String[] separateInputToNames(String userInput) {
        String[] split = userInput.split(COMMA_SEPARATOR);
        List<String> validNames = getNames(split);
        checkNameDuplication(validNames);
        return validNames.toArray(new String[0]);
    }

    private static List<String> getNames(String[] split) {
        List<String> validNames = new ArrayList<>();

        for (String name : split) {
            name = name.trim();
            checkNameValidation(name);
            checkNameLength(name);
            validNames.add(name);
        }
        return validNames;
    }

    private static void checkNameValidation(String carName) {
        if (!carName.matches(CAR_NAME_INPUT_REGEX)) {
            throw new IllegalArgumentException(INVALID_NAME_FORMAT_ERROR);
        }
    }

    private static void checkNameLength(String name) {
        if (isNameExceedLength(name)) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEED_ERROR);
        }
    }

    private static boolean isNameExceedLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    private static void checkNameDuplication(List<String> validNames) {
        Set<String> nameSet = new HashSet<>(validNames);
        if (!isSameSize(validNames, nameSet)) {
            throw new IllegalArgumentException(NAME_DUPLICATION_ERROR);
        }
    }

    private static boolean isSameSize(List<String> validNames, Set<String> nameSet) {
        return nameSet.size() == validNames.size();
    }

    public static int parseTryCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NATURAL_NUMBER);
        }
    }

    public static void isTryCountNaturalNumber(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT);
        }
    }
}
