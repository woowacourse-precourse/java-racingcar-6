package racingcar.validation;

import racingcar.constant.GameConstantValue;

/**
 * 입력되는 이름의 유효성 검사
 */
public class InputNamesValidation {

    public static String inputNamesValidation(String inputNames) {
        if (isNotNullOrEmpty(inputNames) && isLength(inputNames)) {
            return inputNames;
        }
        throw new IllegalArgumentException();
    }

    public static boolean isLength(String inputNames) {
        String[] names = inputNames.split(",");
        if (names.length == 0) {
            return false;
        }
        for (String name : names) {
            if (name.length() < GameConstantValue.MIN_NAME_LENGTH || name.length() > GameConstantValue.MAX_NAME_LENGTH) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotNullOrEmpty(String inputNames) {
        if (inputNames == null || inputNames.isEmpty()) {
            return false;
        }
        return true;
    }
}
