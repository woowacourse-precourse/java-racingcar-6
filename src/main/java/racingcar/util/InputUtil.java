package racingcar.util;

import java.util.List;

public class InputUtil {
    public static String[] splitCarName(String carName) {
        return validateCarName(carName);
    }

    private static String[] validateCarName(String carName) {
        String[] carNameStrings = carName.split(",");

        for (String carNameStr : carNameStrings) {
            if (carNameStr.length() > 5 || carNameStr.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능하다.");
            }
        }

        return carNameStrings;
    }
}
