package racingcar.domain;

import java.util.HashSet;
import java.util.Set;

public class InputCarValidator {
    boolean invalidateCarName(String carName) {
        return carName.length() > 5 || !carName.matches("^[a-z]+$");
    }

    boolean duplicateCarNames(String[] carNameArray){
        Set<String> uniqueCarNames = new HashSet<>();
        for (String carName : carNameArray) {
            if (uniqueCarNames.contains(carName)) {
                return true;
            }
            uniqueCarNames.add(carName);
        }
        return false;
    }
}
