package racingcar.validate;

import java.util.List;

public class Validator {
    public static void validateLenOfCarNames(List<String> carNameList) {
        for (String name : carNameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static void validateNumOfCars(List<String> carNameList) {
        if (carNameList.size() < 2) {
            throw new IllegalArgumentException("최소 2대의 자동차 이름이 필요합니다.");
        }
    }
}