package racingcar.domain;

import java.util.HashSet;
import java.util.Set;

public class InputCarValidator {
    public static String[] carsByStringToArray(String inputAllCars) {
        return inputAllCars.split(",");
    }

    public static Set<String> checkDuplicateCarName(String[] cars) {
        Set<String> carSet = new HashSet<>();
        for (String car : cars) {
            validateDuplicate(car, carSet);
            carSet.add(car);
        }
        return carSet;
    }

    public static void validateDuplicate(String car, Set<String> carSet) {
        if (carSet.contains(car)) {
            throw new IllegalArgumentException("자동차 이름은 중복이 될 수 없습니다.");
        }
    }
}
