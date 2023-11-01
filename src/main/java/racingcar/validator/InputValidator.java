package racingcar.validator;

import java.util.List;

public class InputValidator {
    public static boolean isValidCarName(String carName) {

        if (checkEmptyOrNull(carName) || !checkCarNameLenghth(carName)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private static boolean checkEmptyOrNull(String carName) {
        return carName == null || carName.isEmpty();
    }

    private static boolean checkCarNameLenghth(String carName) {
        List<String> namesList = List.of(carName.split(","));
        for (String name : namesList) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidAttempts(String attempts) {
        try {
            int numberAttempts = Integer.parseInt(attempts);
            if (numberAttempts <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
