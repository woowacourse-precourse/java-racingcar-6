package racingcar.validation;

import java.util.LinkedHashMap;
import racingcar.GameNumber;

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
        return carName.length() <= GameNumber.NAME_LENGTH.getNumber();
    }

    private static boolean isNameDuplicate(String carName, LinkedHashMap<String, String> carList) {
        return carList.containsKey(carName);
    }

    public static int checkCountRight(String input) {
        try {
            int totalCount = Integer.parseInt(input);

            if (totalCount <= 0) {
                throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
            }

            return totalCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
        }
    }
}
