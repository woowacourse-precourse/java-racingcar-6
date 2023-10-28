package racingcar;

import java.util.List;

public class Validator {
    private final int MAX_NAME_LENGTH = 5;
    public boolean isValidCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_NAME_LENGTH) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidTryCount(String tryCount) {
        for (int i = 0; i < tryCount.length(); i++) {
            if (!Character.isDigit(tryCount.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
