package racingcar.util.validator;

import racingcar.util.messages.ErrorMessages.CarNameInputErrorMessages;
import racingcar.util.messages.ErrorMessages.TryCountInputErrorMessages;

import java.util.HashSet;
import java.util.List;

public class InputValidator {
    public static void checkCarNameInputValidation(List<String> list) {
        checkIsCarNameListEmpty(list);
        checkCarNameLength(list);
        checkIsCarNameDuplicate(list);
    }

    private static void checkIsCarNameListEmpty(List<String> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException(CarNameInputErrorMessages.LIST_EMPTY_ERROR_MESSAGE.getMessage());
        }
    }

    private static void checkCarNameLength(List<String> list) {
        for (String component : list) {
            checkLengthIsOverFive(component);
        }
    }

    private static void checkLengthIsOverFive(String component) {
        if (component.length() > 5) {
            throw new IllegalArgumentException(CarNameInputErrorMessages.NAME_LENGTH_ERROR_MESSAGE.getMessage());
        }
    }

    private static void checkIsCarNameDuplicate(List<String> list) {
        HashSet<String> set = new HashSet<>(list);
        if (set.size() != list.size()) {
            throw new IllegalArgumentException(CarNameInputErrorMessages.NAME_DUPLICATE_ERROR_MESSAGE.getMessage());
        }
    }

    public static void checkTryCountInputValidation(String text) {
        checkIsTryCountEmpty(text);
        int num = checkIsTryCountWrong(text);
        checkRangeOfTryCount(num);
    }

    private static void checkIsTryCountEmpty(String text) {
        if (text.equals("")) {
            throw new IllegalArgumentException(TryCountInputErrorMessages.EMPTY_ERROR_MESSAGE.getMessage());
        }
    }

    private static int checkIsTryCountWrong(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TryCountInputErrorMessages.WRONG_INPUT_ERROR_MESSAGE.getMessage());
        }
    }

    private static void checkRangeOfTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(TryCountInputErrorMessages.UNDER_ONE_ERROR_MESSAGE.getMessage());
        }
    }
}
