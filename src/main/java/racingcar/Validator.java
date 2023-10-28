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

    public boolean isValidMoveCount(String moveCount) {
        for (int i = 0; i < moveCount.length(); i++) {
            if (!Character.isDigit(moveCount.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
