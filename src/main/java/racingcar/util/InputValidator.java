package racingcar.util;

import java.util.List;

public class InputValidator {

    public static boolean isValidInputLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                return true;
            }
            if (carName.length() < 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExistSameName(List<String> carNames) {
        return !(carNames.size() == carNames.stream().distinct().count());
    }

    public static boolean isEmptyString(String userInput) {
        return userInput == null || userInput.trim().isEmpty();
    }

    public static boolean isNotNumber(String numberOfAttempt) {
        return !numberOfAttempt.matches("[0-9]+");
    }

    public static boolean isSmallerThanOne(int numberOfAttempt) {
        return numberOfAttempt <= 0;
    }

}
