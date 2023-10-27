package racingcar;

import java.util.List;

public class Validation {
    String carName;

    public boolean isLessThanSix(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            carName = carNames.get(i);
            if (carName.length() > 5) {
                return false;
            }
        }
        return true;
    }
}
