package racingcar.utils.validate;

import static racingcar.constant.ExceptionMessage.NAME_CONTAINS_BLANK;
import static racingcar.constant.ExceptionMessage.NAME_LENGTH_NOT_IN_RANGE;
import static racingcar.constant.ExceptionMessage.ROUND_CONTAIN_NOT_ONLY_NUM;
import static racingcar.constant.ExceptionMessage.ROUND_MUST_BE_POSITIVE;
import static racingcar.constant.InputNumConstant.MAX_NAME_LENGTH;
import static racingcar.constant.InputNumConstant.MIN_NAME_LENGTH;

import racingcar.constant.InputStringConstant;

public class InputValidator {

    public static void validateName(String[] nameArr) {
        for (String name : nameArr) {
            if (!checkNameLengthInRange(name)) {
                throw new IllegalArgumentException(NAME_LENGTH_NOT_IN_RANGE.getMessage());
            }

            if (checkContainBlank(name)) {
                throw new IllegalArgumentException(NAME_CONTAINS_BLANK.getMessage());
            }
        }
    }

    public static void validateRoundNum(String roundNum) {
        if (!checkOnlyNumInString(roundNum)) {
            throw new IllegalArgumentException(ROUND_CONTAIN_NOT_ONLY_NUM.getMessage());
        }

        if (!checkNumIsZeroOrNegative(roundNum)) {
            throw new IllegalArgumentException(ROUND_MUST_BE_POSITIVE.getMessage());
        }
    }

    private static boolean checkNameLengthInRange(String name) {
        return name.length() >= MIN_NAME_LENGTH.getValue() && name.length() <= MAX_NAME_LENGTH.getValue();
    }

    private static boolean checkOnlyNumInString(String subject) {
        try {
            Integer.parseInt(subject);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static boolean checkNumIsZeroOrNegative(String num) {
        return Integer.parseInt(num) < 0;
    }

    private static boolean checkContainBlank(String input) {
        return input.contains(InputStringConstant.BLANK.getValue());
    }
}
