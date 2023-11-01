package racingcar.util;

public class InputValidator {
    public static boolean validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateTotalAttempts(int totalAttempts) {
        return totalAttempts > 0;
    }
}
