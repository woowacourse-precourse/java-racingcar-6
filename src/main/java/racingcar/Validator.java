package racingcar;

import java.util.List;

public class Validator {
    public boolean isValidCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                return false;
            }
        }
        return true;
    }
}
