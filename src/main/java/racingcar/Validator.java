package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    static void carNames(String[] carNames) throws IllegalArgumentException {
        List<String> uniqueCarNames = new ArrayList<>();
        for (String carName : carNames) {
            carName = carName.trim();
            if (carName.isEmpty()) {
                throw new IllegalArgumentException();
            }
            if (carName.contains(" ")) {
                throw new IllegalArgumentException();
            }
            if (carName.length() > Constant.CARNAME_MAX_LENGTH) {
                throw new IllegalArgumentException();
            }
            if (uniqueCarNames.contains(carName)) {
                throw new IllegalArgumentException();
            } else {
                uniqueCarNames.add(carName);
            }
        }
    }

    static int tryCountInput(String tryCountString) throws IllegalArgumentException {
        try {
            return Integer.parseInt(tryCountString);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
