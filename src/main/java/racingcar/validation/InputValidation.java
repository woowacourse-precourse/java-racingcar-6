package racingcar.validation;

import java.util.LinkedHashMap;

public class InputValidation {
    public static void checkNameRight(String carName, LinkedHashMap<String, String> carList) {
        if (!isNameLenRight(carName)) {
            throw new IllegalArgumentException("5자 이하의 이름만 가능합니다.");
        }

        if (isNameDuplicate(carName, carList)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    private static boolean isNameLenRight(String carName) {
        if (carName.length() > 5)
            return false;

        return true;
    }

    private static boolean isNameDuplicate(String carName, LinkedHashMap<String, String> carList) {
        if (carList.containsKey(carName))
            return true;

        return false;
    }

    public static int checkCountRight(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
        }
    }
}
